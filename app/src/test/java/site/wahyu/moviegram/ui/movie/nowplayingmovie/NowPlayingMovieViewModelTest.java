package site.wahyu.moviegram.ui.movie.nowplayingmovie;

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

public class NowPlayingMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private NowPlayingMovieViewModel viewModel;
    private MoviegramRepository movieRepository = mock(MoviegramRepository.class);

    @Before
    public void setUp() {
        viewModel = new NowPlayingMovieViewModel(movieRepository);
    }

    @Test
    public void getNowPlayingMovie() {
        ArrayList<Movie> dummyNowPlayingMovies = FakeDataDummy.generateDummyNowPlayingMovies();

        MutableLiveData<ArrayList<Movie>> movieResponses = new MutableLiveData<>();
        movieResponses.setValue(dummyNowPlayingMovies);

        when(movieRepository.getNowPlayingMovies()).thenReturn(movieResponses);
        Observer observer = mock(Observer.class);

        viewModel.getNowPlayingMovie().observeForever(observer);

        verify(observer).onChanged(dummyNowPlayingMovies);
    }

    @Test
    public void getMoreNowPlayingMovie() {
        ArrayList<Movie> dummyNowPlayingMovies = FakeDataDummy.generateDummyNowPlayingMovies();

        MutableLiveData<ArrayList<Movie>> movieResponses = new MutableLiveData<>();
        movieResponses.setValue(dummyNowPlayingMovies);

        when(movieRepository.getNowPlayingMovies()).thenReturn(movieResponses);

        Observer observer = mock(Observer.class);

        viewModel.getNowPlayingMovie().observeForever(observer);

        verify(observer).onChanged(dummyNowPlayingMovies);
    }
}