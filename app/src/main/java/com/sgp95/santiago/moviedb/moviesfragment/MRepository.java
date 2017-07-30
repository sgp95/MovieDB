package com.sgp95.santiago.moviedb.moviesfragment;


import com.sgp95.santiago.moviedb.http.apimodels.movie.MovieResult;

import rx.Observable;

public interface MRepository {
    Observable<MovieResult> getMovieResultsFromMemory();

    Observable<MovieResult> getMovieResultsFromNetwork();

    Observable<MovieResult> getMovieResultsData();
}
