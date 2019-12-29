package site.wahyu.moviegram.ui.favorite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.connector.vo.Resource;
import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;

public class FavoriteViewModel extends ViewModel {

    private MoviegramRepository movieRepository;

    public FavoriteViewModel(MoviegramRepository mMoviegramRepository) {
        this.movieRepository= mMoviegramRepository;
    }

    public LiveData<Resource<PagedList<FavoriteMovieEntity>>> getAllFavoriteMovie() {
        return movieRepository.getAllFavoriteMovie();
    }

    public LiveData<Resource<PagedList<FavoriteTVShowEntity>>> getAllFavoriteTVShow() {
        return movieRepository.getAllFavoriteTVShow();
    }

    public  LiveData<Resource<PagedList<FavoriteMovieEntity>>> fillterAllFavoriteMovies(String sort){
        return movieRepository.filterFavoriteMovies(sort);
    }
}
