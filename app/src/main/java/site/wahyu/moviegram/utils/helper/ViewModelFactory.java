package site.wahyu.moviegram.utils.helper;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import site.wahyu.moviegram.data.MoviegramRepository;
import site.wahyu.moviegram.data.connector.di.Injection;
import site.wahyu.moviegram.ui.favorite.FavoriteViewModel;
import site.wahyu.moviegram.ui.movie.detail.MovieDetailViewModel;
import site.wahyu.moviegram.ui.movie.nowplayingmovie.NowPlayingMovieViewModel;
import site.wahyu.moviegram.ui.movie.topratedmovie.TopRatedMovieViewModel;
import site.wahyu.moviegram.ui.movie.upcomingmovie.UpcomingMovieViewModel;
import site.wahyu.moviegram.ui.tvshow.TVShowViewModel;
import site.wahyu.moviegram.ui.tvshow.detail.TVShowDetailViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;
    private final MoviegramRepository moviegramRepository;

    private ViewModelFactory(MoviegramRepository moviegramRepository) {
        this.moviegramRepository = moviegramRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NowPlayingMovieViewModel.class)) {
            return (T) new NowPlayingMovieViewModel(moviegramRepository);

        }else if (modelClass.isAssignableFrom(UpcomingMovieViewModel.class)){
            return (T) new UpcomingMovieViewModel(moviegramRepository);

        }else if (modelClass.isAssignableFrom(TopRatedMovieViewModel.class)){
            return (T) new TopRatedMovieViewModel(moviegramRepository);

        }else if(modelClass.isAssignableFrom(TVShowViewModel.class)){
            return (T) new TVShowViewModel(moviegramRepository);

        }else if(modelClass.isAssignableFrom(MovieDetailViewModel.class)){
            return (T) new MovieDetailViewModel(moviegramRepository);

        }else if(modelClass.isAssignableFrom(TVShowDetailViewModel.class)){
            return (T) new TVShowDetailViewModel(moviegramRepository);

        }else if(modelClass.isAssignableFrom(FavoriteViewModel.class)){
            return (T) new FavoriteViewModel(moviegramRepository);

        }

        throw new IllegalArgumentException("Unknown ViewModel class: -------------------- " + modelClass.getName());
    }
}
