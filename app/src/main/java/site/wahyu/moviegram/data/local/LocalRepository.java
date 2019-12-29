package site.wahyu.moviegram.data.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.sqlite.db.SimpleSQLiteQuery;

import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;
import site.wahyu.moviegram.data.local.room.MoviegramDao;
import site.wahyu.moviegram.data.local.room.SortUtils;

public class LocalRepository {

    private static LocalRepository INSTANCE;
    private final MoviegramDao mMoviegramDao;

    private LocalRepository(MoviegramDao mMoviegramDao) {
        this.mMoviegramDao = mMoviegramDao;
    }

    public static LocalRepository getInstance(MoviegramDao moviegramDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(moviegramDao);
        }
        return INSTANCE;
    }

    public void insertFavoriteMovie(FavoriteMovieEntity favoriteMovieEntity){
        mMoviegramDao.insertFavoriteMovie(favoriteMovieEntity);
    }

    public void removeFavoriteMovie(int id){
        mMoviegramDao.removeFavoriteMovie(id);
    }

    public DataSource.Factory<Integer, FavoriteMovieEntity> getAllFavoriteMovie() {
        return mMoviegramDao.getAllFavoriteMovie();
    }

    public LiveData<FavoriteMovieEntity> getFavoriteMovie(int id){
        return mMoviegramDao.getFavoriteMovie(id);
    }

    public void insertFavoriteTVShow(FavoriteTVShowEntity favoriteTVShowEntity){
        mMoviegramDao.insertFavoriteTVShow(favoriteTVShowEntity);
    }

    public void removeFavoriteTVShow(int id){
        mMoviegramDao.removeFavoriteTVShow(id);
    }

    public DataSource.Factory<Integer, FavoriteMovieEntity> filterFavoriteMovie(String sort){
        SimpleSQLiteQuery query = SortUtils.getSorteredQuery(sort);
        return mMoviegramDao.filterFavoriteMovie(query);
    }

    public DataSource.Factory<Integer, FavoriteTVShowEntity> getAllFavoriteTVShow() {
        return mMoviegramDao.getAllFavoriteTVShow();
    }

    public LiveData<FavoriteTVShowEntity> getFavoriteTVShow(int id){
        return mMoviegramDao.getFavoriteTVShow(id);
    }
}
