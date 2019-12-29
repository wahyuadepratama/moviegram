package site.wahyu.moviegram.ui.tvshow.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.utils.FakeDataDummy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TVShowDetailViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TVShowDetailViewModel viewModel;
    private MoviegramRepository movieRepository = mock(MoviegramRepository.class);
    private TVShow dummTVShow = FakeDataDummy.generateDummyDetailTVShow().get(0);
    private int tvId = dummTVShow.getId();

    @Before
    public void setUp() {
        viewModel = new TVShowDetailViewModel(movieRepository);
    }

    @Test
    public void getMovieDetail() {
        MutableLiveData<TVShow> tvshow = new MutableLiveData<>();
        tvshow.setValue(dummTVShow);

        when(movieRepository.getDetailTVShow(tvId)).thenReturn(tvshow);

        Observer<TVShow> observer = mock(Observer.class);

        viewModel.getDetailTVShow(tvId).observeForever(observer);

        verify(observer).onChanged(dummTVShow);

    }
}