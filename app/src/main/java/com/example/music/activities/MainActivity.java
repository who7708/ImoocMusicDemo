package com.example.music.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music.R;
import com.example.music.adapters.MusicGridAdapter;
import com.example.music.adapters.MusicListAdapter;
import com.example.music.view.GridSpaceItemDecoration;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class MainActivity extends BaseActivity {

    private RecyclerView mRvGrid;
    private RecyclerView mRvList;
    private MusicGridAdapter musicGridAdapter;
    private MusicListAdapter musicListAdapter;

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
        // 取消嵌套里的滚动
        mRvGrid.setNestedScrollingEnabled(false);
        musicGridAdapter = new MusicGridAdapter(this);
        mRvGrid.setAdapter(musicGridAdapter);

        /**
         * 1. 假如已知列表高度的情况下，可以直接在布局中把 RecyclerView 的高度定义上
         * 2. 不知道列表高度的情况下，需要手动计算 RecyclerView 的高度
         */
        // 最热音乐
        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRvList.setNestedScrollingEnabled(false);
        mRvList.setAdapter(new MusicListAdapter(this, mRvList));
    }

}