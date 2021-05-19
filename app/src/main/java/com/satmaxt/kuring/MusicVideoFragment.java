package com.satmaxt.kuring;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.satmaxt.kuring.adapter.MusicVideoViewPagerAdapter;
import com.satmaxt.kuring.database.AppDatabase;
import com.satmaxt.kuring.model.MusicModel;

/**
 * Tanggal Pengerjaan: 12 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class MusicVideoFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private TabLayoutMediator tabMediator;
    private MusicVideoViewPagerAdapter adapter;
    private Fragment activeFragment;
    private AppCompatDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final FloatingActionButton btnAdd = view.findViewById(R.id.addItem);
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

        dialog = new AppCompatDialog(getContext());
        dialog.setContentView(R.layout.dialog_form_music);
        dialog.getWindow()
                .setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT)
                );
        dialog.getWindow()
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Button btnClose = dialog.findViewById(R.id.btnCloseDialog);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.hide();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = viewPager.getCurrentItem();
                Log.d("CURIT", String.valueOf(current));
                // on music tab
                if(current == 0) {
                    showCreateForm("Tambah Music", current);
                }
                // on video tab
                else if(current == 1) {

                }
            }
        });
    }

    private boolean validateForm() {
        final EditText fTitle = dialog.findViewById(R.id.formTitle);
        final EditText fArtist = dialog.findViewById(R.id.formArtist);

        if(fTitle.length() < 1) {
            fTitle.setError("Judul musik tidak boleh kosong.");
            return false;
        } else if(fArtist.length() < 1) {
            fArtist.setError("Penyanyi/Artis tidak boleh kosong.");
            return false;
        }

        return true;
    }

    private void showCreateForm(String dialogTitle, int viewPagerPosition) {
        final TextView title = dialog.findViewById(R.id.dialogTitle);
        final Button btnSubmit = dialog.findViewById(R.id.btnSubmit);
        final EditText fTitle = dialog.findViewById(R.id.formTitle);
        final EditText fArtist = dialog.findViewById(R.id.formArtist);
        final MusicFragment fragment = (MusicFragment) adapter.getPages().get(viewPagerPosition);

        title.setText(dialogTitle);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()) {
                    MusicModel music = new MusicModel();
                    music.setTitle(fTitle.getText().toString());
                    music.setArtist(fArtist.getText().toString());
                    fragment.presenter.store(music);
                    fTitle.setText("");
                    fArtist.setText("");
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }
}