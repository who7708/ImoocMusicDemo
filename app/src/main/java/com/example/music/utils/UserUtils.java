package com.example.music.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.StringUtils;
import com.example.music.R;
import com.example.music.activities.ChangePasswordActivity;
import com.example.music.activities.LoginActivity;
import com.example.music.models.UserModel;

import java.util.List;

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

    public static void logout(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        // 添加 intent 标志符， 清理 task 栈， 并重新生成一个 task 栈
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        // 定义 Activity 跳转动画。由于 task 栈被清空或重新生成了。所以需要设置一下
        ((Activity) context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
    }

    public static void changePasswordActivity(Context context) {
        Intent intent = new Intent(context, ChangePasswordActivity.class);
        // 添加 intent 标志符， 清理 task 栈， 并重新生成一个 task 栈
        // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        // 定义 Activity 跳转动画。由于 task 栈被清空或重新生成了。所以需要设置一下
        // ((Activity) context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
    }

    public static boolean registerUser(Context context, String phone, String password, String passwordConfirm) {
        if (!RegexUtils.isMobileExact(phone)) {
            Toast.makeText(context, "无效手机号", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(password) || !TextUtils.equals(password, passwordConfirm)) {
            Toast.makeText(context, "请确认密码", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (userExistFromPhone(phone)) {
            Toast.makeText(context, "该手机已存在", Toast.LENGTH_SHORT).show();
            return false;
        }

        UserModel userModel = UserModel.builder()
                .phone(phone)
                .password(EncryptUtils.encryptMD5ToString(password))
                .build();
        saveUser(userModel);
        return true;
    }

    private static void saveUser(UserModel userModel) {
        RealmHelper realmHelper = new RealmHelper();
        realmHelper.saveUser(userModel);
        realmHelper.close();
    }

    public static boolean userExistFromPhone(String phone) {
        RealmHelper realmHelper = new RealmHelper();
        List<UserModel> allUser = realmHelper.getAllUser();
        for (UserModel userModel : allUser) {
            if (StringUtils.equals(userModel.getPhone(), phone)) {
                return true;
            }
        }
        return false;
    }
}
