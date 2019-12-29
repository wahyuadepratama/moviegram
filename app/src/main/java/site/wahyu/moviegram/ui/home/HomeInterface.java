package site.wahyu.moviegram.ui.home;

import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import site.wahyu.moviegram.ui.favorite.PlaceholderFragment;
import site.wahyu.moviegram.ui.movie.MovieFragment;
import site.wahyu.moviegram.ui.tvshow.TVShowFragment;

public interface HomeInterface {

    void checkPreference(BottomNavigationView navView);
    void setPreference(int selected);

    void setFragmentToMovie(MovieFragment movieFragment);
    void setFragmentToMovie(View view);

    void setFragmentToNowPlayingMovie(View view);
    void setFragmentToNowPlayingMovie();

    void setFragmentToUpcomingMovie(View view);
    void setFragmentToUpcomingMovie();

    void setFragmentToTopRatedMovie(View view);
    void setFragmentToTopRatedMovie();

    void setFragmentToTVShow(TVShowFragment listTVShowFragment);

    void setFragmentToFavorite(PlaceholderFragment placeholderFragment);
}
