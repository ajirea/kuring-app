package com.satmaxt.kuring.presenter;

import com.satmaxt.kuring.model.MusicModel;
import com.satmaxt.kuring.model.VideoModel;
import com.satmaxt.kuring.view.MusicView;
import com.satmaxt.kuring.view.VideoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 14 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class VideoPresenterImpl implements VideoPresenter {
    private final List<VideoModel> videos = new ArrayList<>();
    private final VideoView view;

    public VideoPresenterImpl(VideoView view) {
        this.view = view;
        setData();
    }

    private void setData() {
        VideoModel video1 = new VideoModel();
        video1.setTitle("How To Build An App");
        video1.setCreator("Tom Scott");

        VideoModel video2 = new VideoModel();
        video2.setTitle("Kenapa WHO Gagal Menangani Corona? | Sejarah dan Struktur WHO");
        video2.setCreator("Hipotesa");

        VideoModel video3 = new VideoModel();
        video3.setTitle("Kenapa Indonesia Korup?");
        video3.setCreator("Hipotesa");

        VideoModel video4 = new VideoModel();
        video4.setTitle("Apa itu Pencitraan? | Tindakan Pembentuk Persepsi | Hipotesa X Poliklitik");
        video4.setCreator("Hipotesa");

        videos.add(video1);
        videos.add(video2);
        videos.add(video3);
        videos.add(video4);
        videos.add(video2);
        videos.add(video3);
        videos.add(video1);
        videos.add(video4);

    }

    @Override
    public void load() {
        view.onLoad(videos);
    }
}
