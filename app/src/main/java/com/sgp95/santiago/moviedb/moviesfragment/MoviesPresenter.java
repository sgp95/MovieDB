package com.sgp95.santiago.moviedb.moviesfragment;

import android.util.Log;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MoviesPresenter implements MoviesFragmentMVP.Presenter {

    private MoviesFragmentMVP.View view;
    private MoviesFragmentMVP.Model model;
    private Subscription subscription;

    public MoviesPresenter(MoviesFragmentMVP.Model model) {
        this.model = model;
    }

    public void loadPopularMoviesList() {
        subscription = model.popularMovieResult().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListViewMovieModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.showSnackBard("Error getting movies");
                        }
                    }

                    @Override
                    public void onNext(ListViewMovieModel listViewMovieModel) {
                        if (view != null) {
                            view.updateData(listViewMovieModel);
                            Log.d("rastro",listViewMovieModel.getTitle());
                        }
                    }
                });
    }

    @Override
    public void rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    @Override
    public void setMovieView(MoviesFragmentMVP.View view) {
        this.view = view;
    }
}
