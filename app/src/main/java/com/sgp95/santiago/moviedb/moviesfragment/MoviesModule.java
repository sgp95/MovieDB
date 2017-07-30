package com.sgp95.santiago.moviedb.moviesfragment;

import android.util.Log;

import com.sgp95.santiago.moviedb.http.apimodels.MovieApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesModule {

    @Provides
    public MoviesFragmentMVP.Presenter provideMoviesFragmentPresenter(MoviesFragmentMVP.Model moviesModel){
        return new MoviesPresenter(moviesModel);
    }

    @Provides
    public MoviesFragmentMVP.Model provideMoviesFragmentModel(MRepository repository){
        return new MoviesModel(repository);
    }

    @Singleton
    @Provides
    public MRepository provideRepository(MovieApiService movieApiService){
        Log.d("rastro","provideRepository()");
        return new MoviesRepository(movieApiService);
    }
}
