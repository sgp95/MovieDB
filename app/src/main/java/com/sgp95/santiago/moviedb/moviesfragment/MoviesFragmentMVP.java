package com.sgp95.santiago.moviedb.moviesfragment;

import rx.Observable;

public interface MoviesFragmentMVP {
    interface View{

        void showSnackBard(String s);

        void updateData(ListViewMovieModel listViewMovieModel);

    }
    interface Presenter{

        void loadPopularMoviesList();

        void rxUnsubscribe();

        void setMovieView(MoviesFragmentMVP.View view);

    }
    interface Model{
        Observable<ListViewMovieModel> popularMovieResult();

    }
}
