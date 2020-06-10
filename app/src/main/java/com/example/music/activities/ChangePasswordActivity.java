package com.example.music.activities;

import android.os.Bundle;
import android.view.View;

import com.example.music.R;
import com.example.music.view.InputView;

public class ChangePasswordActivity extends BaseActivity {
    private InputView mInputPhone, mInputPassword, mInputPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initView();
    }

    private void initView() {
        initNavBar(true, "修改密码", false);

    }

    public void changePassword(View view) {
    }
}