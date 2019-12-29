package site.wahyu.moviegram.ui.movie.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.utils.FakeDataDummy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieDetailViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieDetailViewModel viewModel;
    private MoviegramRepository moviegramRepository = mock(MoviegramRepository.class);
    private Movie dummyMovies = FakeDataDummy.generateDummyDetailMovies().get(0);
    private int movieId = dummyMovies.getId();

    @Before
    public void setUp() {
        viewModel = new MovieDetailViewModel(moviegramRepository);
    }

    @Test
    public void getMovieDetail() {
        MutableLiveData<Movie> courseEntities = new MutableLiveData<>();
        courseEntities.setValue(dummyMovies);

        when(moviegramRepository.getDetailMovie(movieId)).thenReturn(courseEntities);

        Observer<Movie> observer = mock(Observer.class);

        viewModel.getDetailMovie(movieId).observeForever(observer);

        verify(observer).onChanged(dummyMovies);

    }
}