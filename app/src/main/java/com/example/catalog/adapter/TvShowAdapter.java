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
import com.example.catalog.model.TvShow;
import com.example.catalog.ui.main.tvShow.TvShowFragmentDirections;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.CardViewViewHolder> {


    private final Context context;
    private List<TvShow> listTvShow;
    private List<TvShow> getListTvShow() {
        return listTvShow;
    }
    public void setListTvShow(List<TvShow> listTvShow) {
        this.listTvShow = listTvShow;
    }
    public TvShowAdapter(Context context) {
        this.listTvShow = new ArrayList<TvShow>();
        this.context = context;
    }


    @NonNull
    @Override
    public TvShowAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new TvShowAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.CardViewViewHolder holder, int position) {
        TvShow tvShow = getListTvShow().get(position);
        Glide.with(context).load(tvShow.getCover()).centerCrop().into(holder.img);
        holder.rc_title.setText(tvShow.getTitle());
        holder.rc_date.setText(tvShow.getReleaseDate());
        holder.itemView.setOnClickListener(view -> {
            TvShowFragmentDirections.ActionTvToDetail action = TvShowFragmentDirections.actionTvToDetail(null, tvShow);
            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return getListTvShow().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView rc_title, rc_date;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            rc_title = itemView.findViewById(R.id.rc_title);
            rc_date = itemView.findViewById(R.id.rc_date);
            img = itemView.findViewById(R.id.detail_poster);
        }
    }
}