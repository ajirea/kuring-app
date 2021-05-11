package com.satmaxt.kuring.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.satmaxt.kuring.R;
import com.satmaxt.kuring.model.WalkthroughModel;

import java.util.List;

/**
 * Tanggal Pengerjaan: 09 Mei 2021
 * NIM: 10118068
 * Nama: Satria Aji Putra Karma J
 * Kelas: IF-2 / AKB-2
 */
public class WalkthroughViewPagerAdapter extends  RecyclerView.Adapter<WalkthroughViewPagerAdapter.WalkthroughViewHolder> {

    private final List<WalkthroughModel> walkthroughs;

    public WalkthroughViewPagerAdapter(List<WalkthroughModel> walkthroughs) {
        this.walkthroughs = walkthroughs;
    }

    @NonNull
    @Override
    public WalkthroughViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WalkthroughViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_walkthrough,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull WalkthroughViewHolder holder, int position) {
        holder.setWalkthroughItemData(walkthroughs.get(position));
    }

    @Override
    public int getItemCount() {
        return walkthroughs.size();
    }

    static class WalkthroughViewHolder extends RecyclerView.ViewHolder {
        private final TextView title, description;
        private final ImageView image;

        public WalkthroughViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.wtTitle);
            description = itemView.findViewById(R.id.wtDescription);
            image = itemView.findViewById(R.id.wtImage);
        }

        public void setWalkthroughItemData(WalkthroughModel data) {

            title.setText(data.getTitle());
            description.setText(data.getDescription());
            image.setImageResource(data.getImageDrawable());
        }
    }
}
