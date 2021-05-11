package com.satmaxt.kuring.view;

import com.satmaxt.kuring.model.ActivityModel;
import com.satmaxt.kuring.model.FriendModel;

import java.util.List;

/**
 * Tanggal Pengerjaan: 10 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public interface DailyActivityView {
    void onLoad(List<ActivityModel> activities, List<FriendModel> friends);
}
