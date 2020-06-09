package com.example.music.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IdRes;

import com.example.music.R;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class BaseActivity extends Activity {
    private ImageView mIvBack, mIvMe;
    private TextView mTvTitle;

    /**
     * 初始化 navigationBar
     *
     * @param showBack 是否显示返回
     * @param title    是不显示标题
     * @param showMe   是不显示我的图标
     */
    protected void initNavBar(boolean showBack, String title, boolean showMe) {
        mIvBack = fd(R.id.iv_back);
        mIvMe = fd(R.id.iv_me);
        mTvTitle = fd(R.id.tv_title);

        mIvBack.setVisibility(showBack ? View.VISIBLE : View.GONE);
        mIvMe.setVisibility(showMe ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回
                onBackPressed();
            }
        });

        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, MeActivity.class));
            }
        });
    }

    /**
     * findViewById
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T fd(@IdRes int id) {
        return findViewById(id);
    }
}
