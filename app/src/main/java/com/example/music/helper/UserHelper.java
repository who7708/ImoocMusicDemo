package com.example.music.helper;

/**
 * 1. 用户登录
 * - 当用户未登录应用时，利用 SharedPreferences 保存登录标记，即手机号
 * - 利用全局单例类 UserHelper 保存登录信息：
 * a. 用户登录之后；
 * b. 用户打开应用时，检测 SharedPreferences 是否存在登录标记，如果存在，则为 UserHelper 进行赋值；如果不存在，则进入登录页面
 * 2. 用户退出
 * - 删除 SharedPreferences 保存的登录标记，退出到登录界面
 *
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/11
 */
public class UserHelper {

    private volatile static UserHelper instance;

    private UserHelper() {
    }

    public static UserHelper getInstance() {
        if (instance == null) {
            synchronized (UserHelper.class) {
                if (instance == null) {
                    instance = new UserHelper();
                }
            }
        }
        return instance;
    }
}
