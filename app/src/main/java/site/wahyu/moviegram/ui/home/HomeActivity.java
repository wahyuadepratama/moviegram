package site.wahyu.moviegram.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.ui.favorite.PlaceholderFragment;
import site.wahyu.moviegram.ui.movie.MovieFragment;
import site.wahyu.moviegram.ui.movie.nowplayingmovie.NowPlayingMovieFragment;
import site.wahyu.moviegram.ui.movie.topratedmovie.TopRatedMovieFragment;
import site.wahyu.moviegram.ui.movie.upcomingmovie.UpcomingMovieFragment;
import site.wahyu.moviegram.ui.tvshow.TVShowFragment;
import site.wahyu.moviegram.utils.config.Config;

public class HomeActivity extends AppCompatActivity implements ActionBarInterface, HomeInterface {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {

                switch (item.getItemId()) {
                    case R.id.navigation_movie:
                        setFragmentToMovie(new MovieFragment());
                        return true;
                    case R.id.navigation_tvshow:
                        setFragmentToTVShow(new TVShowFragment());
                        return true;
                    case R.id.navigation_favorite:
                        setFragmentToFavorite(new PlaceholderFragment());
                        return true;
                }
                return false;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        customActionBar();
        checkPreference(navView);
        checkIntent();
    }

    public void checkIntent(){
        String menuFragment = getIntent().getStringExtra("goToMenuFragment");
        if (menuFragment != null){
            if (menuFragment.equals("favorite_movie")){
                setFragmentToFavorite(new PlaceholderFragment());
            }
        }
    }

    @Override
    public void customActionBar() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_home);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().show();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
    }

    @Override
    public void changeTitleActionBarCustomized(String new_title){
        ActionBar bar = getSupportActionBar();
        TextView title = Objects.requireNonNull(bar).getCustomView().findViewById(R.id.name);
        title.setText(new_title);
    }

    @Override
    public void changeIconActionBarCustomized(int layout){
        Objects.requireNonNull(getSupportActionBar()).setCustomView(layout);
    }

    @Override
    public void checkPreference(BottomNavigationView navView){
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        int mode = preferences.getInt(Config.STATUS_MENU, Config.MENU_MOVIE_SELECTED); //default value is menu_movies_selected

        switch (mode){
            case(Config.MENU_MOVIE_SELECTED):
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                navView.getMenu().findItem(R.id.navigation_movie).setChecked(true);
                setFragmentToMovie(new MovieFragment());
                break;
            case(Config.MENU_TV_SHOW_SELECTED):
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                navView.getMenu().findItem(R.id.navigation_tvshow).setChecked(true);
                setFragmentToTVShow(new TVShowFragment());
                break;
            case(Config.MENU_NOW_PLAYING_SELECTED):
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                navView.getMenu().findItem(R.id.navigation_movie).setChecked(true);
                setFragmentToNowPlayingMovie();
                break;
            case(Config.MENU_UPCOMING_SELECTED):
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                navView.getMenu().findItem(R.id.navigation_movie).setChecked(true);
                setFragmentToUpcomingMovie();
                break;
            case(Config.MENU_TOP_RATED_SELECTED):
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                navView.getMenu().findItem(R.id.navigation_movie).setChecked(true);
                setFragmentToTopRatedMovie();
                break;
            case(Config.MENU_FAVORITE_SELECTED):
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                navView.getMenu().findItem(R.id.navigation_favorite).setChecked(true);
                setFragmentToFavorite(new PlaceholderFragment());
                break;
        }
    }

    @Override
    public void setPreference(int selected) {
        SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
        editor.putInt(Config.STATUS_MENU, selected).apply();
    }

    @Override
    public void setFragmentToTVShow(TVShowFragment listTVShowFragment) {
        setPreference(Config.MENU_TV_SHOW_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_home);
        changeTitleActionBarCustomized(getString(R.string.title_tvshow));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, listTVShowFragment)
                .commit();
    }

    @Override
    public void setFragmentToFavorite(PlaceholderFragment placeholderFragment) {
        setPreference(Config.MENU_FAVORITE_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_home);
        changeTitleActionBarCustomized(getString(R.string.title_tvshow));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, placeholderFragment)
                .commit();
    }

    @Override
    public void setFragmentToMovie(View view){
        setPreference(Config.MENU_MOVIE_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_home);
        changeTitleActionBarCustomized(getString(R.string.title_movie));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, new MovieFragment())
                .commit();
    }

    @Override
    public void setFragmentToMovie(MovieFragment movieFragment) {
        setPreference(Config.MENU_MOVIE_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_home);
        changeTitleActionBarCustomized(getString(R.string.title_movie));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, movieFragment)
                .commit();
    }

    @Override
    public void setFragmentToNowPlayingMovie(View view){
        setPreference(Config.MENU_NOW_PLAYING_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_detail);
        changeTitleActionBarCustomized(getString(R.string.title_now_playing_movie_fragment));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, new NowPlayingMovieFragment())
                .commit();
    }

    @Override
    public void setFragmentToNowPlayingMovie() {
        setPreference(Config.MENU_NOW_PLAYING_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_detail);
        changeTitleActionBarCustomized(getString(R.string.title_now_playing_movie_fragment));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, new NowPlayingMovieFragment())
                .commit();
    }

    @Override
    public void setFragmentToUpcomingMovie(View view){
        setPreference(Config.MENU_UPCOMING_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_detail);
        changeTitleActionBarCustomized(getString(R.string.title_upcoming_movie_fragment));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, new UpcomingMovieFragment())
                .commit();
    }

    @Override
    public void setFragmentToUpcomingMovie() {
        setPreference(Config.MENU_UPCOMING_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_detail);
        changeTitleActionBarCustomized(getString(R.string.title_upcoming_movie_fragment));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, new UpcomingMovieFragment())
                .commit();
    }

    @Override
    public void setFragmentToTopRatedMovie(View view){
        setPreference(Config.MENU_TOP_RATED_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_detail);
        changeTitleActionBarCustomized(getString(R.string.title_top_rated_fragment));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, new TopRatedMovieFragment())
                .commit();
    }

    @Override
    public void setFragmentToTopRatedMovie() {
        setPreference(Config.MENU_TOP_RATED_SELECTED);
        changeIconActionBarCustomized(R.layout.abs_detail);
        changeTitleActionBarCustomized(getString(R.string.title_top_rated_fragment));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_placeholder, new TopRatedMovieFragment())
                .commit();
    }
}
