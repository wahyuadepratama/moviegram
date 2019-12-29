package site.wahyu.moviegram.ui.tvshow;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import io.supercharge.shimmerlayout.ShimmerLayout;
import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.databinding.MovieMoreBinding;
import site.wahyu.moviegram.ui.tvshow.detail.TVShowDetailActivity;
import site.wahyu.moviegram.utils.config.Config;
import site.wahyu.moviegram.utils.helper.ViewModelFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment implements TVShowAdapter.OnTvShowItemClicked {

    private MovieMoreBinding bind;
    private TVShowAdapter tvShowAdapter;

    public TVShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_more, container, false);
        return bind.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){

            tvShowAdapter = new TVShowAdapter();
            showSkeletonTVShow(true);
            retrieveTVShowViewModel();

            int currentOrientation = getResources().getConfiguration().orientation;

            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE)
                bind.rvMovieMore.setLayoutManager(new GridLayoutManager(getContext(), 5));
            else
                bind.rvMovieMore.setLayoutManager(new GridLayoutManager(getContext(), 3));

            bind.rvMovieMore.setHasFixedSize(true);
            bind.rvMovieMore.setAdapter(tvShowAdapter);
        }
    }

    @Override
    public void tvShowItemClicked(TVShow m) {
        Intent detailTVShowActivityIntent = new Intent(getActivity(), TVShowDetailActivity.class);
        detailTVShowActivityIntent.putExtra(Config.EXTRA_TV_SHOW, m);
        startActivity(detailTVShowActivityIntent);
    }

    private void retrieveTVShowViewModel() {
        if(getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            TVShowViewModel nowPlayingViewModel = ViewModelProviders.of(getActivity(), factory).get(TVShowViewModel.class);

            nowPlayingViewModel.getTVShow().observe(this, tvshow -> {
                tvShowAdapter.setListTvShow(tvshow);
                tvShowAdapter.notifyDataSetChanged();
                tvShowAdapter.setClickHandler(this);
                showSkeletonTVShow(false);
            });
        }
    }

    private void showSkeletonTVShow(boolean status){
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
