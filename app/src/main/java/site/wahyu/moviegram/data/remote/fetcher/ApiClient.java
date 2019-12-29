package site.wahyu.moviegram.data.remote.fetcher;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.data.remote.model.MovieResult;
import site.wahyu.moviegram.data.remote.model.TVShow;
import site.wahyu.moviegram.data.remote.model.TVShowResult;

public interface ApiClient {

    @GET("3/movie/now_playing")
    Call<MovieResult> getNowPlayingMovies(@Query("api_key") String api_key);

    @GET("3/movie/upcoming")
    Call<MovieResult> getUpcomingMovies(@Query("api_key") String api_key);

    @GET("3/movie/top_rated")
    Call<MovieResult> getTopRatedMovies(@Query("api_key") String api_key);

    @GET("3/discover/tv")
    Call<TVShowResult> getTVShow(@Query("api_key") String api_key);

    @GET("3/movie/{movie_id}")
    Call<Movie> getMovieDetail(@Path("movie_id") int movie_id,
                               @Query("api_key") String api_key);

    @GET("3/tv/{tv_id}")
    Call<TVShow> getTvShowDetail(@Path("tv_id") int tv_id,
                                 @Query("api_key") String api_key);
}
