package com.satmaxt.kuring.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.satmaxt.kuring.R;
import com.satmaxt.kuring.model.ActivityModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Tanggal Pengerjaan: 10 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class ActivityRecyclerAdapter extends RecyclerView.Adapter<ActivityRecyclerAdapter.ActivityViewHolder> {
    private final List<ActivityModel> activities;

    public ActivityRecyclerAdapter(List<ActivityModel> activities) {
        this.activities = activities;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ActivityViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_activity,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        holder.setItemActivityData(activities.get(position));
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    static class ActivityViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ShapeableImageView thumbnail;

        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.itemTitle);
            thumbnail = itemView.findViewById(R.id.itemThumbnail);
        }

        public void setItemActivityData(ActivityModel activity) {
            title.setText(activity.getActivityName());
            Picasso.get()
                    .load(activity.getThumbnail())
                    .placeholder(R.drawable.bg_scroll)
                    .into(thumbnail);
        }
    }
}
