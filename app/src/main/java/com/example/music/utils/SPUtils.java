package com.example.music.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.music.constants.MusicConstants;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/11
 */
public class SPUtils {
    public static boolean saveUser(Context context, String phone) {
        SharedPreferences sp = context.getSharedPreferences(MusicConstants.SP_NAME_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(MusicConstants.SP_KEY_PHONE, phone);
        boolean commit = editor.commit();
        // 是不保存成功
        return commit;
    }
}
