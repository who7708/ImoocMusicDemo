package com.example.music.activities;

import android.os.Bundle;
import android.view.View;

import com.example.music.R;
import com.example.music.utils.UserUtils;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        initView();
    }

    private void initView() {
        initNavBar(true, "个人中心", false);
    }

    /**
     * 修改密码点击事件
     */
    public void changePassword(View view) {

    }

    /**
     * 退出登录
     */
    public void logout(View view) {
        UserUtils.logout(this);
    }
}