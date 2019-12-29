package site.wahyu.moviegram.ui.movie.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.remote.model.Movie;

public class MovieDetailViewModel extends ViewModel {

    private MoviegramRepository movieRepository;

    public MovieDetailViewModel(MoviegramRepository mMoviegramRepository) {
        this.movieRepository= mMoviegramRepository;
    }

    LiveData<Movie> getDetailMovie(int id) {
        return movieRepository.getDetailMovie(id);
    }

    void saveToFavorite(FavoriteMovieEntity favoriteMovieEntity){
        movieRepository.insertFavoriteTVShow(favoriteMovieEntity);
    }

    void removeFromFavorite(int id){
        movieRepository.removeFavoriteMovie(id);
    }

    LiveData<FavoriteMovieEntity> getFromFavorite(int id){
        return movieRepository.getFavoriteMovie(id);
    }
}
