package com.krazy.bee.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.krazy.bee.R;
import com.krazy.bee.network.models.photos.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterAlbumPhotos extends RecyclerView.Adapter<AdapterAlbumPhotos.ViewHolder> {
    private List<Photo> photos;

    public AdapterAlbumPhotos(List<Photo> data) {
        super();
        this.photos = data;
    }

    @NonNull
    @Override
    public AdapterAlbumPhotos.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AdapterAlbumPhotos.ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_album_photos, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.imageView.getContext()).load(photos.get(position).thumbnailUrl).into(holder.imageView);
        holder.photoText.setText(photos.get(position).title);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView photoText;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imView);
            photoText = itemView.findViewById(R.id.photo_text);
        }
    }

}