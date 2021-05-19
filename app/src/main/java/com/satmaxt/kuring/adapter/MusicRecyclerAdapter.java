package com.satmaxt.kuring.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;
import com.satmaxt.kuring.R;
import com.satmaxt.kuring.model.MusicModel;

import java.util.List;

/**
 * Tanggal Pengerjaan: 12 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class MusicRecyclerAdapter extends RecyclerView.Adapter<MusicRecyclerAdapter.MusicViewHolder> {
    private final List<MusicModel> musics;
    private OnCallbackListener listener;

    public MusicRecyclerAdapter(List<MusicModel> musics) {
        this.musics = musics;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MusicViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.item_music,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        holder.setMusicData(musics.get(position));
        holder.musicItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onClick(musics.get(position));
                }
            }
        });

        holder.btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onDelete(musics.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener) { this.listener = listener; }

    class MusicViewHolder extends RecyclerView.ViewHolder {
        private final TextView title, artist;
        private final MaterialCardView musicItem;
        private final ImageButton btnDeleteItem;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.itemTitle);
            artist = itemView.findViewById(R.id.itemArtist);
            musicItem = itemView.findViewById(R.id.musicItem);
            btnDeleteItem = itemView.findViewById(R.id.btnDeleteItem);
        }

        public void setMusicData(MusicModel music) {
            title.setText(music.getTitle());
            artist.setText(music.getArtist());
        }
    }

    public interface OnCallbackListener {
        void onClick(MusicModel music);
        void onDelete(MusicModel music);
    }
}
