package site.wahyu.moviegram.ui.movie.upcomingmovie;

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

public class UpcomingMovieViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private UpcomingMovieViewModel viewModel;
    private MoviegramRepository movieRepository = mock(MoviegramRepository.class);

    @Before
    public void setUp() {
        viewModel = new UpcomingMovieViewModel(movieRepository);
    }

    @Test
    public void getUpcomingMovie() {
        ArrayList<Movie> dummyUpcomingMovies = FakeDataDummy.generateDummyUpcomingMovies();

        MutableLiveData<ArrayList<Movie>> movieResponses = new MutableLiveData<>();
        movieResponses.setValue(dummyUpcomingMovies);

        when(movieRepository.getUpcomingMovies()).thenReturn(movieResponses);

        Observer observer = mock(Observer.class);

        viewModel.getUpcomingMovie().observeForever(observer);

        verify(observer).onChanged(dummyUpcomingMovies);
    }

    @Test
    public void getMoreUpcomingMovie() {
        ArrayList<Movie> dummyUpcomingMovies = FakeDataDummy.generateDummyUpcomingMovies();

        MutableLiveData<ArrayList<Movie>> movieResponses = new MutableLiveData<>();
        movieResponses.setValue(dummyUpcomingMovies);

        when(movieRepository.getUpcomingMovies()).thenReturn(movieResponses);

        Observer observer = mock(Observer.class);

        viewModel.getUpcomingMovie().observeForever(observer);

        verify(observer).onChanged(dummyUpcomingMovies);
    }
}