package com.satmaxt.kuring;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satmaxt.kuring.adapter.MusicRecyclerAdapter;
import com.satmaxt.kuring.model.MusicModel;
import com.satmaxt.kuring.presenter.MusicPresenter;
import com.satmaxt.kuring.presenter.MusicPresenterImpl;
import com.satmaxt.kuring.view.MusicView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 12 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class MusicFragment extends Fragment implements MusicView {

    private final List<MusicModel> musics = new ArrayList<>();
    private MusicPresenter presenter;
    private RecyclerView musicRecycler;
    private MusicRecyclerAdapter musicAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.fragment_music,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new MusicPresenterImpl(this);

        musicAdapter = new MusicRecyclerAdapter(musics);
        musicRecycler = view.findViewById(R.id.musicRecycler);
        musicRecycler.setAdapter(musicAdapter);

        presenter.load();
    }

    @Override
    public void onLoad(List<MusicModel> musics) {
        this.musics.clear();
        this.musics.addAll(musics);
    }
}