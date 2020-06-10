package com.example.music.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.music.R;
import com.example.music.activities.PlayMusicActivity;
import com.example.music.constants.MusicConstants;

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
    public void onBindViewHolder(@NonNull MusicListViewHolder viewHolder, int position) {
        setRecyclerViewHeight();

        // 加载网络图片
        Glide.with(mContext)
                .load(MusicConstants.POST_PIC)
                .into(viewHolder.ivListIcon);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayMusicActivity.class);
                mContext.startActivity(intent);
            }
        });
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
        if (!isCalculationRecyclerViewHeight && mRecyclerView != null) {
            isCalculationRecyclerViewHeight = true;
            // 获取 ItemView 的高度
            RecyclerView.LayoutParams itemViewLayoutParams = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
            int itemCount = getItemCount();
            int recyclerViewHeight = itemViewLayoutParams.height * itemCount;
            LinearLayout.LayoutParams recyclerViewLayoutParams = (LinearLayout.LayoutParams) mRecyclerView.getLayoutParams();
            recyclerViewLayoutParams.height = recyclerViewHeight;
            mRecyclerView.setLayoutParams(recyclerViewLayoutParams);
        }
    }

    class MusicListViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivListIcon;
        private View itemView;

        public MusicListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ivListIcon = itemView.findViewById(R.id.iv_icon);
        }
    }
}
