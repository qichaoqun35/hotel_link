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
import com.example.qichaoqun.amerilink.bean.MoneyEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * @author qichaoqun
 * @date 2018/8/23
 */
public class MoneyActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<String> mList = null;
    private ListView mListView;
    private final int USD = 0;
    private final int CAD = 1;
    private final int EUR = 2;
    private final int JPY = 3;
    private final int CNY = 4;
    private final int BRL = 5;
    private final int INR = 6;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_change_layout);
        setToolBar();

        mListView = (ListView)findViewById(R.id.money_change_list);
        mList = new ArrayList<>();
        mList.add("USD($)");
        mList.add("CAD(CA$)");
        mList.add("EUR");
        mList.add("JPY(￥)");
        mList.add("CNY(CN￥)");
        mList.add("BRL(R$)");
        mList.add("INR(Rs)");
        mListView.setAdapter(new GeneralAdapter(this,mList));
        mListView.setOnItemClickListener(this);
    }

    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.money_toolbar);
        mToolbar.setTitle(getResources().getString(R.string.money_setting));
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
            case USD:
                setMoney("USD");
                break;
            case CAD:
                setMoney("CAD");
                break;
            case EUR:
                setMoney("EUR");
                break;
            case JPY:
                setMoney("JPY");
                break;
            case CNY:
                setMoney("CNY");
                break;
            case BRL:
                setMoney("BRL");
                break;
            case INR:
                setMoney("INR");
                break;
            default:
                break;
        }
    }

    private void setMoney(String moneyName) {
        if(moneyName.equals(getSetting())){
            Toast.makeText(this, R.string.money_inform,Toast.LENGTH_SHORT).show();
        }else{
            saveSetting(moneyName);
            Toast.makeText(this,R.string.setting_success,Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 保存选择的货币
     * @param moneyType 货币类型
     */
    private void saveSetting(String moneyType){
        SharedPreferences sharedPreferences = getSharedPreferences("settings",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("money",moneyType);
        editor.commit();
        //给前台页面发送通知消息，更改前台页面显示
        EventBus.getDefault().post(new MoneyEvent(moneyType));
        this.finish();
    }

    private String getSetting(){
        SharedPreferences sharedPreferences = getSharedPreferences("settings",MODE_PRIVATE);
        return sharedPreferences.getString("money",null);
    }

}
