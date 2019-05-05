package com.example.qichaoqun.amerilink.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;

import com.example.qichaoqun.amerilink.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

import static android.content.Context.MODE_PRIVATE;

/**
 * @author qichaoqun
 * @date 2018/8/23
 */
public class GetSettings {

    private Context mContext;
    private InputStream mIs = null;

    public GetSettings(Context context) {
        mContext = context;
    }

    public String getSetting(String setting){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("settings",MODE_PRIVATE);
        return sharedPreferences.getString(setting,null);
    }

    public void setSetting(String language){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("settings",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language",language);
        editor.commit();
    }
}
