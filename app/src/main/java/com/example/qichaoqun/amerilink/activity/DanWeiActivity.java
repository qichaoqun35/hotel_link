package com.example.qichaoqun.amerilink.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.adapter.GeneralAdapter;
import com.example.qichaoqun.amerilink.bean.DanweiEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * @author qichaoqun
 * @date 2018/8/23
 */
public class DanWeiActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private ArrayList<String> mList;
    private final int MAIL = 0;
    private final int KM = 1;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_change_layout);
        setToolBar();

        mListView = (ListView) findViewById(R.id.money_change_list);
        mList = new ArrayList<>();
        mList.add("Mail");
        mList.add("Km");
        mListView.setAdapter(new GeneralAdapter(this, mList));
        mListView.setOnItemClickListener(this);
    }

    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.money_toolbar);
        mToolbar.setTitle(getResources().getString(R.string.danwei_setting));
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
            case MAIL:
                if ("Mail".equals(getSetting())) {
                    Toast.makeText(this, R.string.money_inform, Toast.LENGTH_SHORT).show();
                } else {
                    saveSetting("Mail");
                    Toast.makeText(this, R.string.setting_success, Toast.LENGTH_SHORT).show();
                }
                break;
            case KM:
                if ("Km".equals(getSetting())) {
                    Toast.makeText(this, R.string.setting_success, Toast.LENGTH_SHORT).show();
                } else {
                    saveSetting("Km");
                }
                break;
            default:
                break;
        }

    }

    /**
     * 将设置的单位保存起来
     *
     * @param moneyType 单位的类型
     */
    private void saveSetting(String moneyType) {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("danwei", moneyType);
        editor.commit();
        //给前台页面发送通知消息，更改前台页面显示
        EventBus.getDefault().post(new DanweiEvent(moneyType));
        this.finish();
    }

    /**
     * 获取保存起来的单位信息
     *
     * @return 单位
     */
    private String getSetting() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        return sharedPreferences.getString("danwei", null);
    }
}
