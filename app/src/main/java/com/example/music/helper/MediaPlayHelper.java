package com.example.music.helper;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/10
 */
public class MediaPlayHelper {
    private volatile static MediaPlayHelper instance;

    private Context mContext;
    private MediaPlayer mediaPlayer;
    // 当前播放音乐路径
    private String mPath;
    private OnMediaPlayerHelperListener onMediaPlayerHelperListener;

    public void setOnMediaPlayerHelperListener(OnMediaPlayerHelperListener onMediaPlayerHelperListener) {
        this.onMediaPlayerHelperListener = onMediaPlayerHelperListener;
    }

    public static MediaPlayHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (MediaPlayHelper.class) {
                if (instance == null) {
                    instance = new MediaPlayHelper(context);
                }
            }
        }
        return instance;
    }

    private MediaPlayHelper(Context mContext) {
        this.mContext = mContext;
        mediaPlayer = new MediaPlayer();
    }

    /**
     * 1. setPath 设置资源路径
     * 2. start 播放音乐
     * 3. pause 暂停播放
     */

    /**
     * 1. 音乐正在播放，重置播放状态
     * 2. 设置播放音乐路径
     * 3. 准备播放
     */
    public void setPath(String path) {
        this.mPath = path;
        // 音乐正在播放，重置播放状态
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
        }

        // 设置播放音乐路径
        try {
            mediaPlayer.setDataSource(mContext, Uri.parse(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 准备播放, 使用异步任务
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (onMediaPlayerHelperListener != null) {
                    onMediaPlayerHelperListener.onPrepared(mp);
                }
            }
        });
    }

    public String getPath() {
        return mPath;
    }

    /** 播放音乐 */
    public void start() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    /** 暂停播放 */
    public void pause() {
        mediaPlayer.pause();
    }

    public interface OnMediaPlayerHelperListener {
        void onPrepared(MediaPlayer mediaPlayer);
    }
}
