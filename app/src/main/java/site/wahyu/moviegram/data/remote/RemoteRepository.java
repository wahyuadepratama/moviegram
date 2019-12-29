package site.wahyu.moviegram.data.remote;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

import site.wahyu.moviegram.data.remote.fetcher.FetchData;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.data.remote.model.TVShow;

public class RemoteRepository {

    private static RemoteRepository INSTANCE;
    private FetchData jsonHelper;

    private RemoteRepository(FetchData jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public static RemoteRepository getInstance(FetchData helper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(helper);
        }
        return INSTANCE;
    }

    public LiveData<ArrayList<Movie>> getNowPlayingMovies() {
        return jsonHelper.getNowPlayingMovies();
    }

    public LiveData<ArrayList<Movie>> getUpcomingMovies() {
        return jsonHelper.getUpcomingMovies();
    }

    public LiveData<ArrayList<Movie>> getTopRatedMovies() {
        return jsonHelper.getTopRatedMovies();
    }

    public LiveData<ArrayList<TVShow>> getAllTVShow() {
        return jsonHelper.getListTVShow();
    }

    public LiveData<Movie> getDetailMovie(int id) {
        return jsonHelper.getDetailMovie(id);
    }

    public LiveData<TVShow> getDetailTVShow(int id) {
        return jsonHelper.getDetailTVShow(id);
    }
}
