package site.wahyu.moviegram.data.remote.fetcher;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.data.remote.model.MovieResult;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.data.remote.model.TVShowResult;
import site.wahyu.moviegram.utils.config.Config;
import site.wahyu.moviegram.utils.helper.EspressoIdlingResource;
import site.wahyu.moviegram.utils.helper.RetrofitClient;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FetchData {

    private Application application;

    public FetchData(Application application) {
        this.application = application;
    }

    public LiveData<ArrayList<Movie>> getNowPlayingMovies() {

//        EspressoIdlingResource.increment();
//        MutableLiveData<ArrayList<Movie>> movies = new MutableLiveData<>();
//
//        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
//        ApiClient client = retrofit.create(ApiClient.class);
//        Call<MovieResult> call;
//        call = client.getNowPlayingMovies(Config.API_KEY);
//
//        // Execute the call asynchronously. Get a positive or negative callback.
//        call.enqueue(new Callback<MovieResult>() {
//            @Override
//            public void onResponse(@NonNull Call<MovieResult> call, @NonNull Response<MovieResult> response) {
//                MovieResult list = response.body();
//                ArrayList<Movie> listMovie = Objects.requireNonNull(list).results;
//                movies.setValue(listMovie);
//
//                EspressoIdlingResource.decrement();
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<MovieResult> call, @NonNull Throwable t) {
//                Log.d(TAG, "onFailure: --------------------------------------"+t.getMessage());
//            }
//        });
        MutableLiveData<ArrayList<Movie>> movies = new MutableLiveData<>();

        try {
            JSONObject response = new JSONObject(Objects.requireNonNull(parsingFileToString("now_playing.json")));
            JSONArray result = response.getJSONArray("results");

            ArrayList<Movie> movieArray = new ArrayList<>();
            for (int i=0; result.length()>i; i++){
                JSONObject movie = result.getJSONObject(i);

                Movie model = new Movie(movie.getInt("id"), movie.getString("poster_path"), movie.getString("title"), movie.getString("overview"), movie.getString("release_date"));
                movieArray.add(model);
            }

            movies.setValue(movieArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private String parsingFileToString(String fileName) {
        try {
            InputStream is = application.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public LiveData<ArrayList<Movie>> getUpcomingMovies() {

        EspressoIdlingResource.increment();
        MutableLiveData<ArrayList<Movie>> movies = new MutableLiveData<>();

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ApiClient client = retrofit.create(ApiClient.class);
        Call<MovieResult> call;
        call = client.getUpcomingMovies(Config.API_KEY);

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(@NonNull Call<MovieResult> call, @NonNull Response<MovieResult> response) {
                MovieResult list = response.body();
                ArrayList<Movie> listMovie = Objects.requireNonNull(list).results;
                movies.setValue(listMovie);

                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<MovieResult> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: --------------------------------------"+t.getMessage());
            }
        });

        return movies;
    }

    public LiveData<ArrayList<Movie>> getTopRatedMovies() {

        EspressoIdlingResource.increment();
        MutableLiveData<ArrayList<Movie>> movies = new MutableLiveData<>();

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ApiClient client = retrofit.create(ApiClient.class);
        Call<MovieResult> call;
        call = client.getTopRatedMovies(Config.API_KEY);

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(@NonNull Call<MovieResult> call, @NonNull Response<MovieResult> response) {
                MovieResult list = response.body();
                ArrayList<Movie> listMovie = Objects.requireNonNull(list).results;
                movies.setValue(listMovie);

                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<MovieResult> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: --------------------------------------"+t.getMessage());
            }
        });

        return movies;
    }

    public LiveData<Movie> getDetailMovie(int id) {

        EspressoIdlingResource.increment();
        MutableLiveData<Movie> movies = new MutableLiveData<>();

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ApiClient client = retrofit.create(ApiClient.class);
        Call<Movie> call;
        call = client.getMovieDetail(id, Config.API_KEY);

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                Movie movie = response.body();
                movies.setValue(movie);

                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: --------------------------------------"+t.getMessage());
            }
        });

        return movies;
    }

    public LiveData<ArrayList<TVShow>> getListTVShow() {

        EspressoIdlingResource.increment();
        MutableLiveData<ArrayList<TVShow>> tvshow = new MutableLiveData<>();

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ApiClient client = retrofit.create(ApiClient.class);
        Call<TVShowResult> call;
        call = client.getTVShow(Config.API_KEY);

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<TVShowResult>() {
            @Override
            public void onResponse(@NonNull Call<TVShowResult> call, @NonNull Response<TVShowResult> response) {
                TVShowResult list = response.body();
                ArrayList<TVShow> listTVShow = Objects.requireNonNull(list).results;
                tvshow.setValue(listTVShow);

                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<TVShowResult> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: --------------------------------------"+t.getMessage());
            }
        });

        return tvshow;
    }

    public LiveData<TVShow> getDetailTVShow(int id) {

        EspressoIdlingResource.increment();
        MutableLiveData<TVShow> tvshow = new MutableLiveData<>();

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        ApiClient client = retrofit.create(ApiClient.class);
        Call<TVShow> call;
        call = client.getTvShowDetail(id, Config.API_KEY);

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<TVShow>() {
            @Override
            public void onResponse(@NonNull Call<TVShow> call, @NonNull Response<TVShow> response) {
                TVShow list = response.body();
                tvshow.setValue(list);

                EspressoIdlingResource.decrement();
            }

            @Override
            public void onFailure(@NonNull Call<TVShow> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: --------------------------------------"+t.getMessage());
            }
        });

        return tvshow;
    }

}
