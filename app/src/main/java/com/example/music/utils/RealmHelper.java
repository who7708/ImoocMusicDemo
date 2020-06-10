package com.example.music.utils;

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

}
