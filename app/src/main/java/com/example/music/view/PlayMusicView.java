package com.example.music.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.blankj.utilcode.util.StringUtils;
import com.bumptech.glide.Glide;
import com.example.music.R;
import com.example.music.utils.MediaPlayHelper;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/10
 */
public class PlayMusicView extends FrameLayout {

    private boolean isPlay;

    private Context mContext;
    private MediaPlayHelper mediaPlayHelper;
    private String mPath;

    private View mView;
    private FrameLayout mFlPlayMusic;
    private ImageView mIvIcon, mIvNeedle, mIvPlay;

    private Animation mPlayMusicAnim, mPlayNeedleAnim, mStopNeedleAnim;

    public PlayMusicView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {

        this.mContext = context;
        this.mediaPlayHelper = MediaPlayHelper.getInstance(mContext);

        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music, this, false);
        mFlPlayMusic = mView.findViewById(R.id.fl_play_music);
        mFlPlayMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trigger();
            }
        });

        mIvIcon = mView.findViewById(R.id.iv_play_music_icon);
        mIvNeedle = mView.findViewById(R.id.iv_needle);
        mIvPlay = mView.findViewById(R.id.iv_play);

        /**
         * 1. 定义所需要执行的动画
         * - 光盘转动的动画
         * - 指针指向光盘的动画
         * - 指针离开光盘的动画
         * 2. startAnimation
         */
        mPlayMusicAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_music_anim);

        mPlayNeedleAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_needle_anim);
        mStopNeedleAnim = AnimationUtils.loadAnimation(mContext, R.anim.stop_needle_anim);

        addView(mView);
    }

    /**
     * 切换播放状态
     */
    private void trigger() {
        if (isPlay) {
            stopMusic();
        } else {
            playMusic(mPath);
        }
    }

    /**
     * 播放音乐
     */
    public void playMusic(String path) {
        this.isPlay = true;
        this.mPath = path;
        mIvPlay.setVisibility(View.GONE);
        mFlPlayMusic.startAnimation(mPlayMusicAnim);
        mIvNeedle.startAnimation(mPlayNeedleAnim);

        // 1. 音乐是不已经正在播放
        // 2. 如果当前的音乐是已经在播放，那么就直接执行 start 方法
        // 3. 如果当前的音乐不是需要播放的音乐，则调用 setPath 方法
        if (StringUtils.equals(mediaPlayHelper.getPath(), path)) {
            mediaPlayHelper.start();
        } else {
            mediaPlayHelper.setPath(path);
            mediaPlayHelper.setOnMediaPlayerHelperListener(new MediaPlayHelper.OnMediaPlayerHelperListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayHelper.start();
                }
            });
        }
    }

    /**
     * 停止播放
     */
    public void stopMusic() {
        isPlay = false;
        mIvPlay.setVisibility(View.VISIBLE);
        mFlPlayMusic.clearAnimation();
        mIvNeedle.startAnimation(mStopNeedleAnim);

        mediaPlayHelper.pause();
    }

    /**
     * 设置光盘中显示的音乐封面图片
     */
    public void setMusicIcon(String url) {
        Glide.with(mContext)
                .load(url)
                .into(mIvIcon);
    }
}
