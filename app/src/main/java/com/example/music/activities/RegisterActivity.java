package com.example.music.activities;

import android.os.Bundle;
import android.view.View;

import com.example.music.R;
import com.example.music.utils.UserUtils;
import com.example.music.view.InputView;

public class RegisterActivity extends BaseActivity {

    private InputView mInputPhone, mInputPassword, mInputPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        initNavBar(true, "注册", false);
        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
        mInputPasswordConfirm = fd(R.id.input_password_confirm);
    }

    public void registerUser(View view) {
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();
        String passwordConfirm = mInputPasswordConfirm.getInputStr();

        // 注册成功进行后退
        if (UserUtils.registerUser(this, phone, password, passwordConfirm)) {
            onBackPressed();
        }
    }
}