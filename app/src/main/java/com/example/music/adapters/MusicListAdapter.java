package com.example.music.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MusicListViewHolder> {
    private Context mContext;
    private View mItemView;
    private RecyclerView mRecyclerView;

    private boolean isCalculationRecyclerViewHeight;

    public MusicListAdapter(Context context, RecyclerView recyclerView) {
        this.mContext = context;
        this.mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MusicListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, viewGroup, false);
        return new MusicListViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicListViewHolder holder, int position) {
        setRecyclerViewHeight();
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    /**
     * 1. 获取 ItemView 的高度
     * 2. 获取 ItemView 的数量
     * 3. RecyclerView 的高度 =  itemViewHeight * itemViewNum
     */
    private void setRecyclerViewHeight() {
        if (!isCalculationRecyclerViewHeight) {
            // 获取 ItemView 的高度
            RecyclerView.LayoutParams itemViewLayoutParams = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
            int itemCount = getItemCount();
            int recyclerViewHeight = itemViewLayoutParams.height * itemCount;
            LinearLayout.LayoutParams recyclerViewLayoutParams = (LinearLayout.LayoutParams) mRecyclerView.getLayoutParams();
            recyclerViewLayoutParams.height = recyclerViewHeight;
            mRecyclerView.setLayoutParams(recyclerViewLayoutParams);
            isCalculationRecyclerViewHeight = true;
        }
    }

    class MusicListViewHolder extends RecyclerView.ViewHolder {
        public MusicListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
