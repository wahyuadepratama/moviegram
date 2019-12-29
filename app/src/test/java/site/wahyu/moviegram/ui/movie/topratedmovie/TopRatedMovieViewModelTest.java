package site.wahyu.moviegram.ui.movie.topratedmovie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.utils.FakeDataDummy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TopRatedMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TopRatedMovieViewModel viewModel;
    private MoviegramRepository movieRepository = mock(MoviegramRepository.class);

    @Before
    public void setUp() {
        viewModel = new TopRatedMovieViewModel(movieRepository);
    }

    @Test
    public void getTopRatedMovie() {
        ArrayList<Movie> dummyTopRatedMovies = FakeDataDummy.generateDummyTopRatedMovies();

        MutableLiveData<ArrayList<Movie>> movieResponses = new MutableLiveData<>();
        movieResponses.setValue(dummyTopRatedMovies);

        when(movieRepository.getTopRatedMovies()).thenReturn(movieResponses);

        Observer observer = mock(Observer.class);

        viewModel.getTopRatedMovie().observeForever(observer);

        verify(observer).onChanged(dummyTopRatedMovies);
    }

    @Test
    public void getMoreTopRatedMovie() {
        ArrayList<Movie> dummyTopRatedMovies = FakeDataDummy.generateDummyTopRatedMovies();

        MutableLiveData<ArrayList<Movie>> movieResponses = new MutableLiveData<>();
        movieResponses.setValue(dummyTopRatedMovies);

        when(movieRepository.getTopRatedMovies()).thenReturn(movieResponses);

        Observer observer = mock(Observer.class);

        viewModel.getTopRatedMovie().observeForever(observer);

        verify(observer).onChanged(dummyTopRatedMovies);
    }
}