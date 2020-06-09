package com.example.music.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.music.R;
import com.example.music.utils.UserUtils;
import com.example.music.view.InputView;

/**
 * 登录
 *
 * NavigationBar
 */
public class LoginActivity extends BaseActivity {
    private InputView mInputPhone;
    private InputView mInputPassword;

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

        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
    }

    /**
     * 跳转注册页面点击事件
     */
    public void onRegisterClick(View view) {
    }

    /**
     * 登录事件
     */
    public void onCommitClick(View view) {
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();

        // 验证登录信息
        if (!UserUtils.validateLogin(this, phone, password)) {
            return;
        }

        //  跳转到应用主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // 结束当前 activity
        finish();
    }
}