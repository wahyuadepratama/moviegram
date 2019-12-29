package site.wahyu.moviegram.ui.movie;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Objects;

import io.supercharge.shimmerlayout.ShimmerLayout;
import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.databinding.MovieFragmentBinding;
import site.wahyu.moviegram.ui.history.HistoryActivity;
import site.wahyu.moviegram.ui.home.HomeActivity;
import site.wahyu.moviegram.ui.movie.detail.MovieDetailActivity;
import site.wahyu.moviegram.ui.movie.nowplayingmovie.NowPlayingMovieAdapter;
import site.wahyu.moviegram.ui.movie.nowplayingmovie.NowPlayingMovieViewModel;
import site.wahyu.moviegram.ui.movie.topratedmovie.TopRatedMovieAdapter;
import site.wahyu.moviegram.ui.movie.topratedmovie.TopRatedMovieViewModel;
import site.wahyu.moviegram.ui.movie.upcomingmovie.UpcomingMovieAdapter;
import site.wahyu.moviegram.ui.movie.upcomingmovie.UpcomingMovieViewModel;
import site.wahyu.moviegram.ui.setting.SettingActivity;
import site.wahyu.moviegram.utils.config.Config;
import site.wahyu.moviegram.utils.helper.ViewModelFactory;

import static site.wahyu.moviegram.utils.config.Config.DEFAULT_HISTORY;
import static site.wahyu.moviegram.utils.config.Config.DEFAULT_REMINDER_NOTIFICATION;
import static site.wahyu.moviegram.utils.config.Config.HISTORY;
import static site.wahyu.moviegram.utils.config.Config.REMINDER_NOTIFICATION;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements NowPlayingMovieAdapter.OnNowPlayingMovieItemClicked, UpcomingMovieAdapter.OnUpcomingMovieItemClicked, TopRatedMovieAdapter.OnTopRatedMovieItemClicked {

    private MovieFragmentBinding bind;

    private NowPlayingMovieAdapter nowPlayingMovieAdapter;
    private UpcomingMovieAdapter upcomingMovieAdapter;
    private TopRatedMovieAdapter topRatedMovieAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = DataBindingUtil.inflate(inflater, R.layout.content_fragment_movie, container, false);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {

            // Get data from view model
            nowPlayingMovieAdapter = new NowPlayingMovieAdapter();
            upcomingMovieAdapter = new UpcomingMovieAdapter();
            topRatedMovieAdapter = new TopRatedMovieAdapter();

            //Show skeleton
            showSkeletonNowPlaying(true);
            showSkeletonUpcoming(true);
            showSkeletonTopRated(true);

            retrieveNowPlayingMovieViewModel();
            retrieveUpcomingMovieViewModel();
            retrieveTopRatedMovieViewModel();

            bind.rvNowPlaying.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            bind.rvNowPlaying.setHasFixedSize(true);
            bind.rvNowPlaying.setAdapter(nowPlayingMovieAdapter);

            bind.rvTop.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            bind.rvTop.setHasFixedSize(true);
            bind.rvTop.setAdapter(topRatedMovieAdapter);

            bind.rvUpcoming.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            bind.rvUpcoming.setHasFixedSize(true);
            bind.rvUpcoming.setAdapter(upcomingMovieAdapter);

            actionBarMenuClicked();

            SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getActivity());
            boolean notif = sh.getBoolean(REMINDER_NOTIFICATION, DEFAULT_REMINDER_NOTIFICATION);
            boolean history = sh.getBoolean(HISTORY, DEFAULT_HISTORY);

            Toast.makeText(getActivity(), "notif: "+notif, Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "history: "+history, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void nowPlayingMovieItemClicked(Movie m) {
        Intent detailMovieActivityIntent = new Intent(getActivity(), MovieDetailActivity.class);
        detailMovieActivityIntent.putExtra(Config.EXTRA_MOVIES, m);
        startActivity(detailMovieActivityIntent);
    }

    @Override
    public void topRatedMovieItemClicked(Movie m) {
        Intent detailMovieActivityIntent = new Intent(getActivity(), MovieDetailActivity.class);
        detailMovieActivityIntent.putExtra(Config.EXTRA_MOVIES, m);
        startActivity(detailMovieActivityIntent);
    }

    @Override
    public void upcomingMovieItemClicked(Movie m) {
        Intent detailMovieActivityIntent = new Intent(getActivity(), MovieDetailActivity.class);
        detailMovieActivityIntent.putExtra(Config.EXTRA_MOVIES, m);
        startActivity(detailMovieActivityIntent);
    }

    private void retrieveNowPlayingMovieViewModel() {
        if(getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            NowPlayingMovieViewModel nowPlayingViewModel = ViewModelProviders.of(getActivity(), factory).get(NowPlayingMovieViewModel.class);

            nowPlayingViewModel.getNowPlayingMovie().observe(this, movies -> {
                nowPlayingMovieAdapter.setListMovie(movies, false);
                nowPlayingMovieAdapter.notifyDataSetChanged();
                nowPlayingMovieAdapter.setClickHandler(this);
                showSkeletonNowPlaying(false);
            });
        }
    }

    private void retrieveUpcomingMovieViewModel() {
        if(getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            UpcomingMovieViewModel upcomingMovieViewModel = ViewModelProviders.of(getActivity(), factory).get(UpcomingMovieViewModel.class);

            upcomingMovieViewModel.getUpcomingMovie().observe(this, movies -> {
                upcomingMovieAdapter.setListMovie(movies, false);
                upcomingMovieAdapter.notifyDataSetChanged();
                upcomingMovieAdapter.setClickHandler(this);
                showSkeletonUpcoming(false);
            });
        }
    }

    private void retrieveTopRatedMovieViewModel() {
        if(getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            TopRatedMovieViewModel topRatedMovieViewModel = ViewModelProviders.of(getActivity(), factory).get(TopRatedMovieViewModel.class);

            topRatedMovieViewModel.getTopRatedMovie().observe(this, movies -> {
                topRatedMovieAdapter.setListMovie(movies, false);
                topRatedMovieAdapter.notifyDataSetChanged();
                topRatedMovieAdapter.setClickHandler(this);
                showSkeletonTopRated(false);
            });
        }
    }

    private void showSkeletonNowPlaying(boolean status){
        ShimmerLayout shimmerText1 = bind.shimmerText1;
        ShimmerLayout shimmerText2 = bind.shimmerText2;
        ShimmerLayout shimmerText3 = bind.shimmerText3;

        if (status){
            shimmerText1.startShimmerAnimation();
            shimmerText2.startShimmerAnimation();
            shimmerText3.startShimmerAnimation();
        }else{
            shimmerText1.setVisibility(View.INVISIBLE);
            shimmerText2.setVisibility(View.INVISIBLE);
            shimmerText3.setVisibility(View.INVISIBLE);
        }
    }

    private void showSkeletonUpcoming(boolean status){
        ShimmerLayout shimmerText4 = bind.shimmerText4;
        ShimmerLayout shimmerText5 = bind.shimmerText5;
        ShimmerLayout shimmerText6 = bind.shimmerText6;

        if (status){
            shimmerText4.startShimmerAnimation();
            shimmerText5.startShimmerAnimation();
            shimmerText6.startShimmerAnimation();
        }else{
            shimmerText4.setVisibility(View.INVISIBLE);
            shimmerText5.setVisibility(View.INVISIBLE);
            shimmerText6.setVisibility(View.INVISIBLE);
        }
    }

    private void showSkeletonTopRated(boolean status){
        ShimmerLayout shimmerText7 = bind.shimmerText7;
        ShimmerLayout shimmerText8 = bind.shimmerText8;
        ShimmerLayout shimmerText9 = bind.shimmerText9;

        if (status){
            shimmerText7.startShimmerAnimation();
            shimmerText8.startShimmerAnimation();
            shimmerText9.startShimmerAnimation();
        }else{
            shimmerText7.setVisibility(View.INVISIBLE);
            shimmerText8.setVisibility(View.INVISIBLE);
            shimmerText9.setVisibility(View.INVISIBLE);
        }
    }

    private void actionBarMenuClicked(){
        ImageView topMenu = ((HomeActivity) Objects.requireNonNull(getActivity())).findViewById(R.id.menu);
        topMenu.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(getContext(), topMenu);
            popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case R.id.setting:
                        Intent moveToSetting = new Intent(getActivity(), SettingActivity.class);
                        startActivity(moveToSetting);
                        break;
                    case R.id.history:
                        Intent moveToHistory = new Intent(getActivity(), HistoryActivity.class);
                        startActivity(moveToHistory);
                        break;
                }
                return true;
            });

            popup.show();
        });
    }
}
