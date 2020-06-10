package com.example.music.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.example.music.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/10
 */
public class PlayMusicView extends FrameLayout {

    private Context mContext;
    private View mView;
    private CircleImageView mIvIcon;

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
        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music, this, false);
        addView(mView);
    }

    /**
     * 设置光盘中显示的音乐封面图片
     */
    public void setMusicIcon(String url) {

        mIvIcon = findViewById(R.id.iv_play_music_icon);
        Glide.with(mContext)
                .load(url)
                .into(mIvIcon);
    }
}
