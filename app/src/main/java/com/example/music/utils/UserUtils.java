package com.example.music.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class UserUtils {
    /**
     * 登录信息难
     */
    public static boolean validateLogin(Context context, String phone, String password) {
        // // 简单验证
        // boolean mobileSimple = RegexUtils.isMobileSimple(phone);
        // // 精确验证
        // boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!RegexUtils.isMobileExact(phone)) {
            Toast.makeText(context, "无效手机号", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
