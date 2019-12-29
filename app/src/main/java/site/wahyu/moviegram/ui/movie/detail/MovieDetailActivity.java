package site.wahyu.moviegram.ui.movie.detail;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.supercharge.shimmerlayout.ShimmerLayout;
import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.databinding.MovieDetailBinding;
import site.wahyu.moviegram.service.AddToFavoriteMovieNotification;
import site.wahyu.moviegram.service.SaveImage;
import site.wahyu.moviegram.utils.GlideApp;
import site.wahyu.moviegram.utils.config.Config;
import site.wahyu.moviegram.utils.helper.ViewModelFactory;

public class MovieDetailActivity extends AppCompatActivity {

    MovieDetailBinding bind;
    private FavoriteMovieEntity favoriteMovieEntity, temp;
    private String imgSource;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        bind = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);

        showSkeleton(true);

        Movie movie = getIntent().getParcelableExtra(Config.EXTRA_MOVIES);
        assert movie != null;
        retrieveDetailMovieViewModel(movie.getId());

        bind.btnFavorite.setOnClickListener(view -> {
            saveFavoriteMovie(movie.getId());
            sendNotificationService(movie);
        });

        bind.imgDownload.setOnClickListener(view -> {
            if (ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
                downloadImageService();
            } else {
                downloadImageService();
            }
        });
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private void retrieveDetailMovieViewModel(int id) {
        ViewModelFactory factory = ViewModelFactory.getInstance(getApplication());
        MovieDetailViewModel detailViewModel = ViewModelProviders.of(this, factory).get(MovieDetailViewModel.class);

        detailViewModel.getDetailMovie(id).observe(this, movies -> {

            bind.tvTitle.setText(movies.getTitle());
            bind.tvDate.setText(convertDate(movies));
            bind.tvDesc.setText(movies.getOverview());
            GlideApp.with(this)
                    .load(Config.URL_IMG_TM_DB_ORIGINAL + "/" + movies.getPoster_path() + "?api_key=" + Config.API_KEY)
                    .placeholder(R.color.colorText)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .fallback(R.color.colorAccent)
                    .error(R.color.colorAccent)
                    .into(bind.imgPoster);
            imgSource = Config.URL_IMG_TM_DB_ORIGINAL + "/" + movies.getPoster_path() + "?api_key=" + Config.API_KEY;

            showSkeleton(false);
            checkFavoriteButton(id);

            favoriteMovieEntity = new FavoriteMovieEntity(movies.getId(), movies.getPoster_path(), movies.getTitle(), movies.getOverview(), movies.getRelease_date());
        });
    }

    private void showSkeleton(boolean status){
        ShimmerLayout shimmerText1 = bind.shimmerText1;
        ShimmerLayout shimmerText2 = bind.shimmerText2;
        ShimmerLayout shimmerText3 = bind.shimmerText3;
        ShimmerLayout shimmerText4 = bind.shimmerText4;
        ShimmerLayout shimmerText5 = bind.shimmerText5;
        ImageView imageView = bind.imgPoster;
        Button btnFavorite = bind.btnFavorite;

        if (status){
            shimmerText1.startShimmerAnimation();
            shimmerText2.startShimmerAnimation();
            shimmerText3.startShimmerAnimation();
            shimmerText4.startShimmerAnimation();
            shimmerText5.startShimmerAnimation();
        }else{
            shimmerText1.setVisibility(View.INVISIBLE);
            shimmerText2.setVisibility(View.INVISIBLE);
            shimmerText3.setVisibility(View.INVISIBLE);
            shimmerText4.setVisibility(View.INVISIBLE);
            shimmerText5.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
            btnFavorite.setVisibility(View.VISIBLE);
        }
    }

    private String convertDate(Movie movie){
        @SuppressLint("SimpleDateFormat") DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressLint("SimpleDateFormat") DateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
        String startDateStr = movie.getRelease_date();
        try {
            Date date = inputFormat.parse(startDateStr);
            assert date != null;
            String startDateStrNewFormat = outputFormat.format(date);
            movie.setRelease_date(startDateStrNewFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "Release Date : "+ movie.getRelease_date();
    }

    private void checkFavoriteButton(int id){
        observeViewModel().getFromFavorite(id).observe(this, movies -> {
            if (movies == null){
                bind.btnFavorite.setText(getResources().getString(R.string.btn_add_favorite));
                bind.btnFavorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorSuccess)));
            }else{
                bind.btnFavorite.setText(getResources().getString(R.string.btn_remove_favorite));
                bind.btnFavorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDanger)));
            }
        });
    }

    private void saveFavoriteMovie(int id){
        observeViewModel().getFromFavorite(id).observe(this, movies -> this.temp = movies);

        if (temp == null){
            observeViewModel().saveToFavorite(favoriteMovieEntity);
            bind.btnFavorite.setText(getResources().getString(R.string.btn_remove_favorite));
            bind.btnFavorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDanger)));
        }else{
            observeViewModel().removeFromFavorite(id);
            bind.btnFavorite.setText(getResources().getString(R.string.btn_add_favorite));
            bind.btnFavorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorSuccess)));
        }
    }

    public MovieDetailViewModel observeViewModel(){
        ViewModelFactory factory = ViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(MovieDetailViewModel.class);
    }

    public void downloadImageService(){
        Toast.makeText(this, "Downloading ...", Toast.LENGTH_LONG).show();
        Data data = new Data.Builder()
                .putString(SaveImage.KEY_IMAGE_URI, imgSource)
                .build();
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(SaveImage.class)
                .setInputData(data)
                .build();
        WorkManager.getInstance().enqueue(oneTimeWorkRequest);
    }

    private void sendNotificationService(Movie movie){
        ComponentName serviceName = new ComponentName(
                getPackageName(),
                AddToFavoriteMovieNotification.class.getName()
        );

        PersistableBundle bundle = new PersistableBundle();
        bundle.putInt("id", movie.getId());
        bundle.putString("poster_path", movie.getPoster_path());
        bundle.putString("title", movie.getTitle());
        bundle.putString("overview", movie.getOverview());
        bundle.putString("release_date", movie.getRelease_date());
        bundle.putString("notif_title", "Save to favorite");
        bundle.putString("notif_description", "We have save your favorite movie");

        JobInfo jobInfo = new JobInfo.Builder(0, serviceName)
                .setExtras(bundle)
                .setOverrideDeadline(0)
                .build();

        JobScheduler mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        if (mScheduler != null) {
            mScheduler.schedule(jobInfo);
        }
    }
}
