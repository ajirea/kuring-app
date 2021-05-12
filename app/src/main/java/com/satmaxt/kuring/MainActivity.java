package com.satmaxt.kuring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Tanggal Pengerjaan: 09 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;

    private int currentActiveNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.bottomNav);
        navigation.setOnNavigationItemSelectedListener(navigationListener);
        navigation.setSelectedItemId(R.id.menuHome);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navigationListener = item -> {
        Fragment selectedFragment = null;

        if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
            if(navigation.getSelectedItemId() == item.getItemId()) return true;
        }

        switch (item.getItemId()) {
            case R.id.menuHome:
                selectedFragment = new HomeFragment();
                break;
            case R.id.menuDailyActivity:
                selectedFragment = new DailyActivityFragment();
                break;
            case R.id.menuGallery:
                selectedFragment = new GalleryFragment();
                break;
            case  R.id.menuMusicVideo:
                selectedFragment = new MusicVideoFragment();
                break;
        }

        if(selectedFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentHolder, selectedFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(selectedFragment.getTag())
                    .commit();
        }

        return true;
    };

    @Override
    public void onBackPressed() {
        if(navigation.getSelectedItemId()==R.id.menuHome) {
            super.onBackPressed();
            finish();
        } else {
            navigation.setSelectedItemId(R.id.menuHome);
        }
    }
}