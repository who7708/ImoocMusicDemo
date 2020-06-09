package com.example.music.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;
import com.example.music.adapters.MusicGridAdapter;
import com.example.music.view.GridSpaceItemDecoration;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class MainActivity extends BaseActivity {

    private RecyclerView mRvGrid;
    private MusicGridAdapter musicGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        initNavBar(false, "慕课音乐", true);
        mRvGrid = fd(R.id.rv_grid);

        // 同一行显示3个元素
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        // 分隔线 1dp
        // mRvGrid.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelOffset(R.dimen.albumMarginSize), mRvGrid));

        musicGridAdapter = new MusicGridAdapter(this);
        mRvGrid.setAdapter(musicGridAdapter);
    }

}