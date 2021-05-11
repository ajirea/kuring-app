package com.satmaxt.kuring;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.satmaxt.kuring.adapter.GalleryRecyclerAdapter;
import com.satmaxt.kuring.model.GalleryModel;
import com.satmaxt.kuring.presenter.GalleryPresenter;
import com.satmaxt.kuring.presenter.GalleryPresenterImpl;
import com.satmaxt.kuring.view.GalleryView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 11 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class GalleryFragment extends Fragment implements GalleryView {
    private List<GalleryModel> galleries = new ArrayList<>();
    private GalleryPresenter presenter;

    private RecyclerView galleryRecycler;
    private GalleryRecyclerAdapter galleryRecyclerAdapter;
    private AppCompatDialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new GalleryPresenterImpl(this);

        galleryRecycler = view.findViewById(R.id.galleryRecycler);
        galleryRecyclerAdapter = new GalleryRecyclerAdapter(galleries);
        galleryRecycler.setAdapter(galleryRecyclerAdapter);

        initViewGalleryDialog();
        galleryRecyclerAdapter.setOnCallbackListened(new GalleryRecyclerAdapter.OnCallbackListener() {
            @Override
            public void onClick(GalleryModel gallery) {
                showViewGalleryDialog(gallery);
            }
        });

        presenter.load();
    }

    @Override
    public void onLoad(List<GalleryModel> galleries) {
        this.galleries.clear();
        this.galleries.addAll(galleries);
    }

    private void initViewGalleryDialog() {
        dialog = new AppCompatDialog(getContext());
        dialog.setContentView(R.layout.dialog_view_gallery);
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

    }

    private void showViewGalleryDialog(GalleryModel gallery) {
        TextView author = dialog.findViewById(R.id.galleryAuthor);
        ImageView image = dialog.findViewById(R.id.galleryViewImage);

        author.setText(gallery.getTitle());
        Picasso.get().load(gallery.getThumbnail()).into(image);

        dialog.show();
    }
}