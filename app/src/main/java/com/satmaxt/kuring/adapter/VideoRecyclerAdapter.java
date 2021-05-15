package com.satmaxt.kuring.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.satmaxt.kuring.R;
import com.satmaxt.kuring.model.MusicModel;
import com.satmaxt.kuring.model.VideoModel;

import java.util.List;

/**
 * Tanggal Pengerjaan: 14 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class VideoRecyclerAdapter extends RecyclerView.Adapter<VideoRecyclerAdapter.VideoViewHolder> {
    private final List<VideoModel> videos;

    public VideoRecyclerAdapter(List<VideoModel> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.item_music,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        private final TextView title, creator;
        private final View thumbnail;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.itemTitle);
            creator = itemView.findViewById(R.id.itemArtist);
            thumbnail = itemView.findViewById(R.id.itemThumbnail);
        }

        public void setVideoData(VideoModel video) {
            title.setText(video.getTitle());
            creator.setText(video.getCreator());
            thumbnail.setBackgroundResource(R.drawable.ic_video);
        }
    }
}
