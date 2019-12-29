package site.wahyu.moviegram.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.ArrayList;
import java.util.List;

import site.wahyu.moviegram.data.connector.nbr.NetworkBoundResource;
import site.wahyu.moviegram.data.connector.vo.Resource;
import site.wahyu.moviegram.data.local.LocalRepository;
import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;
import site.wahyu.moviegram.data.remote.RemoteRepository;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.data.remote.response.ApiResponse;
import site.wahyu.moviegram.utils.helper.AppExecutors;

public class FakeMoviegramRepository {
    private volatile static FakeMoviegramRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;
    private final AppExecutors appExecutors;

    FakeMoviegramRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository, AppExecutors appExecutors) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
        this.appExecutors = appExecutors;
    }

    public static FakeMoviegramRepository getInstance(LocalRepository localRepository, RemoteRepository remoteData, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (MoviegramRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeMoviegramRepository(localRepository, remoteData, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    // ---------------------------------------- Movie --------------------------------------------

    public LiveData<Resource<PagedList<FavoriteMovieEntity>>> getAllFavoriteMovie(){
        return new NetworkBoundResource<PagedList<FavoriteMovieEntity>, List<Movie>>(appExecutors) {
            @Override
            public LiveData<PagedList<FavoriteMovieEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getAllFavoriteMovie(), 1).build();
            }

            @Override
            public Boolean shouldFetch(PagedList<FavoriteMovieEntity> data) {
                return false;
            }

            @Override
            public LiveData<ApiResponse<List<Movie>>> createCall() {
                return null;
            }

            @Override
            public void saveCallResult(List<Movie> courseResponses) {

            }
        }.asLiveData();
    }

    public LiveData<FavoriteMovieEntity> getFavoriteMovie(int id){
        return localRepository.getFavoriteMovie(id);
    }

    public void insertFavoriteTVShow(FavoriteMovieEntity favoriteMovieEntity){
        Runnable runnable = () -> localRepository.insertFavoriteMovie(favoriteMovieEntity);
        appExecutors.diskIO().execute(runnable);
    }

    public void removeFavoriteMovie(int id){
        Runnable runnable = () -> localRepository.removeFavoriteMovie(id);
        appExecutors.diskIO().execute(runnable);
    }

    public LiveData<ArrayList<Movie>> getNowPlayingMovies() {
        return remoteRepository.getNowPlayingMovies();
    }

    public LiveData<ArrayList<Movie>> getUpcomingMovies() {
        return remoteRepository.getUpcomingMovies();
    }

    public LiveData<ArrayList<Movie>> getTopRatedMovies() {
        return remoteRepository.getTopRatedMovies();
    }

    public LiveData<Movie> getDetailMovie(int id) {
        return remoteRepository.getDetailMovie(id);
    }

    // ---------------------------------------- TV Show --------------------------------------------

    public LiveData<Resource<PagedList<FavoriteTVShowEntity>>> getAllFavoriteTVShow(){
        return new NetworkBoundResource<PagedList<FavoriteTVShowEntity>, List<TVShow>>(appExecutors) {
            @Override
            public LiveData<PagedList<FavoriteTVShowEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getAllFavoriteTVShow(), 1).build();
            }

            @Override
            public Boolean shouldFetch(PagedList<FavoriteTVShowEntity> data) {
                return false;
            }

            @Override
            public LiveData<ApiResponse<List<TVShow>>> createCall() {
                return null;
            }

            @Override
            public void saveCallResult(List<TVShow> courseResponses) {

            }
        }.asLiveData();
    }

    public LiveData<FavoriteTVShowEntity> getFavoriteTVShow(int id){
        return localRepository.getFavoriteTVShow(id);
    }

    public void insertFavoriteTVShow(FavoriteTVShowEntity favoriteTVShowEntity){
        Runnable runnable = () -> localRepository.insertFavoriteTVShow(favoriteTVShowEntity);
        appExecutors.diskIO().execute(runnable);
    }

    public void removeFavoriteTVShow(int id){
        Runnable runnable = () -> localRepository.removeFavoriteTVShow(id);
        appExecutors.diskIO().execute(runnable);
    }

    public LiveData<ArrayList<TVShow>> getTVShow(){
        return remoteRepository.getAllTVShow();
    }

    public LiveData<TVShow> getDetailTVShow(int id) {
        return remoteRepository.getDetailTVShow(id);
    }
}
