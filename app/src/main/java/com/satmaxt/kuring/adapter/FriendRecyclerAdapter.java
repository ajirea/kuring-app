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
import com.satmaxt.kuring.model.FriendModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Tanggal Pengerjaan: 10 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class FriendRecyclerAdapter extends RecyclerView.Adapter<FriendRecyclerAdapter.FriendViewHolder> {
    private final List<FriendModel> friends;

    public FriendRecyclerAdapter(List<FriendModel> friends) {
        this.friends = friends;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_friend,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        holder.setItemActivityData(friends.get(position));
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    static class FriendViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ShapeableImageView thumbnail;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.itemTitle);
            thumbnail = itemView.findViewById(R.id.itemThumbnail);
        }

        public void setItemActivityData(FriendModel friend) {
            Log.d("AVAT", friend.md5Hex("satriamaxt@gmail.com"));
            title.setText(friend.getName());
            Picasso.get()
                    .load(friend.getAvatar())
                    .placeholder(R.drawable.bg_scroll)
                    .into(thumbnail);
        }
    }
}
