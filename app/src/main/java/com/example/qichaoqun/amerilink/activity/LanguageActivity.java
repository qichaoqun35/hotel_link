package com.example.qichaoqun.amerilink.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.adapter.GeneralAdapter;
import com.example.qichaoqun.amerilink.utils.ActManger;
import com.example.qichaoqun.amerilink.utils.GetSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author qichaoqun
 * @date 2018/8/23
 */
public class LanguageActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<String> mList = null;
    private ListView mLanguageListView;
    private final int SIMPLIFY_CHINESE = 0;
    private final int ENGLISH = 1;
    private final int TRADITIONAL_CHINESE = 2;
    private GetSettings mGetSettings;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_layout);
        setToolBar();

        mLanguageListView = (ListView) findViewById(R.id.language_list_view);
        mList = new ArrayList<>();
        mList.add("简体中文");
        mList.add("English");
        mList.add("繁體中文");
        mLanguageListView.setAdapter(new GeneralAdapter(this, mList));
        mLanguageListView.setOnItemClickListener(this);

    }

    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.language_toolbar);
        mToolbar.setTitle(getResources().getString(R.string.language_setting));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case SIMPLIFY_CHINESE:
                //读取当前的语言,判断当前语言是否是中文
                setLanguage("简体中文","zh_CN");
                break;
            case ENGLISH:
                setLanguage("English","en");
                break;
            case TRADITIONAL_CHINESE:
                setLanguage("繁体中文","zh_TW");
                break;
            default:
                break;
        }
    }

    private void setLanguage(String name,String code) {
        if(name.equals(currentLanguage())){
            Toast.makeText(this,"已经为"+name+"无重复设置。",Toast.LENGTH_SHORT).show();
        }else{
            //切换语言
            setLanguage(code);
            //将新设置的语言存储到 sharedperference 中
            mGetSettings.setSetting(name);
            //将上一个页面消失掉
            ActManger actManger = ActManger.getAppManger();
            actManger.finishActivity();
            Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获取当前语言
     */
    private String currentLanguage(){
        mGetSettings = new GetSettings(this);
        return mGetSettings.getSetting("language");
    }

    /**
     * 设置本地语言
     */
    private void setLanguage(String language){
        Locale locale = new Locale(language);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration,displayMetrics);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
