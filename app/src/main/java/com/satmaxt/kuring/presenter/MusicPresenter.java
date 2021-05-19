package com.satmaxt.kuring.presenter;

import com.satmaxt.kuring.model.MusicModel;

/**
 * Tanggal Pengerjaan: 12 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public interface MusicPresenter {
    void store(MusicModel music);
    void update(MusicModel music);
    void delete(MusicModel music);
    void load();
}
