package site.wahyu.moviegram.ui.movie.nowplayingmovie;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import io.supercharge.shimmerlayout.ShimmerLayout;
import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.databinding.MovieMoreBinding;
import site.wahyu.moviegram.ui.movie.detail.MovieDetailActivity;
import site.wahyu.moviegram.utils.config.Config;
import site.wahyu.moviegram.utils.helper.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingMovieFragment extends Fragment implements NowPlayingMovieAdapter.OnNowPlayingMovieItemClicked {

    private MovieMoreBinding bind;
    private NowPlayingMovieAdapter nowPlayingMovieAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_more, container, false);
        return bind.getRoot();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){

            nowPlayingMovieAdapter = new NowPlayingMovieAdapter();
            showSkeletonNowPlaying(true);
            retrieveNowPlayingMovieViewModel();

            int currentOrientation = getResources().getConfiguration().orientation;

            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE)
                bind.rvMovieMore.setLayoutManager(new GridLayoutManager(getContext(), 5));
            else
                bind.rvMovieMore.setLayoutManager(new GridLayoutManager(getContext(), 3));

            bind.rvMovieMore.setHasFixedSize(true);
            bind.rvMovieMore.setAdapter(nowPlayingMovieAdapter);

            bind.swipeRefresh.setOnRefreshListener(() -> new Handler().postDelayed(() -> bind.swipeRefresh.setRefreshing(false),3000));
        }
    }

    private void retrieveNowPlayingMovieViewModel() {
        if(getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            NowPlayingMovieViewModel nowPlayingViewModel = ViewModelProviders.of(getActivity(), factory).get(NowPlayingMovieViewModel.class);

            nowPlayingViewModel.getMoreNowPlayingMovie().observe(this, movies -> {
                nowPlayingMovieAdapter.setListMovie(movies, true);
                nowPlayingMovieAdapter.notifyDataSetChanged();
                nowPlayingMovieAdapter.setClickHandler(this);
                showSkeletonNowPlaying(false);
            });
        }
    }

    @Override
    public void nowPlayingMovieItemClicked(Movie m) {
        Intent detailMovieActivityIntent = new Intent(getActivity(), MovieDetailActivity.class);
        detailMovieActivityIntent.putExtra(Config.EXTRA_MOVIES, m);
        startActivity(detailMovieActivityIntent);
    }

    private void showSkeletonNowPlaying(boolean status){
        ShimmerLayout shimmerText1 = bind.shimmerText1;
        ShimmerLayout shimmerText2 = bind.shimmerText2;
        ShimmerLayout shimmerText3 = bind.shimmerText3;
        SwipeRefreshLayout swipeRefresh = bind.swipeRefresh;

        if (status){
            shimmerText1.startShimmerAnimation();
            shimmerText2.startShimmerAnimation();
            shimmerText3.startShimmerAnimation();
        }else{
            shimmerText1.setVisibility(View.INVISIBLE);
            shimmerText2.setVisibility(View.INVISIBLE);
            shimmerText3.setVisibility(View.INVISIBLE);
            swipeRefresh.setVisibility(View.VISIBLE);
        }
    }
}
