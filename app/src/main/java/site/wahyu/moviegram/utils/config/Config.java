package site.wahyu.moviegram.utils.config;

public class Config {
    //API
    public static final String URL_TM_DB = "https://api.themoviedb.org/";
    public static final String URL_IMG_TM_DB = "https://image.tmdb.org/t/p/w500";
    public static final String URL_IMG_TM_DB_ORIGINAL = "https://image.tmdb.org/t/p/original";
    public static final String API_KEY = "ed7818e67c85a6ce60d701cde5cbcff2";

    //Status Menu in HomeActivity - SharedPreferences
    public static final String STATUS_MENU = "status_menu";
    public static final int MENU_MOVIE_SELECTED = 0;
    public static final int MENU_TV_SHOW_SELECTED = 1;
    public static final int MENU_NOW_PLAYING_SELECTED = 2;
    public static final int MENU_UPCOMING_SELECTED = 3;
    public static final int MENU_TOP_RATED_SELECTED = 4;
    public static final int MENU_FAVORITE_SELECTED = 5;

    //Parcelable in Detail Activity
    public static final String EXTRA_MOVIES = "movies";
    public static final String EXTRA_TV_SHOW = "tvShow";

    //Setting value
    public static final boolean DEFAULT_REMINDER_NOTIFICATION = true;
    public static final String REMINDER_NOTIFICATION = "reminder_switch";

    public static final boolean DEFAULT_HISTORY = true;
    public static final String HISTORY = "check_box_history";

}
