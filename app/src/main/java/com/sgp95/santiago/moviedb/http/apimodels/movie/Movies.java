
package com.sgp95.santiago.moviedb.http.apimodels.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movies implements Serializable
{

    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("total_results")
    @Expose
    public Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("movieResults")
    @Expose
    public List<MovieResult> movieResults = new ArrayList<MovieResult>();
    public final static long serialVersionUID = 243061704704881864L;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<MovieResult> getMovieResults() {
        return movieResults;
    }

    public void setMovieResults(List<MovieResult> movieResults) {
        this.movieResults = movieResults;
    }

}
