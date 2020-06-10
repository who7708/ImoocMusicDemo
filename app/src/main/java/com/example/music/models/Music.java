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
public class Music extends RealmObject {
    /** 歌曲地址 */
    private String url;
    /** 歌曲名 */
    private String name;
    /** 作者 */
    private String author;
    /** 歌曲时长 */
    private String time;
}
