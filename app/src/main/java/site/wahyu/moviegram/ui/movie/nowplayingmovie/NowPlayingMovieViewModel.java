package site.wahyu.moviegram.ui.movie.nowplayingmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.remote.model.Movie;

public class NowPlayingMovieViewModel extends ViewModel {

    private MoviegramRepository movieRepository;

    public NowPlayingMovieViewModel(MoviegramRepository mMoviegramRepository) {
        this.movieRepository= mMoviegramRepository;
    }

    public LiveData<ArrayList<Movie>> getNowPlayingMovie() {
        return movieRepository.getNowPlayingMovies();
    }

    LiveData<ArrayList<Movie>> getMoreNowPlayingMovie() {
        return movieRepository.getNowPlayingMovies();
    }
}
