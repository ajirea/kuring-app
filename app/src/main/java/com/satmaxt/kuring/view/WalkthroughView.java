package com.satmaxt.kuring.view;

import com.satmaxt.kuring.model.WalkthroughModel;

import java.util.List;

/**
 * Tanggal Pengerjaan: 09 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public interface WalkthroughView {
    void finishWalk();
    void onLoad(List<WalkthroughModel> walkthroughs);
}
