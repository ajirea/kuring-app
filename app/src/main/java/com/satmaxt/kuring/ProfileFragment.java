package com.satmaxt.kuring;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Tanggal Pengerjaan: 15 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    private AppCompatDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button btnFindMe = view.findViewById(R.id.btnFindMe);
        final ImageButton btnPhone = view.findViewById(R.id.btnSocialPhone);
        final ImageButton btnEmail = view.findViewById(R.id.btnSocialEmail);
        final ImageButton btnTwitter = view.findViewById(R.id.btnSocialTwitter);
        final ImageButton btnFacebook = view.findViewById(R.id.btnSocialFacebook);
        final ImageButton btnInstagram = view.findViewById(R.id.btnSocialInstagram);
        final ImageButton btnInfo = view.findViewById(R.id.btnInfo);

        btnFindMe.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);
        btnInstagram.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnPhone.setOnClickListener(this);
        btnInfo.setOnClickListener(this);

        String versionName = BuildConfig.VERSION_NAME;

        dialog = new AppCompatDialog(getContext());
        dialog.setContentView(R.layout.dialog_view_about);
        dialog.getWindow()
                .setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT)
                );
        dialog.getWindow()
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Button btnClose = dialog.findViewById(R.id.btnCloseDialog);
        TextView textAppVersion = dialog.findViewById(R.id.textAppVersion);
        textAppVersion.setText(String.format("Version %s", versionName));

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSocialPhone:
                callMe();
                break;
            case R.id.btnSocialEmail:
                sendEmail();
                break;
            case R.id.btnSocialTwitter:
                openSocial("https://twitter.com/satmaxt");
                break;
            case R.id.btnSocialFacebook:
                openSocial("https://fb.me/satmaxt");
                break;
            case R.id.btnSocialInstagram:
                openSocial("https://instagram.com/satmaxt");
                break;
            case R.id.btnFindMe:
                openMap();
                break;
            case R.id.btnInfo:
                openDialog();
                break;
            default: break;
        }
    }

    private void openDialog() {
        dialog.show();
    }

    private void openMap() {
        Uri mapIntentUri = Uri.parse("geo:-6.9001963,106.8396399?label=Rumah");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if(null != mapIntent.resolveActivity(getActivity().getPackageManager())) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(null, "Google Map tidak terpasang.", Toast.LENGTH_SHORT).show();
        }
    }

    private void callMe() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+6285863331766"));
        startActivity(intent);
    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:satriamaxt@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pesan kepada Satria");
        intent.putExtra(Intent.EXTRA_TEXT, "Halo,\n\n");

        startActivity(intent);
    }

    private void openSocial(String uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
}