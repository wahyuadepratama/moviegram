package site.wahyu.moviegram.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.remote.model.TVShow;

public class TVShowViewModel extends ViewModel {

    private MoviegramRepository movieRepository;

    public TVShowViewModel(MoviegramRepository mMoviegramRepository) {
        this.movieRepository= mMoviegramRepository;
    }

    public LiveData<ArrayList<TVShow>> getTVShow() {
        return movieRepository.getTVShow();
    }

}
