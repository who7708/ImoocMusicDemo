package com.example.music.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.blankj.utilcode.util.StringUtils;
import com.example.music.constants.MusicConstants;
import com.example.music.helper.UserHelper;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/11
 */
public class SPUtils {
    // private static SharedPreferences.Editor getEditor(Context context, String key) {
    //     SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
    //     return sp.edit();
    // }

    public static boolean saveUser(Context context, String phone) {
        SharedPreferences sp = context.getSharedPreferences(MusicConstants.SP_KEY_PHONE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(MusicConstants.SP_KEY_PHONE, phone);
        // 是不保存成功
        return editor.commit();
    }

    public static boolean isLoginUser(Context context) {
        SharedPreferences sp = context.getSharedPreferences(MusicConstants.SP_KEY_PHONE, Context.MODE_PRIVATE);
        String phone = sp.getString(MusicConstants.SP_KEY_PHONE, "");
        if (!StringUtils.isEmpty(phone)) {
            UserHelper.getInstance().setPhone(phone);
            return true;
        }
        return false;
    }

    public static boolean removeUser(Context context) {
        SharedPreferences sp = context.getSharedPreferences(MusicConstants.SP_KEY_PHONE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(MusicConstants.SP_KEY_PHONE);
        return editor.commit();
    }
}
