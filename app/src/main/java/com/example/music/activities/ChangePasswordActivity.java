package com.example.music.activities;

import android.os.Bundle;
import android.view.View;

import com.example.music.R;
import com.example.music.utils.UserUtils;
import com.example.music.view.InputView;

public class ChangePasswordActivity extends BaseActivity {
    private InputView mInputOldPassword, mInputNewPassword, mInputNewPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initView();
    }

    private void initView() {
        initNavBar(true, "修改密码", false);
        mInputOldPassword = fd(R.id.input_old_password);
        mInputNewPassword = fd(R.id.input_new_password);
        mInputNewPasswordConfirm = fd(R.id.input_new_password_confirm);
    }

    public void changePassword(View view) {
        String oldPassword = mInputOldPassword.getInputStr();
        String newPassword = mInputNewPassword.getInputStr();
        String newPasswordConfirm = mInputNewPasswordConfirm.getInputStr();

        if (UserUtils.changeUserPassword(this, oldPassword, newPassword, newPasswordConfirm)) {
            UserUtils.logout(this);
        }
    }
}