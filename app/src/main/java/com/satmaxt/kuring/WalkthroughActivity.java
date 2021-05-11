package com.satmaxt.kuring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.satmaxt.kuring.adapter.WalkthroughViewPagerAdapter;
import com.satmaxt.kuring.model.WalkthroughModel;
import com.satmaxt.kuring.presenter.WalkthroughPresenter;
import com.satmaxt.kuring.presenter.WalkthroughPresenterImpl;
import com.satmaxt.kuring.view.WalkthroughView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 09 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class WalkthroughActivity extends AppCompatActivity implements WalkthroughView {

    private List<WalkthroughModel> walkthroughs = new ArrayList<>();
    private WalkthroughPresenter presenter;
    private TabLayoutMediator tabMediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        presenter = new WalkthroughPresenterImpl(this);

        ViewPager2 walkthroughViewPager = (ViewPager2) findViewById(R.id.wtViewPager);
        TabLayout walkthroughTab = (TabLayout) findViewById(R.id.wtTab);

        WalkthroughViewPagerAdapter adapter = new WalkthroughViewPagerAdapter(walkthroughs);
        walkthroughViewPager.setAdapter(adapter);

        tabMediator = new TabLayoutMediator(walkthroughTab, walkthroughViewPager, (tab, position) -> {});

        ImageButton btnNext = (ImageButton) findViewById(R.id.wtBtnNext);
        ImageButton btnPrev = (ImageButton) findViewById(R.id.wtBtnPrev);
        TextView btnSkip = (TextView) findViewById(R.id.wtBtnSkip);

        walkthroughViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                btnPrev.setClickable(position > 0);
                btnSkip.setVisibility(position == 0 ? View.VISIBLE : View.GONE);
            }
        });

        btnNext.setOnClickListener(v -> {
            if(walkthroughViewPager.getCurrentItem()+1 < walkthroughs.size()) {
                walkthroughViewPager.setCurrentItem(walkthroughViewPager.getCurrentItem() + 1);
            }
        });

        btnPrev.setOnClickListener(v -> {
            if(walkthroughViewPager.getCurrentItem() > 0) {
                walkthroughViewPager.setCurrentItem(walkthroughViewPager.getCurrentItem() - 1);
            }
        });

        presenter.load();
    }

    @Override
    public void onLoad(List<WalkthroughModel> walkthroughs) {
        this.walkthroughs.clear();
        this.walkthroughs.addAll(walkthroughs);
        tabMediator.attach();
    }
}