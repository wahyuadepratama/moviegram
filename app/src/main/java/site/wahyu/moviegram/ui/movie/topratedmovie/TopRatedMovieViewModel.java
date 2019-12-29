package site.wahyu.moviegram.ui.movie.topratedmovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.remote.model.Movie;

public class TopRatedMovieViewModel extends ViewModel {

    private MoviegramRepository movieRepository;

    public TopRatedMovieViewModel(MoviegramRepository mMoviegramRepository) {
        this.movieRepository= mMoviegramRepository;
    }

    public LiveData<ArrayList<Movie>> getTopRatedMovie() {
        return movieRepository.getTopRatedMovies();
    }

    LiveData<ArrayList<Movie>> getMoreTopRatedMovie() {
        return movieRepository.getTopRatedMovies();
    }
}
