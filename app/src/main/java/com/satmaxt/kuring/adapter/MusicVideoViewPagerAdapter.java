package com.satmaxt.kuring.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.satmaxt.kuring.MusicFragment;
import com.satmaxt.kuring.VideoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 12 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class MusicVideoViewPagerAdapter extends FragmentStateAdapter {

    private final List<Fragment> pages = new ArrayList<>();
//    private final String[] pageTitles;

    public MusicVideoViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
        pages.add(new MusicFragment());
        pages.add(new VideoFragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return pages.get(position);
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }
}
