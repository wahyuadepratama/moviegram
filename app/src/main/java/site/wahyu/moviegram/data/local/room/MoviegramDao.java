package site.wahyu.moviegram.data.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;

@Dao
public interface MoviegramDao {

    @WorkerThread
    @Query("SELECT * FROM favorite_movie")
    DataSource.Factory<Integer, FavoriteMovieEntity> getAllFavoriteMovie();

    @WorkerThread
    @Query("SELECT * FROM favorite_movie WHERE id=:id")
    LiveData<FavoriteMovieEntity> getFavoriteMovie(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavoriteMovie(FavoriteMovieEntity favoriteMovieEntity);

    @WorkerThread
    @Query("DELETE FROM favorite_movie WHERE id=:id")
    void removeFavoriteMovie(int id);

    @WorkerThread
    @Query("SELECT * FROM favorite_tvshow")
    DataSource.Factory<Integer, FavoriteTVShowEntity> getAllFavoriteTVShow();

    @WorkerThread
    @Query("SELECT * FROM favorite_tvshow WHERE id=:id")
    LiveData<FavoriteTVShowEntity> getFavoriteTVShow(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavoriteTVShow(FavoriteTVShowEntity tvShowEntity);

    @WorkerThread
    @Query("DELETE FROM favorite_tvshow WHERE id=:id")
    void removeFavoriteTVShow(int id);

    @RawQuery(observedEntities = FavoriteMovieEntity.class)
    DataSource.Factory<Integer, FavoriteMovieEntity> filterFavoriteMovie(SupportSQLiteQuery query);
}
