package com.example.music.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/10
 */
public class WEqualsHImageView extends AppCompatImageView {

    public WEqualsHImageView(Context context) {
        super(context);
    }

    public WEqualsHImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WEqualsHImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        // // 获取 View 宽度
        // int width = MeasureSpec.getSize(widthMeasureSpec);
        // // 获取 view 模式
        // // match_parent, wrap_content, 具体 dp
        // int mode = MeasureSpec.getMode(widthMeasureSpec);

    }
}
