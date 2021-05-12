package com.satmaxt.kuring;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.satmaxt.kuring.adapter.MusicVideoViewPagerAdapter;

/**
 * Tanggal Pengerjaan: 12 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class MusicVideoFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    TabLayoutMediator tabMediator;
    MusicVideoViewPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new MusicVideoViewPagerAdapter(this);
        tabLayout = view.findViewById(R.id.musicVideoTab);
        viewPager = view.findViewById(R.id.musicVideoViewPager);
        viewPager.setAdapter(adapter);

        tabMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                final String[] pages = {
                        "Musik", "Video"
                };
                tab.setText(pages[position]);
            }
        });

        tabMediator.attach();

    }
}