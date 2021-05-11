package com.satmaxt.kuring;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satmaxt.kuring.adapter.ActivityRecyclerAdapter;
import com.satmaxt.kuring.adapter.FriendRecyclerAdapter;
import com.satmaxt.kuring.model.ActivityModel;
import com.satmaxt.kuring.model.FriendModel;
import com.satmaxt.kuring.presenter.DailyActivityPresenter;
import com.satmaxt.kuring.presenter.DailyActivityPresenterImpl;
import com.satmaxt.kuring.view.DailyActivityView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 10 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class DailyActivityFragment extends Fragment implements DailyActivityView {
    private final List<ActivityModel> activities = new ArrayList<>();
    private final List<FriendModel> friends = new ArrayList<>();

    private DailyActivityPresenter presenter;
    private RecyclerView activityRecycler;
    private ActivityRecyclerAdapter activityRecyclerAdapter;

    private RecyclerView friendRecycler;
    private FriendRecyclerAdapter friendRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_daily_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        super.onCreate(savedInstanceState);
        presenter = new DailyActivityPresenterImpl(this);
        activityRecycler = view.findViewById(R.id.activityRecycler);
        activityRecyclerAdapter = new ActivityRecyclerAdapter(activities);
        activityRecycler.setAdapter(activityRecyclerAdapter);

        friendRecycler = view.findViewById(R.id.friendRecycler);
        friendRecyclerAdapter = new FriendRecyclerAdapter(friends);
        friendRecycler.setAdapter(friendRecyclerAdapter);

        presenter.load();
    }

    @Override
    public void onLoad(List<ActivityModel> activities, List<FriendModel> friends) {
        this.activities.clear();
        this.activities.addAll(activities);

        this.friends.clear();
        this.friends.addAll(friends);

        activityRecyclerAdapter.notifyDataSetChanged();
    }
}