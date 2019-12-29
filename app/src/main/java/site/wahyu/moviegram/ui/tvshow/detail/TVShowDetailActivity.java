package site.wahyu.moviegram.ui.tvshow.detail;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.supercharge.shimmerlayout.ShimmerLayout;
import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.databinding.TVShowDetailBinding;
import site.wahyu.moviegram.utils.GlideApp;
import site.wahyu.moviegram.utils.config.Config;
import site.wahyu.moviegram.utils.helper.ViewModelFactory;

public class TVShowDetailActivity extends AppCompatActivity {

    private TVShowDetailBinding bind;
    private FavoriteTVShowEntity favoriteTVShowEntity, temp;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_chevron_left_white);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        bind = DataBindingUtil.setContentView(this, R.layout.activity_tvshow_detail);

        showSkeleton(true);

        TVShow parcel = getIntent().getParcelableExtra(Config.EXTRA_TV_SHOW);
        assert parcel != null;
        retrieveDetailTVShowViewModel(parcel.getId());
        bind.btnFavorite.setOnClickListener(view -> saveFavoriteTVShow(parcel.getId()));
    }

    @SuppressLint("SetTextI18n")
    private void retrieveDetailTVShowViewModel(int id) {
        observeViewModel().getDetailTVShow(id).observe(this, tvShow -> {

            bind.tvTitle.setText(tvShow.getName());
            bind.tvDate.setText(convertDate(tvShow));
            bind.tvDesc.setText(tvShow.getOverview());
            GlideApp.with(this)
                    .load(Config.URL_IMG_TM_DB_ORIGINAL + "/" + tvShow.getPoster_path() + "?api_key=" + Config.API_KEY)
                    .placeholder(R.color.colorText)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .fallback(R.color.colorAccent)
                    .error(R.color.colorAccent)
                    .into(bind.imgPoster);

            showSkeleton(false);
            checkFavoriteButton(id);
            favoriteTVShowEntity = new FavoriteTVShowEntity(tvShow.getId(), tvShow.getPoster_path(), tvShow.getName(), tvShow.getOverview(), tvShow.getFirst_air_date());
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

    private String convertDate(TVShow tvshow){
        @SuppressLint("SimpleDateFormat") DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressLint("SimpleDateFormat") DateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy");
        String startDateStr = tvshow.getFirst_air_date();
        try {
            Date date = inputFormat.parse(startDateStr);
            assert date != null;
            String startDateStrNewFormat = outputFormat.format(date);
            tvshow.setFirst_air_date(startDateStrNewFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "Release Date : "+ tvshow.getFirst_air_date();
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

    private void saveFavoriteTVShow(int id){
        observeViewModel().getFromFavorite(id).observe(this, movies -> {
            this.temp = movies;
        });

        if (temp == null){
            observeViewModel().saveToFavorite(favoriteTVShowEntity);
            bind.btnFavorite.setText(getResources().getString(R.string.btn_remove_favorite));
            bind.btnFavorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDanger)));
        }else{
            observeViewModel().removeFromFavorite(id);
            bind.btnFavorite.setText(getResources().getString(R.string.btn_add_favorite));
            bind.btnFavorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorSuccess)));
        }
    }

    public TVShowDetailViewModel observeViewModel(){
        ViewModelFactory factory = ViewModelFactory.getInstance(getApplication());
        return ViewModelProviders.of(this, factory).get(TVShowDetailViewModel.class);
    }
}
