package com.satmaxt.kuring.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.satmaxt.kuring.model.MusicModel;

import java.util.List;

/**
 * Tanggal Pengerjaan: 17 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */

@Dao
public interface MusicDao {

    @Insert(entity = MusicModel.class)
    long storeMusic(MusicModel music);

    @Delete(entity = MusicModel.class)
    void deleteMusic(MusicModel music);

    @Update(entity = MusicModel.class)
    void updateMusic(MusicModel music);

    @Query("SELECT * FROM musics")
    List<MusicModel> getAll();
}
