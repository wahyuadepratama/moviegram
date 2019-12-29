package site.wahyu.moviegram.data.connector.di;

import android.app.Application;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.local.LocalRepository;
import site.wahyu.moviegram.data.local.room.MoviegramDatabase;
import site.wahyu.moviegram.data.remote.RemoteRepository;
import site.wahyu.moviegram.data.remote.fetcher.FetchData;
import site.wahyu.moviegram.utils.helper.AppExecutors;

public class Injection {

    public static MoviegramRepository provideRepository(Application application) {

        MoviegramDatabase database = MoviegramDatabase.getInstance(application);

        LocalRepository localRepository = LocalRepository.getInstance(database.moviegramDao());
        RemoteRepository remoteRepository = RemoteRepository.getInstance(new FetchData(application));
        AppExecutors appExecutors = new AppExecutors();

        return MoviegramRepository.getInstance(localRepository, remoteRepository, appExecutors);
    }
}
