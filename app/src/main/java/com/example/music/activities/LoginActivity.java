package com.example.music.activities;

import android.os.Bundle;

import com.example.music.R;

/**
 * 登录
 *
 * NavigationBar
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    /**
     * 初始化 View
     */
    private void initView() {
        initNavBar(false, "登录", false);
    }
}