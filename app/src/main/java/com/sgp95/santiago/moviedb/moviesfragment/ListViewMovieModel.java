package com.sgp95.santiago.moviedb.moviesfragment;


public class ListViewMovieModel {
    private final String BASE_URL_IMAGE = "http://image.tmdb.org/t/p/w185//";

    private Integer id;
    private String title;
    private String overview;
    private String posterPath;

    public ListViewMovieModel(Integer id,String title, String overview, String posterPath) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterPath = BASE_URL_IMAGE+ posterPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = BASE_URL_IMAGE+ posterPath;
    }
}
