package com.example.music.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.MusicViewHolder> {
    private Context mContext;

    public MusicGridAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MusicViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_music, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class MusicViewHolder extends RecyclerView.ViewHolder {
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
