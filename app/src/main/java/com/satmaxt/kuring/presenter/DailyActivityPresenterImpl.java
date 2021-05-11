package com.satmaxt.kuring.presenter;

import com.satmaxt.kuring.model.ActivityModel;
import com.satmaxt.kuring.model.FriendModel;
import com.satmaxt.kuring.view.DailyActivityView;

import java.util.ArrayList;
import java.util.List;

/**
 * Tanggal Pengerjaan: 10 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class DailyActivityPresenterImpl implements DailyActivityPresenter {

    private final List<ActivityModel> activities = new ArrayList<>();
    private final List<FriendModel> friends = new ArrayList<>();
    private final DailyActivityView view;

    public DailyActivityPresenterImpl(DailyActivityView dailyActivityView) {
        view = dailyActivityView;
        setDataActivity();
        setDataFriends();
    }

    public void setDataActivity() {
        ActivityModel activity1 = new ActivityModel();
        activity1.setActivityName("Ibadah");
        activity1.setThumbnail("https://i.imgur.com/N8BouRR.jpg");

        ActivityModel activity2 = new ActivityModel();
        activity2.setActivityName("Bersih-bersih kamar");
        activity2.setThumbnail("https://i.imgur.com/XrQ8qKB.jpg");

        ActivityModel activity3 = new ActivityModel();
        activity3.setActivityName("Olahraga");
        activity3.setThumbnail("https://i.imgur.com/QuhMEDW.jpg");

        ActivityModel activity4 = new ActivityModel();
        activity4.setActivityName("Mengerjakan Tugas");
        activity4.setThumbnail("https://i.imgur.com/49ZsWbw.jpg");

        ActivityModel activity5 = new ActivityModel();
        activity5.setActivityName("Istirahat");
        activity5.setThumbnail("https://i.imgur.com/2jabRCS.jpg");

        activities.add(activity1);
        activities.add(activity2);
        activities.add(activity5);
        activities.add(activity3);
        activities.add(activity1);
        activities.add(activity4);
        activities.add(activity5);
        activities.add(activity3);
    }

    public void setDataFriends() {
        FriendModel friend1 = new FriendModel();
        friend1.setName("Indra Harta Kenda");
        friend1.setEmail("indra@syntac.co.id");

        FriendModel friend2 = new FriendModel();
        friend2.setName("Randi Indirwan");
        friend2.setEmail("randiindir@gmail.com");

        FriendModel friend3 = new FriendModel();
        friend3.setName("Hilman Fauzi");
        friend3.setEmail("fauzi.hilman@gmail.com");

        FriendModel friend4 = new FriendModel();
        friend4.setName("John Sa");
        friend4.setEmail("(+62) 963 3402 117");

        FriendModel friend5 = new FriendModel();
        friend5.setName("Ashara Sukma");
        friend5.setEmail("zmemo-rez@velouteux.com");

        friends.add(friend1);
        friends.add(friend2);
        friends.add(friend3);
        friends.add(friend4);
        friends.add(friend5);
    }

    @Override
    public void load() {
        view.onLoad(activities, friends);
    }
}
