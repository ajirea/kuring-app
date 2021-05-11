package com.satmaxt.kuring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.satmaxt.kuring.R;
import com.satmaxt.kuring.model.GalleryModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Tanggal Pengerjaan: 11 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class GalleryRecyclerAdapter extends RecyclerView.Adapter<GalleryRecyclerAdapter.GalleryViewHolder> {
    private List<GalleryModel> galleries;
    private OnCallbackListener listener;

    public GalleryRecyclerAdapter(List<GalleryModel> galleries) {
        this.galleries = galleries;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_gallery,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.setGalleryData(galleries.get(position));
    }

    @Override
    public int getItemCount() {
        return galleries.size();
    }

    public void setOnCallbackListened(OnCallbackListener listener) {
        this.listener = listener;
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView thumbnail;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            thumbnail = itemView.findViewById(R.id.itemThumbnail);
        }

        public void setGalleryData(GalleryModel gallery) {
            Picasso.get().load(gallery.getThumbnail()).into(thumbnail);
        }

        @Override
        public void onClick(View v) {
            if(listener != null) {
                listener.onClick(galleries.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {
        void onClick(GalleryModel gallery);
    }
}
