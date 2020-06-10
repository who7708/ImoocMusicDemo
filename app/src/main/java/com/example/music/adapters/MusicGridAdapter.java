package com.example.music.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.music.R;
import com.example.music.activities.AlbumListActivity;
import com.example.music.constants.MusicConstants;

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
    public void onBindViewHolder(@NonNull MusicGridViewHolder viewHolder, int position) {
        // 加载网络图片
        Glide.with(mContext)
                .load(MusicConstants.POST_PIC)
                .into(viewHolder.ivGridIcon);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 打开专辑音乐
                Intent intent = new Intent(mContext, AlbumListActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class MusicGridViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivGridIcon;
        private View itemView;

        public MusicGridViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ivGridIcon = itemView.findViewById(R.id.iv_grid_icon);
        }
    }
}
