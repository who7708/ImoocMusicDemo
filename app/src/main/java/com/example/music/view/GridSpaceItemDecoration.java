package com.example.music.view;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/10
 */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;

    public GridSpaceItemDecoration(int mSpace) {
        this.mSpace = mSpace;
    }

    /**
     * @param outRect Item 的矩形边界
     * @param view    ItemView
     * @param parent  RecyclerView
     * @param state   RecyclerView 的状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;

        // 判断 Item 是不是每一行的第一个Item
        // if (parent.getChildLayoutPosition(view) % 3 == 0) {
        //     outRect.left = 0;
        // }

        // View margin,
        // margin 为正， 则 view 会距离边界产生一个距离
        // margin 为负， 则 view 会超出边界并行处理一个距离
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        // ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();

        layoutParams.leftMargin = -mSpace;
        parent.setLayoutParams(layoutParams);

    }
}
