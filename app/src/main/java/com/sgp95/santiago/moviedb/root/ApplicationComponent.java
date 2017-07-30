package com.sgp95.santiago.moviedb.root;

import com.sgp95.santiago.moviedb.DrawerMenuActivity;
import com.sgp95.santiago.moviedb.http.apimodels.ApiModuleForMovies;
import com.sgp95.santiago.moviedb.moviesfragment.MoviesFragment;
import com.sgp95.santiago.moviedb.moviesfragment.MoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules =
        {ApplicationModule.class
                ,ApiModuleForMovies.class
                , MoviesModule.class})
public interface ApplicationComponent {

    void injectMovies(MoviesFragment target);
    void injectMain(DrawerMenuActivity target);
}
