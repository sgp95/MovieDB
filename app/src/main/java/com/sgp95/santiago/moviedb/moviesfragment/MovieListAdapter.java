package com.sgp95.santiago.moviedb.moviesfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sgp95.santiago.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ListMovieViewHolder> {

    private List<ListViewMovieModel> list;
    private Context context;

    public MovieListAdapter(List<ListViewMovieModel> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ListMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_row,parent,false);
        return new ListMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListMovieViewHolder holder, int position) {
        holder.movieTitle.setText(list.get(position).getTitle());
        holder.movieOverview.setText(list.get(position).getOverview());
        Picasso.with(context)
                .load(list.get(position).getPosterPath())
                .into(holder.moviePoster);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ListMovieViewHolder extends RecyclerView.ViewHolder {
        public TextView movieTitle, movieOverview;
        public ImageView moviePoster;

        public ListMovieViewHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.title);
            movieOverview = (TextView) itemView.findViewById(R.id.row_fragment_overview);
            moviePoster = (ImageView) itemView.findViewById(R.id.row_fragment_image);
        }
    }
}
