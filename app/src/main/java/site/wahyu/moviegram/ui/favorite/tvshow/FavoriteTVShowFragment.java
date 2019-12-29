package site.wahyu.moviegram.ui.favorite.tvshow;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import io.supercharge.shimmerlayout.ShimmerLayout;
import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.connector.vo.Resource;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;
import site.wahyu.moviegram.databinding.FavoriteTVShowBinding;
import site.wahyu.moviegram.ui.favorite.FavoriteViewModel;
import site.wahyu.moviegram.utils.helper.ViewModelFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FavoriteTVShowFragment extends Fragment {

    private FavoriteTVShowBinding bind;
    private FavoriteTVShowAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_tvshow, container, false);
        return bind.getRoot();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){

            adapter = new FavoriteTVShowAdapter();
            showSkeleton(true);
            retrieveTVShowViewModel();

            int currentOrientation = getResources().getConfiguration().orientation;

            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE)
                bind.rvMovieMore.setLayoutManager(new GridLayoutManager(getContext(), 5));
            else
                bind.rvMovieMore.setLayoutManager(new GridLayoutManager(getContext(), 3));

            bind.rvMovieMore.setHasFixedSize(true);
            bind.rvMovieMore.setAdapter(adapter);

            bind.swipeRefresh.setOnRefreshListener(() -> new Handler().postDelayed(() -> bind.swipeRefresh.setRefreshing(false),3000));
        }
    }

    private void retrieveTVShowViewModel() {
        if(getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            FavoriteViewModel favoriteViewModel =
                    ViewModelProviders.of(getActivity(), factory)
                            .get(FavoriteViewModel.class);

            favoriteViewModel.getAllFavoriteTVShow().observe(this, tvshow -> {
                if (tvshow != null){
                    switch (tvshow.status){
                        case LOADING:
                            showSkeleton(false);
                        case SUCCESS:
                            adapter.submitList(tvshow.data);
                            adapter.notifyDataSetChanged();
                            isEmpty(tvshow);
                        case ERROR:
                            Log.d(TAG, "retrieveMovieViewModel: failed to load data");
                            break;
                    }
                }

            });
        }
    }

    private void showSkeleton(boolean status){
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

    private void isEmpty(Resource<PagedList<FavoriteTVShowEntity>> data){
        if (data.data == null){
            bind.imgEmpty.setVisibility(View.VISIBLE);
        } else {
            if (data.data.size() == 0)
                bind.imgEmpty.setVisibility(View.VISIBLE);
            else
                bind.imgEmpty.setVisibility(View.GONE);
        }

    }
}
