package com.example.catalog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catalog.R;
import com.example.catalog.model.Movie;
import com.example.catalog.ui.main.movie.MovieFragmentDirections;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CardViewViewHolder>{

    private final Context context;
    private List<Movie> listMovie;
    private List<Movie> getListMovie() {
        return listMovie;
    }
    public void setListMovie(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }
    public MovieAdapter(Context context) {
        this.listMovie = new ArrayList<Movie>();
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MovieAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.CardViewViewHolder holder, int position) {
        Movie movie = getListMovie().get(position);
        Glide.with(context).load(movie.getCover()).centerCrop().into(holder.img);
        holder.rc_title.setText(movie.getTitle());
        holder.rc_date.setText(movie.getReleasedate());
        holder.itemView.setOnClickListener(view -> {
            MovieFragmentDirections.ActionMoviesToDetail action = MovieFragmentDirections.actionMoviesToDetail(movie, null);
            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }


    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView rc_title, rc_date;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            rc_title = itemView.findViewById(R.id.rc_title);
            rc_date  = itemView.findViewById(R.id.rc_date);
            img = itemView.findViewById(R.id.detail_poster);

        }
    }
}




