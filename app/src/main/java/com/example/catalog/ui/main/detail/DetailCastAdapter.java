package com.example.catalog.ui.main.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catalog.R;
import com.example.catalog.model.Cast;
import com.example.catalog.util.Constants;

import java.util.List;

public class DetailCastAdapter extends RecyclerView.Adapter<DetailCastAdapter.ViewHolder>{

    private Context context;
    private List<Cast> castData;

    public  DetailCastAdapter(Context context){
        this.context = context;
    }

    public void setCastData(List<Cast> castData) {
        this.castData = castData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cast, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cast cast = castData.get(position);
        Glide.with(context)
                .load(Constants.BASE_IMAGE_URL + cast.getImg_url())
                .into(holder.imgCast);
        holder.castName.setText(cast.getName());
        holder.castRole.setText(cast.getRole());

    }

    @Override
    public int getItemCount() {
        return castData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCast;
        TextView castName;
        TextView castRole;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCast = itemView.findViewById(R.id.imgCast);
            castName = itemView.findViewById(R.id.castName);
            castRole = itemView.findViewById(R.id.castRole);
        }
    }
}
