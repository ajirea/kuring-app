package com.satmaxt.kuring.presenter;

import com.satmaxt.kuring.model.MusicModel;
import com.satmaxt.kuring.view.MusicView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 12 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class MusicPresenterImpl implements MusicPresenter {
    private List<MusicModel> musics = new ArrayList<>();
    private MusicView view;

    public MusicPresenterImpl(MusicView view) {
        this.view = view;
        setData();
    }

    private void setData() {
        MusicModel music1 = new MusicModel();
        music1.setTitle("Damai Bersamamu");
        music1.setArtist("Chrisye");

        MusicModel music2 = new MusicModel();
        music2.setTitle("Tuturut Munding");
        music2.setArtist("Doel Sumbang");

        MusicModel music3 = new MusicModel();
        music3.setTitle("Jang");
        music3.setArtist("Oon B");

        MusicModel music4 = new MusicModel();
        music4.setTitle("Tahu Cibuntu");
        music4.setArtist("Darso");

        MusicModel music5 = new MusicModel();
        music5.setTitle("Dibatas Kota Ini");
        music5.setArtist("Tommy J. Pisa");

        musics.add(music1);
        musics.add(music2);
        musics.add(music3);
        musics.add(music4);
        musics.add(music5);
        musics.add(music1);
        musics.add(music2);
        musics.add(music3);
        musics.add(music4);
        musics.add(music5);
        musics.add(music1);
        musics.add(music2);
        musics.add(music3);
        musics.add(music4);
        musics.add(music5);
        musics.add(music1);
        musics.add(music2);
        musics.add(music3);
        musics.add(music4);
        musics.add(music5);

    }

    @Override
    public void load() {
        view.onLoad(musics);
    }
}
