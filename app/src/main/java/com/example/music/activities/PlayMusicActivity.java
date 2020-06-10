package com.example.music.activities;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.music.R;
import com.example.music.constants.MusicConstants;
import com.example.music.view.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {

    // 背景图片
    private ImageView mIvBg;

    private PlayMusicView mPlayMusicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        // 隐藏 statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // glide-transformations
        initView();
    }

    private void initView() {
        mIvBg = fd(R.id.iv_bg);
        Glide.with(this)
                .load(MusicConstants.POST_PIC)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                .into(mIvBg);

        // 初始化 play_music
        mPlayMusicView = fd(R.id.play_music_view);
        mPlayMusicView.setMusicIcon(MusicConstants.POST_PIC);
        mPlayMusicView.playMusic();
    }

    public void onBackClick(View view) {
        // 回退
        onBackPressed();
    }
}