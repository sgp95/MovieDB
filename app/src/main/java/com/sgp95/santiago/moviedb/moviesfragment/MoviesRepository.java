package com.sgp95.santiago.moviedb.moviesfragment;

import android.util.Log;

import com.sgp95.santiago.moviedb.http.apimodels.MovieApiService;
import com.sgp95.santiago.moviedb.http.apimodels.movie.MovieResult;
import com.sgp95.santiago.moviedb.http.apimodels.movie.Movies;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class MoviesRepository implements MRepository {
    private MovieApiService movieApiService;
    private List<MovieResult> movieResults;
    private long timeStamp;

    private static final long DEPRECATED_MS = 20 * 1000;

    public MoviesRepository(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
        timeStamp = System.currentTimeMillis();
        movieResults = new ArrayList<>();
    }

    public boolean isUpToDate(){
        return System.currentTimeMillis() - timeStamp < DEPRECATED_MS;
    }

    @Override
    public Observable<MovieResult> getMovieResultsFromMemory() {
        return null;
    }

    @Override
    public Observable<MovieResult> getMovieResultsFromNetwork() {
        Observable<Movies> popularMoviesObservable = movieApiService.getMostPopularMovies(1).concatWith(movieApiService.getMostPopularMovies(2));

        return popularMoviesObservable.concatMap(new Func1<Movies, Observable<MovieResult>>() {
            @Override
            public Observable<MovieResult> call(Movies movies) {
                return Observable.from(movies.movieResults);
            }
        }).doOnNext(new Action1<MovieResult>() {
            @Override
            public void call(MovieResult movieResult) {
                movieResults.add(movieResult);
                //Log.d("response",movieResult.toString());
            }
        });
    }

    @Override
    public Observable<MovieResult> getMovieResultsData() {
        Log.d("rastro","getMovieResultsData()");
        return getMovieResultsFromNetwork();
    }
}
