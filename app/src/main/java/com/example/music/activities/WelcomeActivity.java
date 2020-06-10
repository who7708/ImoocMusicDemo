package com.example.music.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.music.R;
import com.example.music.utils.UserUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 1. 延时三秒
 * 2. 跳转页面
 */
public class WelcomeActivity extends BaseActivity {

    private static final String TAG = "WelcomeActivity";

    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    /**
     * 初始化
     */
    private void init() {
        final boolean isLogin = UserUtils.validateUserLogin(this);
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.e(TAG, "run: 当前线程 " + Thread.currentThread());
                if (isLogin) {
                    toMain();
                } else {
                    toLogin();
                }
            }
        }, 3000);
    }

    /**
     * 跳转到 MainActivity
     */
    private void toMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * 跳转到 LoginActivity
     */
    private void toLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        // 结束当前欢迎界面
        finish();
    }
}