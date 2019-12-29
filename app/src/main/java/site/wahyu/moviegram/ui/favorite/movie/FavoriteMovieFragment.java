package site.wahyu.moviegram.ui.favorite.movie;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.Objects;

import io.supercharge.shimmerlayout.ShimmerLayout;
import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.connector.vo.Resource;
import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.local.room.SortUtils;
import site.wahyu.moviegram.databinding.FavoriteMovieBinding;
import site.wahyu.moviegram.ui.favorite.FavoriteViewModel;
import site.wahyu.moviegram.ui.home.HomeActivity;
import site.wahyu.moviegram.utils.helper.ViewModelFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FavoriteMovieFragment extends Fragment {

    private FavoriteMovieBinding bind;
    private FavoriteMovieAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite_movie, container, false);
        return bind.getRoot();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null){

            adapter = new FavoriteMovieAdapter();
            showSkeleton(true);
            retrieveMovieViewModel();

            int currentOrientation = getResources().getConfiguration().orientation;

            if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE)
                bind.rvMovieMore.setLayoutManager(new GridLayoutManager(getContext(), 5));
            else
                bind.rvMovieMore.setLayoutManager(new GridLayoutManager(getContext(), 3));

            bind.rvMovieMore.setHasFixedSize(true);
            bind.rvMovieMore.setAdapter(adapter);

            bind.swipeRefresh.setOnRefreshListener(() ->
                    new Handler().postDelayed(() -> bind.swipeRefresh.setRefreshing(false),3000)
            );

            actionBarMenuClicked();
        }
    }

    private void actionBarMenuClicked(){
        ImageView topMenu = ((HomeActivity) Objects.requireNonNull(getActivity())).findViewById(R.id.menu);
        topMenu.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(getContext(), topMenu);
            popup.getMenuInflater().inflate(R.menu.filter_favorite_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()){
                    case R.id.order_by_title:
                        filterMovieViewModel(SortUtils.TITLE);
                        break;
                    case R.id.random_order:
                        filterMovieViewModel(SortUtils.RANDOM);
                        break;
                }
                return true;
            });

            popup.show();
        });
    }

    private void retrieveMovieViewModel() {
        if(getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            FavoriteViewModel favoriteViewModel =
                    ViewModelProviders.of(getActivity(), factory)
                    .get(FavoriteViewModel.class);

            favoriteViewModel.getAllFavoriteMovie().observe(this, movies -> {
                if (movies != null){
                    switch (movies.status){
                        case LOADING:
                            showSkeleton(false);
                        case SUCCESS:
                            adapter.submitList(movies.data);
                            adapter.notifyDataSetChanged();
                            isEmpty(movies);
                        case ERROR:
                            Log.d(TAG, "retrieveMovieViewModel: failed to load data");
                            break;
                    }
                }

            });
        }
    }

    private void filterMovieViewModel(String sort){
        if (getActivity() != null){
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity().getApplication());
            FavoriteViewModel favoriteViewModel = ViewModelProviders.of(getActivity(), factory).get(FavoriteViewModel.class);

            favoriteViewModel.fillterAllFavoriteMovies(sort).observe(this, movies -> {
                if (movies != null){
                    switch (movies.status){
                        case LOADING:
                            showSkeleton(false);
                        case SUCCESS:
                            adapter.submitList(movies.data);
                            adapter.notifyDataSetChanged();
                            isEmpty(movies);
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

    private void isEmpty(Resource<PagedList<FavoriteMovieEntity>> data){
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
