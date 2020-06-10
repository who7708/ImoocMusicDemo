package com.example.music;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import io.realm.Realm;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化 AndroidUtilCode
        Utils.init(this);
        // Initialize Realm (just once per application)
        Realm.init(this);
    }
}
