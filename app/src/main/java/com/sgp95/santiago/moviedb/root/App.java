package com.sgp95.santiago.moviedb.root;


import android.app.Application;

import com.sgp95.santiago.moviedb.http.apimodels.ApiModuleForMovies;
import com.sgp95.santiago.moviedb.moviesfragment.MoviesModule;

public class App extends Application{

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModuleForMovies(new ApiModuleForMovies())
                .moviesModule(new MoviesModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
