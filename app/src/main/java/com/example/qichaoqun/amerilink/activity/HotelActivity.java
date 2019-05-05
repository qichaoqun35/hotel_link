package com.example.qichaoqun.amerilink.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Text;
import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.example.qichaoqun.amerilink.NetWork.Encryption;
import com.example.qichaoqun.amerilink.NetWork.GetUtc;
import com.example.qichaoqun.amerilink.NetWork.GlideImageLoader;
import com.example.qichaoqun.amerilink.NetWork.MyNetWork;
import com.example.qichaoqun.amerilink.NetWork.ResultCallback;
import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.adapter.HotelListAdapter;
import com.example.qichaoqun.amerilink.adapter.OnItemClickListener;
import com.example.qichaoqun.amerilink.adapter.RoomAdapter;
import com.example.qichaoqun.amerilink.bean.ChoiceInfor;
import com.example.qichaoqun.amerilink.bean.HotelInfor;
import com.example.qichaoqun.amerilink.bean.HotelList;
import com.example.qichaoqun.amerilink.bean.RoomInfor;
import com.example.qichaoqun.amerilink.utils.ActManger;
import com.example.qichaoqun.amerilink.utils.ToolsUtils;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * @author qichaoqun
 * @date 2018/8/27
 */
public class HotelActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int ONE_STAR = 1;
    public static final int TWO_STAR = 2;
    public static final int THREE_STAR = 3;
    public static final int FOUR_STAR = 4;
    public static final int ALL_STAR = 5;
    private String mHotelId = null;
    private ChoiceInfor mChoiceInfor;
    private Toolbar mToolbar;
    private Banner mBanner;
    private TextView mHotelName;
    private TextView mHotelAddress;
    private TextView mHotelPhone;
    private TextView mHotelFix;
    private TextView mHotelStars;
    private ImageView mOneStar;
    private ImageView mTwoStar;
    private ImageView mThreeStar;
    private ImageView mFourStar;
    private ImageView mFiveStar;
    private HotelInfor mHotelInfor;
    private MapView mMapView;
    private TextView mHotelIntro;
    private RecyclerView mRecyclerView;
    private RoomInfor mRoomInfor;
    private ProgressBar mProgressBar;
    private LinearLayout mSmokingImage;
    private LinearLayout mFoodImage;
    private LocationClient mLocationClient;
    private BaiduMap mBaiduMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.hotel_layout);
        inintView();

        //获取上文传递过来的酒店的 id
        Intent intent = getIntent();
        //获取酒店的id
        mHotelId = intent.getStringExtra("hotel_id");
        //获取用户选择的酒店的条件
        mChoiceInfor = (ChoiceInfor) intent.getExtras().getSerializable("choice");
        //设置顶部toolbar
        setToolBar();
        //进行网络请求获取酒店数据
        getHotelInfor();

    }

    private void inintView() {
        mBanner = (Banner) findViewById(R.id.banner);
        mHotelName = (TextView) findViewById(R.id.hotel_infor_name);
        mHotelAddress = (TextView) findViewById(R.id.hotel_infor_address);
        mHotelPhone = (TextView) findViewById(R.id.hotel_infor_iphone);
        mHotelFix = (TextView) findViewById(R.id.hotel_infor_fix);
        mOneStar = (ImageView) findViewById(R.id.star_one);
        mTwoStar = (ImageView) findViewById(R.id.star_two);
        mThreeStar = (ImageView) findViewById(R.id.star_three);
        mFourStar = (ImageView) findViewById(R.id.star_four);
        mFiveStar = (ImageView) findViewById(R.id.star_five);
        mHotelStars = (TextView) findViewById(R.id.hotel_infor_stars);
        mProgressBar = (ProgressBar)findViewById(R.id.hotel_infor_progress);
        mSmokingImage = (LinearLayout)findViewById(R.id.smoking_image);
        mFoodImage = (LinearLayout)findViewById(R.id.food_image);
        //初始化百度地图
        mMapView = (MapView) findViewById(R.id.hotel_infor_map);
        //酒店介绍
        mHotelIntro = (TextView) findViewById(R.id.hotel_infor_intro);
        mHotelIntro.setOnClickListener(this);
        //加载酒店的房型列表
        mRecyclerView = (RecyclerView)findViewById(R.id.room_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(HotelActivity.this,
                DividerItemDecoration.VERTICAL));

    }

    private void getHotelInfor() {
        String path = "https://testopenapi.aichotels-service.com/content/public/single_hotel/" + mHotelId;
        //获取手机语言
        String language = getLanguage();
        if ("简体中文".equals(language) || "繁体中文".equals(language)) {
            path = path + "?locale=zh_CN";
        }
        String reqUrl = "/content/public/single_hotel/" + mHotelId;
        String secret = "0c67e1@2e4?KD5da6a4#5a2H60sd3";
        String token = Encryption.generateSignature("GET", reqUrl, GetUtc.getUTCTimeStr(), secret);
        //加载数据
        MyNetWork.getInstance(this).getAsynHttp(path, token, new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("网络请求出错了", "onError: " + "网络请求出错了");
            }
            @Override
            public void onResponse(String str) throws IOException {
                Log.i("网络请求的结果：：", "onResponse: " + str);
                //将数据封装成对象
                try {
                    Gson gson = new Gson();
                    mHotelInfor = gson.fromJson(str, HotelInfor.class);
                    //设置轮播图和酒店的相关信息
                    if (mHotelInfor.getOtherimages() != null && mHotelInfor.getOtherimages().size() > 0) {
                        mBanner.setImages(mHotelInfor.getOtherimages()).setImageLoader(new GlideImageLoader()).start();
                    }
                    setHotelInfor();
                } catch (Exception e) {
                    Log.i("Gson", "onResponse: " + "json数据解析失败。。。。");
                    Toast.makeText(HotelActivity.this, getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setHotelInfor() {
        mHotelName.setText(mHotelInfor.getHotel_data().getName());
        mHotelAddress.setText(mHotelInfor.getHotel_data().getAddress());
        mHotelPhone.setText(mHotelInfor.getHotel_data().getPhone());
        mHotelFix.setText(mHotelInfor.getHotel_data().getFax());
        //设置星级
        mHotelStars.setText(String.valueOf(mHotelInfor.getHotel_data().getStar()) + getResources().getString(R.string.hotel_star));
        setStarts(mHotelInfor.getHotel_data().getStar());
        //设置酒店在地图上的位置
        setMap();
        //进行第二次网络请求得到客房的相关信息
        getHotelRoomData();
    }

    private void setMap() {
        mMapView = (MapView) findViewById(R.id.hotel_infor_map);
        mLocationClient = new LocationClient(getApplicationContext());
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true,null));
        LatLng latLng = new LatLng(Double.parseDouble(mHotelInfor.getHotel_data().getLatitude())
                ,Double.parseDouble(mHotelInfor.getHotel_data().getLongitude()));
        //添加覆盖点
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.my_location);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(latLng)
                .icon(bitmap)
                .zIndex(12)
                .draggable(true);
        //在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);

        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(latLng)
                .zoom(18)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory
                .newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);
    }

    private void inintLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setCoorType("bd0911");
        int span = 1000;
        option.setScanSpan(span);
        option.setIsNeedAddress(true);
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setLocationNotify(true);
        option.setIsNeedLocationDescribe(true);
        option.setIsNeedLocationPoiList(true);
        option.setIgnoreKillProcess(false);
        option.setEnableSimulateGps(false);
        mLocationClient.setLocOption(option);

    }

    private void setStarts(int star) {
        switch (star) {
            case ONE_STAR:
                mOneStar.setVisibility(View.VISIBLE);
                break;
            case TWO_STAR:
                mOneStar.setVisibility(View.VISIBLE);
                mTwoStar.setVisibility(View.VISIBLE);
                break;
            case THREE_STAR:
                mOneStar.setVisibility(View.VISIBLE);
                mTwoStar.setVisibility(View.VISIBLE);
                mThreeStar.setVisibility(View.VISIBLE);
                break;
            case FOUR_STAR:
                mOneStar.setVisibility(View.VISIBLE);
                mTwoStar.setVisibility(View.VISIBLE);
                mThreeStar.setVisibility(View.VISIBLE);
                mFourStar.setVisibility(View.VISIBLE);
                break;
            case ALL_STAR:
                mOneStar.setVisibility(View.VISIBLE);
                mTwoStar.setVisibility(View.VISIBLE);
                mThreeStar.setVisibility(View.VISIBLE);
                mFourStar.setVisibility(View.VISIBLE);
                mFiveStar.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.hotel_infor_toolbar);
        mToolbar.setTitle(getResources().getString(R.string.hotel_infor));
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

    private String getLanguage() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        return sharedPreferences.getString("language", null);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        mBanner.startAutoPlay();

    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        mBanner.stopAutoPlay();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hotel_infor_intro:
                //弹出对话框，显示酒店的详情信息
                setDialog();
                break;
            default:
        }
    }

    private void setDialog() {
        AlertDialog alertDialog = null;
        String intro = mHotelInfor.getHotel_data().getIntro();
        if(intro != null && intro != ""){
            intro = intro.replace("<p>","");
            intro = intro.replace("</p>","\n");
            intro = intro.replace("<b>","");
            intro = intro.replace("</b>","");
            intro = intro.replace("<br/>","\n");
            alertDialog = new AlertDialog.Builder(this)
                    .setMessage(intro)
                    .setPositiveButton(getResources().getString(R.string.sure),null)
                    .create();
        }else{
            alertDialog = new AlertDialog.Builder(this)
                    .setMessage(mHotelInfor.getHotel_data().getIntro())
                    .setPositiveButton(getResources().getString(R.string.no_result),null)
                    .create();
        }
        alertDialog.show();
    }

    public void getHotelRoomData() {
        String path = "https://testopenapi.aichotels-service.com/multiplesupplier/public/search/room_availability";
        //获取手机语言
        String language = getLanguage();
        if ("简体中文".equals(language) || "繁体中文".equals(language)) {
            path = path + "?locale=zh_CN";
        }
        String reqUrl = "/multiplesupplier/public/search/room_availability";
        String secret = "0c67e1@2e4?KD5da6a4#5a2H60sd3";
        String token = Encryption.generateSignature("POST", reqUrl, GetUtc.getUTCTimeStr(), secret);
        MyNetWork.getInstance(this).postAsynHttp(path, token, setJson(), new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("酒店信息加载失败", "onError: "+"酒店信息加载失败。。");
                Toast.makeText(HotelActivity.this,getResources().getString(R.string.net_error),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(String str) throws IOException {
                Log.i("加载酒店房型的内容：：", "onResponse: "+str);
                //ToolsUtils.getDate(str);
                try {
                    Gson gson = new Gson();
                    mRoomInfor = gson.fromJson(str,RoomInfor.class);
                    if(mRoomInfor.getRoom_list() != null && mRoomInfor.getRoom_list().size() > 0){
                        //设置recyleview的adapter
                        RoomAdapter roomAdapter = new RoomAdapter(HotelActivity.this,mRoomInfor.getRoom_list());
                        mRecyclerView.setAdapter(roomAdapter);
                        //设置酒店的监听事件
                        setRoomClickListener(roomAdapter);
                    }else{
                        Toast.makeText(HotelActivity.this,getResources().getString(R.string.no_room),Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Log.i("json解析失败", "onResponse: "+"json解析异常");
                }
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }


    private void setRoomClickListener(RoomAdapter roomAdapter) {
        roomAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onCancelClick(View view, int position) {
                //Toast.makeText(HotelActivity.this,"取消规则被电击了",Toast.LENGTH_SHORT).show();
                AlertDialog alertDialog = new AlertDialog.Builder(HotelActivity.this)
                        .setTitle(getResources().getString(R.string.room_cancel)).setMessage("取消政策")

                        .setPositiveButton(getResources().getString(R.string.sure),null)
                        .create();
                        alertDialog.show();
            }

            @Override
            public void onBookingClick(View view, int position) {
                //房间的room_key
                Bundle bundle = new Bundle();
                bundle.putSerializable("choice",mChoiceInfor);
                Intent intent = new Intent(HotelActivity.this,WriteInforActivity.class);
                intent.putExtra("hotel_id",mHotelId);
                intent.putExtra("room_key",mRoomInfor.getRoom_list().get(position).getRates_and_cancellation_policies().get(0).getRoom_key());
                intent.putExtra("room_address",mHotelInfor.getHotel_data().getAddress());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private String setJson(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("hotel_id",mHotelId);
            jsonObject.put("check_in",mChoiceInfor.getInDate());
            jsonObject.put("check_out",mChoiceInfor.getOutDate());
            jsonObject.put("room_number",mChoiceInfor.getRoomAmount());
            jsonObject.put("adult_number",mChoiceInfor.getAdultSum());
            jsonObject.put("kids_number",mChoiceInfor.getChildrenPre());
            return jsonObject.toString().trim();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

}
