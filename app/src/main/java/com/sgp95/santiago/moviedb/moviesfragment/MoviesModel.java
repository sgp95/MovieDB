package com.sgp95.santiago.moviedb.moviesfragment;


import android.util.Log;

import com.sgp95.santiago.moviedb.http.apimodels.movie.MovieResult;

import rx.Observable;
import rx.functions.Func1;

public class MoviesModel implements MoviesFragmentMVP.Model{

    private MRepository repository;

    public MoviesModel(MRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ListViewMovieModel> popularMovieResult() {
        Log.d("rastro","popularMovieResult()");
        return repository.getMovieResultsData().map(new Func1<MovieResult, ListViewMovieModel>() {
            @Override
            public ListViewMovieModel call(MovieResult movieResult) {
                return new ListViewMovieModel(movieResult.getId()
                        ,movieResult.getTitle()
                        ,movieResult.getOverview()
                        ,movieResult.getPosterPath());
            }
        });
        /*
        return Observable.zip(repository.getMovieResultsData(), repository.getMovieResultsData(), new Func2<MovieResult, MovieResult, ListViewMovieModel>() {
            @Override
            public ListViewMovieModel call(MovieResult movieResult, MovieResult movieResult2) {
                return new ListViewMovieModel(movieResult.getId()
                        ,movieResult.getTitle()
                        ,movieResult.getOverview()
                        ,movieResult.getPosterPath());
            }
        });
        */
    }
}
