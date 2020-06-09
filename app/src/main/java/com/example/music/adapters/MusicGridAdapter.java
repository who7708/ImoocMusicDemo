package com.example.music.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.music.R;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.MusicGridViewHolder> {
    private Context mContext;

    public MusicGridAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public MusicGridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MusicGridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_music, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicGridViewHolder holder, int position) {
        // 加载网络图片
        Glide.with(mContext)
                .load("http://res.lgdsunday.club/poster-1.png")
                .into(holder.ivGridIcon);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class MusicGridViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivGridIcon;

        public MusicGridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGridIcon = itemView.findViewById(R.id.iv_grid_icon);
        }
    }
}
