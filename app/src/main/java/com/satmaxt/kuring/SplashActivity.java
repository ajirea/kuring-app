package com.satmaxt.kuring;

import androidx.appcompat.app.AppCompatActivity;

import com.satmaxt.kuring.BuildConfig;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Tanggal Pengerjaan: 09 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String versionName = BuildConfig.VERSION_NAME;
        TextView textAppVersion = (TextView) findViewById(R.id.textAppVersion);
        textAppVersion.setText(String.format("Version %s", versionName));

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, WalkthroughActivity.class));
                finish();
            }
        }, 3000);
    }
}