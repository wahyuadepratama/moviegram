package site.wahyu.moviegram.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import site.wahyu.moviegram.data.connector.vo.Resource;
import site.wahyu.moviegram.data.local.LocalRepository;
import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;
import site.wahyu.moviegram.data.remote.RemoteRepository;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.utils.FakeDataDummy;
import site.wahyu.moviegram.utils.InstantAppExecutors;
import site.wahyu.moviegram.utils.LiveDataTestUtils;
import site.wahyu.moviegram.utils.PagedListUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviegramRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalRepository local = Mockito.mock(LocalRepository.class);
    private RemoteRepository remote = Mockito.mock(RemoteRepository.class);
    private InstantAppExecutors instantAppExecutors = Mockito.mock(InstantAppExecutors.class);
    private FakeMoviegramRepository moviegramRepository = new FakeMoviegramRepository(local, remote, instantAppExecutors);

    private ArrayList<FavoriteMovieEntity> dummyFavoriteMovies = FakeDataDummy.generateDummyFavoriteMovies();
    private ArrayList<FavoriteTVShowEntity> dummyFavoriteTVShow = FakeDataDummy.generateDummyFavoriteTVShow();
    private ArrayList<Movie> dummyNowPlayingMovies = FakeDataDummy.generateDummyNowPlayingMovies();
    private ArrayList<Movie> dummyUpcomingMovies = FakeDataDummy.generateDummyUpcomingMovies();
    private ArrayList<Movie> dummyTopRatedMovies = FakeDataDummy.generateDummyTopRatedMovies();
    private ArrayList<TVShow> dummyTVShow = FakeDataDummy.generateDummyTVShow();

    private int movieId = dummyNowPlayingMovies.get(0).getId();
    private int tvId = dummyTVShow.get(0).getId();

    @Test
    public void getAllFavoriteMovie(){
        DataSource.Factory<Integer, FavoriteMovieEntity> dataSourceFactory = mock(DataSource.Factory.class);

        when(local.getAllFavoriteMovie()).thenReturn(dataSourceFactory);
        moviegramRepository.getAllFavoriteMovie();
        Resource<PagedList<FavoriteMovieEntity>> result = Resource.success(PagedListUtil.mockPagedList(dummyFavoriteMovies));

        verify(local).getAllFavoriteMovie();
        assertNotNull(result.data);
        assertEquals(dummyFavoriteMovies.size(), result.data.size());
    }

    @Test
    public void getFavoriteMovie(){
        MutableLiveData<FavoriteMovieEntity> movie = new MutableLiveData<>();
        movie.setValue(dummyFavoriteMovies.get(0));

        when(local.getFavoriteMovie(dummyFavoriteMovies.get(0).getId())).thenReturn(movie);

        FavoriteMovieEntity result = LiveDataTestUtils.getValue(moviegramRepository.getFavoriteMovie(dummyFavoriteMovies.get(0).getId()));

        verify(local, times(1)).getFavoriteMovie(dummyFavoriteMovies.get(0).getId());
        assertNotNull(result);
        assertEquals(dummyFavoriteMovies.get(0).getTitle(), result.getTitle());
    }

    @Test
    public void getAllFavoriteTVShow(){
        DataSource.Factory<Integer, FavoriteTVShowEntity> dataSourceFactory = mock(DataSource.Factory.class);

        when(local.getAllFavoriteTVShow()).thenReturn(dataSourceFactory);
        moviegramRepository.getAllFavoriteTVShow();
        Resource<PagedList<FavoriteTVShowEntity>> result = Resource.success(PagedListUtil.mockPagedList(dummyFavoriteTVShow));

        verify(local).getAllFavoriteTVShow();
        assertNotNull(result.data);
        assertEquals(dummyFavoriteTVShow.size(), result.data.size());
    }

    @Test
    public void getFavoriteTVShow(){
        MutableLiveData<FavoriteTVShowEntity> tvshow = new MutableLiveData<>();
        tvshow.setValue(dummyFavoriteTVShow.get(0));

        when(local.getFavoriteTVShow(dummyFavoriteTVShow.get(0).getId())).thenReturn(tvshow);

        FavoriteTVShowEntity result = LiveDataTestUtils.getValue(moviegramRepository.getFavoriteTVShow(dummyFavoriteTVShow.get(0).getId()));

        verify(local, times(1)).getFavoriteTVShow(dummyFavoriteTVShow.get(0).getId());
        assertNotNull(result);
        assertEquals(dummyFavoriteTVShow.get(0).getName(), result.getName());
    }

    @Test
    public void getNowPlayingMovies() {
        MutableLiveData<ArrayList<Movie>> movie = new MutableLiveData<>();
        movie.setValue(dummyNowPlayingMovies);

        when(remote.getNowPlayingMovies()).thenReturn(movie);

        ArrayList<Movie> result = LiveDataTestUtils.getValue(moviegramRepository.getNowPlayingMovies());

        verify(remote, times(1)).getNowPlayingMovies();
        assertNotNull(result);
        assertEquals(dummyNowPlayingMovies.size(), result.size());
    }

    @Test
    public void getUpcomingMovies(){
        MutableLiveData<ArrayList<Movie>> movie = new MutableLiveData<>();
        movie.setValue(dummyUpcomingMovies);

        when(remote.getUpcomingMovies()).thenReturn(movie);

        ArrayList<Movie> result = LiveDataTestUtils.getValue(moviegramRepository.getUpcomingMovies());

        verify(remote, times(1)).getUpcomingMovies();
        assertNotNull(result);
        assertEquals(dummyUpcomingMovies.size(), result.size());
    }

    @Test
    public void getTopRatedMovies(){
        MutableLiveData<ArrayList<Movie>> movie = new MutableLiveData<>();
        movie.setValue(dummyTopRatedMovies);

        when(remote.getTopRatedMovies()).thenReturn(movie);

        ArrayList<Movie> result = LiveDataTestUtils.getValue(moviegramRepository.getTopRatedMovies());

        verify(remote, times(1)).getTopRatedMovies();
        assertNotNull(result);
        assertEquals(dummyTopRatedMovies.size(), result.size());
    }

    @Test
    public void getTVShow(){
        MutableLiveData<ArrayList<TVShow>> tvshow = new MutableLiveData<>();
        tvshow.setValue(dummyTVShow);

        when(remote.getAllTVShow()).thenReturn(tvshow);

        ArrayList<TVShow> result = LiveDataTestUtils.getValue(moviegramRepository.getTVShow());

        verify(remote, times(1)).getAllTVShow();
        assertNotNull(result);
        assertEquals(dummyTVShow.size(), result.size());
    }

    @Test
    public void getDetailMovie(){
        MutableLiveData<Movie> movie = new MutableLiveData<>();
        movie.setValue(dummyNowPlayingMovies.get(0));

        when(remote.getDetailMovie(movieId)).thenReturn(movie);

        Movie result = LiveDataTestUtils.getValue(moviegramRepository.getDetailMovie(movieId));
        assertNotNull(result);
        assertEquals(dummyNowPlayingMovies.get(0).getId(), result.getId());
    }

    @Test
    public void getDetailTVShow(){
        MutableLiveData<TVShow> tvshow= new MutableLiveData<>();
        tvshow.setValue(dummyTVShow.get(0));

        when(remote.getDetailTVShow(tvId)).thenReturn(tvshow);

        TVShow result = LiveDataTestUtils.getValue(moviegramRepository.getDetailTVShow(tvId));
        assertNotNull(result);
        assertEquals(dummyTVShow.get(0).getId(), result.getId());
    }
}