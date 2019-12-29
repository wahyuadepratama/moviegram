package site.wahyu.moviegram.data.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import site.wahyu.moviegram.data.local.entity.FavoriteMovieEntity;
import site.wahyu.moviegram.data.local.entity.FavoriteTVShowEntity;

@Database(entities = {FavoriteMovieEntity.class, FavoriteTVShowEntity.class},
        version = 1,
        exportSchema = false)
public abstract class MoviegramDatabase extends RoomDatabase {

    private static final Object sLock = new Object();
    private static MoviegramDatabase INSTANCE;

    public static MoviegramDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MoviegramDatabase.class, "Moviegram.db")
                        .build();
            }
            return INSTANCE;
        }
    }

    public abstract MoviegramDao moviegramDao();
}
