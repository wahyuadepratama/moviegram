package site.wahyu.moviegram.ui.movie.upcomingmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.remote.model.Movie;

public class UpcomingMovieViewModel extends ViewModel {

    private MoviegramRepository movieRepository;

    public UpcomingMovieViewModel(MoviegramRepository mMoviegramRepository) {
        this.movieRepository= mMoviegramRepository;
    }

    public LiveData<ArrayList<Movie>> getUpcomingMovie() {
        return movieRepository.getUpcomingMovies();
    }

    LiveData<ArrayList<Movie>> getMoreUpcomingMovie() {
        return movieRepository.getUpcomingMovies();
    }
}
