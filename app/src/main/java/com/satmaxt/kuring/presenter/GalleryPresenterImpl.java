package com.satmaxt.kuring.presenter;

import com.satmaxt.kuring.model.GalleryModel;
import com.satmaxt.kuring.view.GalleryView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 11 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class GalleryPresenterImpl implements GalleryPresenter {

    private List<GalleryModel> galleries = new ArrayList<>();
    private GalleryView galleryView;

    public GalleryPresenterImpl(GalleryView galleryView) {
        this.galleryView = galleryView;
        setData();
    }

    private void setData() {
//        GalleryModel gallery1 = new GalleryModel();
//        gallery1.setTitle("Photo by Karsten Würth on Unsplash");
//        gallery1.setThumbnail("https://i.imgur.com/lnuBsAx.jpg");
//
//        GalleryModel gallery2 = new GalleryModel();
//        gallery2.setTitle("Photo by Rodion Kutsaev on Unsplash");
//        gallery2.setThumbnail("https://i.imgur.com/xQeefpl.jpg");
//
//        GalleryModel gallery3 = new GalleryModel();
//        gallery3.setTitle("Photo by KAndras Vas on Unsplash");
//        gallery3.setThumbnail("https://i.imgur.com/DmsWHAS.jpg");
//
//        GalleryModel gallery4 = new GalleryModel();
//        gallery4.setTitle("Photo by Clay Banks on Unsplash");
//        gallery4.setThumbnail("https://i.imgur.com/trB7iqS.jpg");
//
//        GalleryModel gallery5 = new GalleryModel();
//        gallery5.setTitle("Photo by Pathum Danthanarayana on Unsplash");
//        gallery5.setThumbnail("https://i.imgur.com/IfCF29C.jpg");
//
//        galleries.add(gallery1);
//        galleries.add(gallery2);
//        galleries.add(gallery3);
//        galleries.add(gallery4);
//        galleries.add(gallery5);
//        galleries.add(gallery1);
//        galleries.add(gallery2);
//        galleries.add(gallery3);
//        galleries.add(gallery4);
//        galleries.add(gallery5);

        GalleryModel gallery1 = new GalleryModel();
        gallery1.setTitle("Skateboard App by Paperpillar");
        gallery1.setThumbnail("https://i.imgur.com/0d0PSEy.png");

        GalleryModel gallery2 = new GalleryModel();
        gallery2.setTitle("Movie App by Undefined");
        gallery2.setThumbnail("https://i.imgur.com/CdxfVF6.png");

        GalleryModel gallery3 = new GalleryModel();
        gallery3.setTitle("Map App by Undefined");
        gallery3.setThumbnail("https://i.imgur.com/7UIzNmM.png");

        galleries.add(gallery1);
        galleries.add(gallery2);
        galleries.add(gallery3);
        galleries.add(gallery1);
        galleries.add(gallery2);
        galleries.add(gallery3);
        galleries.add(gallery1);
        galleries.add(gallery2);
        galleries.add(gallery3);
        galleries.add(gallery1);
        galleries.add(gallery2);
        galleries.add(gallery3);
    }

    @Override
    public void load() {
        galleryView.onLoad(galleries);
    }
}
