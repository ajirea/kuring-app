package com.satmaxt.kuring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }

    static class MusicViewHolder extends RecyclerView.ViewHolder {
        private final TextView title, artist;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.itemTitle);
            artist = itemView.findViewById(R.id.itemArtist);
        }

        public void setMusicData(MusicModel music) {
            title.setText(music.getTitle());
            artist.setText(music.getArtist());
        }
    }
}
