package com.satmaxt.kuring;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satmaxt.kuring.adapter.MusicRecyclerAdapter;
import com.satmaxt.kuring.adapter.VideoRecyclerAdapter;
import com.satmaxt.kuring.model.MusicModel;
import com.satmaxt.kuring.model.VideoModel;
import com.satmaxt.kuring.presenter.MusicPresenter;
import com.satmaxt.kuring.presenter.MusicPresenterImpl;
import com.satmaxt.kuring.presenter.VideoPresenter;
import com.satmaxt.kuring.presenter.VideoPresenterImpl;
import com.satmaxt.kuring.view.VideoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 12 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class VideoFragment extends Fragment implements VideoView {

    private final List<VideoModel> videos = new ArrayList<>();
    private VideoPresenter presenter;
    private RecyclerView videoRecycler;
    private VideoRecyclerAdapter videoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new VideoPresenterImpl(this);

        videoAdapter = new VideoRecyclerAdapter(videos);
        videoRecycler = view.findViewById(R.id.videoRecycler);
        videoRecycler.setAdapter(videoAdapter);

        presenter.load();
    }

    @Override
    public void onLoad(List<VideoModel> videos) {
        this.videos.clear();
        this.videos.addAll(videos);
    }
}