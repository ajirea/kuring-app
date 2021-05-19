package com.satmaxt.kuring;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.satmaxt.kuring.adapter.MusicRecyclerAdapter;
import com.satmaxt.kuring.database.AppDatabase;
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
    public MusicPresenter presenter;
    private RecyclerView musicRecycler;
    private MusicRecyclerAdapter musicAdapter;
    private AppDatabase db;
    private AppCompatDialog dialog;
    private TextView dialogTitle;
    private EditText formTitle, formArtist;

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

        db = AppDatabase.getDatabase(getContext());
        presenter = new MusicPresenterImpl(this, db.musicDao());

        musicAdapter = new MusicRecyclerAdapter(musics);
        musicRecycler = view.findViewById(R.id.musicRecycler);

        final LinearLayout iconNoData = view.findViewById(R.id.iconNoData);

        initMusicFormDialog();

        musicAdapter.setOnCallbackListener(new MusicRecyclerAdapter.OnCallbackListener() {
            @Override
            public void onClick(MusicModel music) {
                showMusicEditFormDialog(music);
            }

            @Override
            public void onDelete(MusicModel music) {
                new MaterialAlertDialogBuilder(getContext())
                        .setTitle("Hapus musik?")
                        .setMessage("Anda akan menghapus musik " + music.getTitle())
                        .setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                presenter.delete(music);
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
        musicAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                checkEmpty();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
                checkEmpty();
            }

            void checkEmpty() {
                iconNoData.setVisibility(musicAdapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
            }
        });

        musicRecycler.setAdapter(musicAdapter);

        presenter.load();
    }

    private void initMusicFormDialog() {
        dialog = new AppCompatDialog(getContext());
        dialog.setContentView(R.layout.dialog_form_music);
        dialog.getWindow()
                .setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT)
                );
        dialog.getWindow()
                .setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        dialogTitle = dialog.findViewById(R.id.dialogTitle);
        formArtist = dialog.findViewById(R.id.formArtist);
        formTitle = dialog.findViewById(R.id.formTitle);
        Button btnClose = dialog.findViewById(R.id.btnCloseDialog);

        if(btnClose != null) {
            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
    }

    private void showMusicEditFormDialog(MusicModel music) {
        if(dialog == null) initMusicFormDialog();
        dialogTitle.setText("Ubah Musik");
        formArtist.setText(music.getArtist());
        formTitle.setText(music.getTitle());
        dialog.show();

        final Button btnSubmit = dialog.findViewById(R.id.btnSubmit);

        if(btnSubmit != null) {
            btnSubmit.setText("Ubah Musik");
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(formTitle.length() < 1) {
                        formTitle.setError("Judul musik tidak boleh kosong.");
                    } else if(formArtist.length() < 1) {
                        formArtist.setError("Penyanyi/Artis tidak boleh kosong.");
                    } else {
                        music.setTitle(formTitle.getText().toString());
                        music.setArtist(formArtist.getText().toString());

                        presenter.update(music);

                        dialog.dismiss();
                    }
                }
            });
        }
    }

    @Override
    public void onUpdate() {
        presenter.load();
        Toast.makeText(getContext(), "Berhasil mengubah musik", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDelete() {
        presenter.load();
        Toast.makeText(getContext(), "Berhasil menghapus musik", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoad(List<MusicModel> musics) {
        this.musics.clear();
        this.musics.addAll(musics);
        musicAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSave() {
        presenter.load();
        Toast.makeText(getContext(), "Berhasil menambahkan musik", Toast.LENGTH_LONG).show();
    }
}