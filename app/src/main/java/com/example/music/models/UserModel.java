package com.example.music.models;

import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel extends RealmObject {
    private String phone;
    private String password;
}
