package com.example.music.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.music.R;
import com.example.music.helper.UserHelper;
import com.example.music.utils.UserUtils;

public class MeActivity extends BaseActivity {

    private TextView mTvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        initView();
    }

    private void initView() {
        initNavBar(true, "个人中心", false);
        mTvUser = fd(R.id.tv_user);
        mTvUser.setText(UserHelper.getInstance().getPhone());
    }

    /**
     * 修改密码点击事件
     */
    public void onChangePasswordClick(View view) {
        // UserUtils.changePasswordActivity(this);
        Intent intent = new Intent(this, ChangePasswordActivity.class);
        startActivity(intent);
    }

    /**
     * 退出登录
     */
    public void onLogoutClick(View view) {
        UserUtils.logout(this);
    }
}