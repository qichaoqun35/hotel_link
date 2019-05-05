package com.example.qichaoqun.amerilink.activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.utils.GetSettings;
import com.githang.statusbar.StatusBarCompat;

import java.util.Locale;

/**
 * @author qichaoqun
 * @date 20180822
 */
public class SplishActivity extends AppCompatActivity {
    /**
     * 对状态栏沉浸进行设置颜色
     */
    private static final int COLOR = Color.parseColor("#ffffff");
    /**
     * 权限请求码
     */
    private final int REQUEST_CODE = 1;
    /**
     * 所有要获取的权限
     */
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏沉浸
        StatusBarCompat.setStatusBarColor(SplishActivity.this,COLOR,true);
        setContentView(R.layout.activity_splish);
        //查看是否申请过权限
        if(getPermissionFlag() != null){
            //设置语言
            setMyLanguage();
            toMainActivity();
        }else{
            //去申请权限
            ActivityCompat.requestPermissions(SplishActivity.this,permissions,REQUEST_CODE);
            //创建相关的配置文件的存储
            setSettings();
        }
    }

    private void setMyLanguage() {
        GetSettings getSettings = new GetSettings(this);
        //得到当前用户已经设置过的语言
        String currentLanguage = getSettings.getSetting("language");
        //自动设置称用户设置过的语言
        if("简体中文".equals(currentLanguage)){
            setLanguage("zh_CN");
        }else if("English".equals(currentLanguage)){
            setLanguage("en");
        }else if("繁体中文".equals(currentLanguage)){
            setLanguage("zh_TW");
        }
    }

    /**
     * 设置语言
     * @param language 语言的代码编号
     */
    private void setLanguage(String language){
        Locale locale = new Locale(language);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration,displayMetrics);
    }


    /**
     * 当第一次启动应用时，创建相关的设置存储
     * 本次设置的是所有初始化的设置，包括语言货币类型和其他的设置
     */
    private void setSettings() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language","简体中文");
        editor.putString("money","USD");
        editor.putString("danwei","Mile");
        editor.commit();
    }

    /**
     * 经过两秒钟的时间跳转到主页面
     */
    private void toMainActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplishActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }

    /**
     * 查看是否申请过权限
     */
    private String getPermissionFlag(){
        SharedPreferences sharedPreferences = getSharedPreferences("permission",MODE_PRIVATE);
        return sharedPreferences.getString("permission",null);
    }

    /**
     * 标记已经申请过权限，并且跳转到主页面中去
     */
    private void setPermissionFlag(){
        SharedPreferences sharedPreferences = getSharedPreferences("permission",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("permission","ok");
        editor.commit();
        toMainActivity();
    }

    /**
     * 返回权限申请的结果集
     * @param requestCode 请求码
     * @param permissions 权限
     * @param grantResults 是否申请成功
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE:
                setPermissionFlag();
                break;
            default:
                break;
        }
    }
}
