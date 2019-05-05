package com.example.qichaoqun.amerilink.application;

import android.app.Application;

import com.example.qichaoqun.amerilink.utils.LanguageUtil;

import java.util.Locale;

/**
 * @author qichaoqun
 * @date 2018/8/23
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //一般在 Application 的 onCreate() 方法中更新 Configuration
        LanguageUtil.changeAppLanguage(this, Locale.SIMPLIFIED_CHINESE, true);
    }
}

