package com.example.music.helper;

import com.example.music.models.UserModel;

import java.util.List;

import io.realm.Realm;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/11
 */
public class RealmHelper {
    private Realm mRealm;

    public RealmHelper() {
        this.mRealm = Realm.getDefaultInstance();
    }

    public void close() {
        if (mRealm != null && !mRealm.isClosed()) {
            mRealm.close();
        }
    }

    public void saveUser(UserModel userModel) {
        mRealm.beginTransaction();
        mRealm.insertOrUpdate(userModel);
        mRealm.commitTransaction();
    }

    public List<UserModel> getAllUser() {
        return mRealm.where(UserModel.class).findAll();
    }



    public boolean validateUser(String phone, String password) {
        UserModel userModel =  mRealm.where(UserModel.class)
                .equalTo("phone", phone)
                .equalTo("password", password).findFirst();
        return userModel != null;
    }

}
