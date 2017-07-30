package com.sgp95.santiago.moviedb.http.apimodels;

import com.sgp95.santiago.moviedb.http.apimodels.movie.Movies;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieApiService {
    @GET("/3/movie/popular")
    Observable<Movies> getMostPopularMovies(@Query("page")Integer page);
}
