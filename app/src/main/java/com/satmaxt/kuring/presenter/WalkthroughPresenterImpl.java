package com.satmaxt.kuring.presenter;

import com.satmaxt.kuring.R;
import com.satmaxt.kuring.model.WalkthroughModel;
import com.satmaxt.kuring.view.WalkthroughView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 09 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class WalkthroughPresenterImpl implements WalkthroughPresenter {

    private final List<WalkthroughModel> walkthroughs = new ArrayList<>();
    private final WalkthroughView walkthroughView;

    public WalkthroughPresenterImpl(WalkthroughView walkthroughView) {
        this.walkthroughView = walkthroughView;
        setData();
    }

    public void setData() {
        WalkthroughModel model1 = new WalkthroughModel();
        model1.setTitle("Aktifitas dan Teman");
        model1.setDescription("kelola aktifitas harian serta daftar teman jadi lebih mudah sehingga setiap halnya tertata dengan rapi.");
        model1.setImageDrawable(R.drawable.il_activity_friend);

        WalkthroughModel model2 = new WalkthroughModel();
        model2.setTitle("Galeri");
        model2.setDescription("Mengelola banyak foto ke dalam bentuk galeri menjadikannya rapi dan mudah untuk dicari");
        model2.setImageDrawable(R.drawable.il_gallery);

        WalkthroughModel model3 = new WalkthroughModel();
        model3.setTitle("Musik & Video Favorit");
        model3.setDescription("Kelola musik dan video favorit kamu, dengan dikelola, kamu tidak akan lupa pernah mendengarkan musik atau menonton video apa");
        model3.setImageDrawable(R.drawable.il_music_video);

        walkthroughs.add(model1);
        walkthroughs.add(model2);
        walkthroughs.add(model3);
    }

    @Override
    public void load() {
        walkthroughView.onLoad(walkthroughs);
    }
}
