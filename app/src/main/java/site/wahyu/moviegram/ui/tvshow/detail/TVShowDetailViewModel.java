package site.wahyu.moviegram.ui.tvshow.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;
import site.wahyu.moviegram.data.remote.model.TVShow;

public class TVShowDetailViewModel extends ViewModel {

    private MoviegramRepository movieRepository;

    public TVShowDetailViewModel(MoviegramRepository mMoviegramRepository) {
        this.movieRepository= mMoviegramRepository;
    }

    LiveData<TVShow> getDetailTVShow(int id) {
        return movieRepository.getDetailTVShow(id);
    }

    void saveToFavorite(FavoriteTVShowEntity favoriteMovieEntity){
        movieRepository.insertFavoriteTVShow(favoriteMovieEntity);
    }

    void removeFromFavorite(int id){
        movieRepository.removeFavoriteTVShow(id);
    }

    LiveData<FavoriteTVShowEntity> getFromFavorite(int id){
        return movieRepository.getFavoriteTVShow(id);
    }
}
