package com.example.qichaoqun.amerilink.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.qichaoqun.amerilink.NetWork.Encryption;
import com.example.qichaoqun.amerilink.NetWork.GetUtc;
import com.example.qichaoqun.amerilink.NetWork.MyNetWork;
import com.example.qichaoqun.amerilink.NetWork.ResultCallback;
import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.bean.CityEvent;
import com.example.qichaoqun.amerilink.bean.Country;
import com.example.qichaoqun.amerilink.bean.RealCity;
import com.example.qichaoqun.amerilink.sider.SideBar;
import com.example.qichaoqun.amerilink.sider.SortAdapter;
import com.example.qichaoqun.amerilink.sider.City;
import com.example.qichaoqun.amerilink.utils.ActManger;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Request;

/**
 * @author qichaoqun
 * @date 2018/8/31
 */
public class CityActivity extends AppCompatActivity {
    public static final int HANDLER = 0123;
    private ListView listView;
    private SideBar sideBar;
    private ArrayList<City> list = null;
    private Gson mGson = new Gson();
    private List<RealCity> mCities = new ArrayList<>();
    private int flag = 0;
    private Country mCountry;
    private ProgressBar mProgressBar;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_layout);
        setToolBar();
        initView();
        initData();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        sideBar = (SideBar) findViewById(R.id.side_bar);
        setToolBar();
        mProgressBar = (ProgressBar)findViewById(R.id.progress_bar);
        sideBar.setOnStrSelectCallBack(new SideBar.ISideBarSelectCallBack() {
            @Override
            public void onSelectStr(int index, String selectStr) {
                for (int i = 0; i < list.size(); i++) {
                    if (selectStr.equalsIgnoreCase(list.get(i).getFirstLetter())) {
                        listView.setSelection(i); // 选择到首字母出现的位置
                        return;
                    }
                }
            }
        });
    }

    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.city_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                ActManger actManger = ActManger.getAppManger();
                actManger.finishActivity(CityActivity.this);
            }
        });
    }

    private void initData() {
        getCountryList();
    }

    /**
     * 获取国家列表
     */
    private void getCountryList(){
        String path = "https://testopenapi.aichotels-service.com/content/public/country_list";
        //获取手机语言
        String language = getLanguage();
        if ("简体中文".equals(language) || "繁体中文".equals(language)) {
            path = path + "?locale=zh_CN";
        }
        String reqUrl = "/content/public/country_list";
        String secret = "0c67e1@2e4?KD5da6a4#5a2H60sd3";
        String token = Encryption.generateSignature("GET", reqUrl, GetUtc.getUTCTimeStr(), secret);
        MyNetWork.getInstance(this).getAsynHttp(path, token, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("请求得到国家列表失败", "onError: "+e.getMessage());
                Toast.makeText(CityActivity.this,getResources().getString(R.string.error),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(String str) throws IOException {
                Log.i("获取的国家的列表为：：：", "onResponse: "+str);
                //ToolsUtils.getDate(str);
                Gson gson = new Gson();
                mCountry = gson.fromJson(str, Country.class);
                if(mCountry != null && mCountry.getCountry_list().size() > 0){
                    //加载城市列表
                    getCityList(mCountry);
                }else{
                    Log.i("加载的城市列表为空", "onResponse: "+"城市列表为空");
                }
            }
        });
    }

    /**
     * 获取城市的列表
     * @param country 国家对象
     */
    private void getCityList(Country country) {
        if(country.getCountry_list().size() > 0 && country.getCountry_list() != null){
            for(int i = 0;i < country.getCountry_list().size();i++){
                getCityName(country.getCountry_list().get(i).getCountry_id());
            }
        }
    }

    private void getCityName(String country_id) {
        String path = "https://testopenapi.aichotels-service.com/content/public/city_list/"+country_id;
        //获取手机语言
        String language = getLanguage();
        if ("简体中文".equals(language) || "繁体中文".equals(language)) {
            path = path + "?locale=zh_CN";
        }
        String reqUrl = "/content/public/city_list/"+country_id;
        String secret = "0c67e1@2e4?KD5da6a4#5a2H60sd3";
        String token = Encryption.generateSignature("GET", reqUrl, GetUtc.getUTCTimeStr(), secret);
        MyNetWork.getInstance(this).getAsynHttp(path, token, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("加载城市列表失败", "onError: "+e.getMessage());
                flag++;
            }
            @Override
            public void onResponse(String str) throws IOException {
                Log.i("城市为", "onResponse: "+str);
                mCities.add(mGson.fromJson(str,RealCity.class));
                flag++;
                Log.i("flag的值是多少：：", "onResponse: "+flag);
                if(flag == mCountry.getCountry_list().size()){
                    Log.i("数据加载完了，发送消息了", "getCityList: "+"数据加载完了，发送消息了");
                    MyHandler myHandler = new MyHandler();
                    Message message = Message.obtain();
                    message.what = HANDLER;
                    myHandler.handleMessage(message);
                }
            }
        });
    }

    private String getLanguage() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        return sharedPreferences.getString("language", null);
    }

    public class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == HANDLER){
                //处理消息
                list = new ArrayList<>();
                for(int i = 0;i < mCities.size();i++){
                    if(mCities.get(i).getCity_list() != null && mCities.get(i).getCity_list().size() > 0){
                        for(int j = 0;j < mCities.get(i).getCity_list().size();j++){
                            list.add(new City(mCities.get(i).getCity_list().get(j).getName()));
                        }
                    }else{
                        continue;
                    }
                }
                Collections.sort(list); // 对list进行排序，需要让User实现Comparable接口重写compareTo方法
                SortAdapter adapter = new SortAdapter(CityActivity.this, list);
                listView.setAdapter(adapter);
                adapter.setMyOnClickListener(new SortAdapter.MyOnClickListener() {
                    @Override
                    public void click(String name) {
                        CityEvent city = getCity(name);
                        Log.i("选中的城市的信息为：：", "click: "+city.getCityName());
                        EventBus.getDefault().post(city);
                        finish();
                    }
                });
                listView.setVisibility(View.VISIBLE);
                sideBar.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            }
        }
    }

    private CityEvent getCity(String name) {
        //某个国家中所有的城市对象
        CityEvent cityEvent = null;
        for(int i = 0;i < mCities.size();i++){
            if(mCities.get(i).getCity_list().size() > 0 && mCities.get(i).getCity_list() != null){
                for(int j = 0;j < mCities.get(i).getCity_list().size();j++){
                    list.add(new City(mCities.get(i).getCity_list().get(j).getName()));
                    if(mCities.get(i).getCity_list().get(j).getName().equals(name)){
                        cityEvent = new CityEvent();
                        cityEvent.setCityName(mCities.get(i).getCity_list().get(j).getName());
                        cityEvent.setLatitude(mCities.get(i).getCity_list().get(j).getCenter_latitude());
                        cityEvent.setLongitude(mCities.get(i).getCity_list().get(j).getCenter_longitude());
                        cityEvent.setCityId(mCities.get(i).getCity_list().get(j).getCity_id());
                    }
                }
            }else{
                continue;
            }
        }
        return cityEvent;
    }

    @Override
    protected void onStart() {
        super.onStart();
        ActManger actManger = ActManger.getAppManger();
        actManger.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
