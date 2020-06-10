package com.example.music;

import com.blankj.utilcode.util.GsonUtils;
import com.example.music.models.Music;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void music() {
        List<Music> music = new ArrayList<>();
        music.add(Music.builder()
                .name("小巷")
                .url("https://m10.music.126.net/20200610181330/46ba397540967431f26d1e606448fb59/yyaac/075c/070b/555b/064d81117d0a041d9287b14e1acdcee8.m4a")
                .author("安子与九妹")
                .time("0618")
                .build());

        music.add(Music.builder()
                .name("你的酒馆对我打了烊")
                .url("https://m10.music.126.net/20200610183139/677b20266ae44c75f917f01d63cce43c/ymusic/8282/098a/d744/be1e1d3c2a46b4cbd259aca7ff050cd3.mp3\n")
                .author("陈雪凝")
                .time("0411")
                .build());

        music.add(Music.builder()
                .name("芒种")
                .url("https://m10.music.126.net/20200610183139/677b20266ae44c75f917f01d63cce43c/ymusic/8282/098a/d744/be1e1d3c2a46b4cbd259aca7ff050cd3.mp3\n")
                .author("音阙诗听/赵方婧")
                .time("0336")
                .build());

        music.add(Music.builder()
                .name("你的答案")
                .url("https://m10.music.126.net/20200610183617/9edb442890cb5227e6acb66abf50242c/yyaac/5608/555a/005c/ab410f7bbbb0955e7ae476ae89527a5d.m4a")
                .author("阿冗")
                .time("0339")
                .build());

        music.add(Music.builder()
                .name("下山")
                .url("https://m10.music.126.net/20200610183826/355accb12eaa1ff6aef832ea04d4aa0d/yyaac/015a/055d/525a/60ea8f22932761f95da8e0df17c5d319.m4a")
                .author("要不要买菜")
                .time("0253")
                .build());

        music.add(Music.builder()
                .name("嚣张")
                .url("https://m10.music.126.net/20200610183907/b44222ccdb565e8b153796e6b1f4fbb1/yyaac/560e/550e/0208/adcc871d55bd7e1bf16f5b2a40ba6ee5.m4a")
                .author("en")
                .time("0414")
                .build());

        music.add(Music.builder()
                .name("世间美好与你环环相扣")
                .url("https://m10.music.126.net/20200610184001/48dcd209df1116c5f5e0d68d96d7629c/yyaac/0708/0652/0508/0b9b6827b718aa223af92bd52aa2424f.m4a")
                .author("柏松")
                .time("0312")
                .build());

        music.add(Music.builder()
                .name("野狼disco")
                .url("https://m10.music.126.net/20200610184058/4a564a1dc1971a65beb74b7c9d510879/yyaac/520f/015f/0e5c/ee9354105965290d6861965e295b5e7a.m4a")
                .author("宝石Gem")
                .time("0359")
                .build());
        String json = GsonUtils.toJson(music);
        System.out.println(json);
    }
}