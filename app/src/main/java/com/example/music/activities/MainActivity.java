package com.example.music.activities;

import android.os.Bundle;

import com.example.music.R;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        initNavBar(false, "慕课音乐", true);
    }

}