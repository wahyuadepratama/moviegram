package site.wahyu.moviegram.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.utils.FakeDataDummy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TVShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private TVShowViewModel viewModel;
    private MoviegramRepository movieRepository = mock(MoviegramRepository.class);

    @Before
    public void setUp() {
        viewModel = new TVShowViewModel(movieRepository);
    }

    @Test
    public void getTVShow() {
        ArrayList<TVShow> dummyTVShow = FakeDataDummy.generateDummyTVShow();

        MutableLiveData<ArrayList<TVShow>> movieResponses = new MutableLiveData<>();
        movieResponses.setValue(dummyTVShow);

        when(movieRepository.getTVShow()).thenReturn(movieResponses);

        Observer observer = mock(Observer.class);

        viewModel.getTVShow().observeForever(observer);

        verify(observer).onChanged(dummyTVShow);
    }
}