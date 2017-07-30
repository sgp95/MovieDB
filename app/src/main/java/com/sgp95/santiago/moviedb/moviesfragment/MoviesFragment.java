package com.sgp95.santiago.moviedb.moviesfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sgp95.santiago.moviedb.R;
import com.sgp95.santiago.moviedb.root.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesFragment extends Fragment implements MoviesFragmentMVP.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @BindView(R.id.list_fragment_root)
    ViewGroup viewRoot;

    @Inject
    MoviesFragmentMVP.Presenter presenter;

    private MovieListAdapter adapter;
    private List<ListViewMovieModel> listViewMovieModels = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //((App) getActivity().getApplicationContext()).getComponent().injectMovies(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment_list,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ButterKnife.bind(getActivity());
        ((App) getActivity().getApplicationContext()).getComponent().injectMovies(this);
        adapter = new MovieListAdapter(listViewMovieModels,getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.setMovieView(this);
        presenter.loadPopularMoviesList();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
        listViewMovieModels.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showSnackBard(String s) {
        Snackbar.make(viewRoot,s,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void updateData(ListViewMovieModel listViewMovieModel) {
        listViewMovieModels.add(listViewMovieModel);
        adapter.notifyItemInserted(listViewMovieModels.size()-1);
    }
}
