package com.example.qichaoqun.amerilink.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.example.qichaoqun.amerilink.NetWork.Encryption;
import com.example.qichaoqun.amerilink.NetWork.GetUtc;
import com.example.qichaoqun.amerilink.NetWork.MyNetWork;
import com.example.qichaoqun.amerilink.NetWork.ResultCallback;
import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.activity.HotelActivity;
import com.example.qichaoqun.amerilink.bean.ChoiceInfor;
import com.example.qichaoqun.amerilink.bean.MapHotel;
import com.example.qichaoqun.amerilink.bean.MapInfor;
import com.example.qichaoqun.amerilink.utils.ToolsUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

/**
 * @author qichaoqun
 * @date 2018/8/26
 */
@SuppressLint("ValidFragment")
public class MapModeFragment extends Fragment implements BaiduMap.OnMarkerClickListener, BaiduMap.OnMapClickListener {

    private Context mContext;
    private ChoiceInfor mChoiceInfor;
    private ProgressBar mProgressBar;
    private MapView mMapView;
    private MapHotel mMapHotel;
    private BaiduMap mBaiduMap;

    public MapModeFragment(){}
    public MapModeFragment(Context context, ChoiceInfor choiceInfor){
        mChoiceInfor = choiceInfor;
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getActivity().getApplicationContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup) inflater.inflate(R.layout.map_mode_fragment,container,false);
        mMapView = (MapView)container.findViewById(R.id.map_list_view);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, null));
        mProgressBar = (ProgressBar)container.findViewById(R.id.map_progressbar);
        mBaiduMap.setOnMarkerClickListener(this);
        mBaiduMap.setOnMapClickListener(this);
        return container;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //网络请求加载酒店信息，根据经纬度加载
        getHotelData();
    }

    /**
     * 获取酒店的各种信息
     */
    public void getHotelData() {
        String path = "https://testopenapi.aichotels-service.com/content/public/multi_hotels";
        //获取手机语言
        String language = getLanguage();
        if("简体中文".equals(language) || "繁体中文".equals(language)){
            path = "https://testopenapi.aichotels-service.com/content/public/multi_hotels?locale=zh_CN";
        }
        String reqUrl = "/content/public/multi_hotels";
        String secret = "0c67e1@2e4?KD5da6a4#5a2H60sd3";
        String token = Encryption.generateSignature("POST", reqUrl, GetUtc.getUTCTimeStr(), secret);
        MyNetWork.getInstance(mContext).postAsynHttp(path, token, setJson(), new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("酒店信息加载失败", "onError: "+e.getMessage());
                Toast.makeText(mContext,getResources().getString(R.string.no_result),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String str) throws IOException {
                Log.i("地图页面酒店的信息为：：", "onResponse: "+str);
                //ToolsUtils.getDate(str);
                try{
                    Gson gson = new Gson();
                    mMapHotel = gson.fromJson(str,MapHotel.class);
                    //将其设置在地图坐标上
                    setBaiduMap();
                }catch (Exception e){
                    Log.i("地图json解析错误", "onResponse: "+e.getStackTrace());
                    e.printStackTrace();
                    Toast.makeText(mContext,getResources().getString(R.string.net_error),Toast.LENGTH_SHORT).show();
                }
                mMapView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }

    /**
     * 将酒店的信息加载在地图上
     */
    private void setBaiduMap() {
        if(mMapHotel.getHotels() != null && mMapHotel.getHotels().size() > 0){
            //得到相关的bean的集合
            List<MapInfor> list = new ArrayList<>();
            addList(list);
            addOver(list);
        }else{
           Toast.makeText(mContext,getResources().getString(R.string.no_result),Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 在地图上添加覆盖物
     * @param list 坐标的集合
     */
    private void addOver(List<MapInfor> list) {
        mBaiduMap.clear();
        LatLng latLng = null;
        Marker marker = null;
        OverlayOptions options;
        for (MapInfor info : list) {
            latLng = new LatLng(info.getLatitude(), info.getLongitude());// 经纬度
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource(R.drawable.location_3);
            options = new MarkerOptions()
                    .position(latLng)
                    .icon(bitmap)// 图标
                    .zIndex(12);
            marker = (Marker) mBaiduMap.addOverlay(options);

            Bundle arg0 = new Bundle();
            arg0.putSerializable("info", info);
            marker.setExtraInfo(arg0);
        }
        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(latLng)
                .zoom(18)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory
                .newMapStatus(mMapStatus);
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.setMapStatus(msu);
    }

    /**
     * 循环添加覆盖物
     * @param list
     */
    private void addList(List<MapInfor> list){
        for(int i = 0;i < 20;i ++){
            list.add(new MapInfor(String.valueOf(mMapHotel.getHotels().get(i).getHotel_id()),Double.parseDouble(mMapHotel.getHotels().get(i).getLatitude())
                    ,Double.parseDouble(mMapHotel.getHotels().get(i).getLongitude())
                    ,mMapHotel.getHotels().get(i).getPic()
                    ,mMapHotel.getHotels().get(i).getName()));
        }
    }

    private String getLanguage() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return sharedPreferences.getString("language", null);
    }

    public String setJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("hotel_ids", "");
            jsonObject.put("latitude", Double.parseDouble(mChoiceInfor.getCityLatitude()));
            jsonObject.put("longitude", Double.parseDouble(mChoiceInfor.getCityLongitude()));
            jsonObject.put("radius", "20");
            Log.i("json字符串为：：", "setSignJson: "+jsonObject.toString());
            return jsonObject.toString().trim();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Bundle extraInfo = marker.getExtraInfo();
        MapInfor info = (MapInfor) extraInfo.getSerializable("info");
        initInfoWindow(info,marker);
        return true;
    }

    /**
     * 点击覆盖物出现弹窗并显示相应的图片
     * @param info 覆盖物的信息对象
     * @param marker 覆盖物
     */
    private void initInfoWindow(final MapInfor info, Marker marker) {
        View view = getLayoutInflater().inflate(R.layout.maker_layout, null);
        ImageView imageView = view.findViewById(R.id.map_image);
        TextView textView = view.findViewById(R.id.map_name);
        TextView textView1 = view.findViewById(R.id.daohang);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"导航被点击了",Toast.LENGTH_SHORT).show();
                //跳转到酒店详情页面
                Bundle bundle = new Bundle();
                bundle.putSerializable("choice",mChoiceInfor);
                Intent intent = new Intent(mContext, HotelActivity.class);
                intent.putExtra("hotel_id",info.getHotel_id());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
        Glide.with(mContext).load(info.getImageUrl()).skipMemoryCache(false).placeholder(R.drawable.shibai).into(imageView);
        textView.setText(info.getHotelName());
        Log.i("酒店的名称为", "initInfoWindow: "+info.getHotelName());
        final LatLng latLng = marker.getPosition();
        Point p = mBaiduMap.getProjection().toScreenLocation(latLng);//将地图上的经纬度转换成屏幕中实际的点
        p.y -= 47;//设置屏幕中点的Y轴坐标的偏移量
        LatLng ll = mBaiduMap.getProjection().fromScreenLocation(p);//把修改后的屏幕的点有转换成地图上的经纬度对象

        InfoWindow infoWindow = new InfoWindow(view, ll, 10);
        mBaiduMap.showInfoWindow(infoWindow);//显示InfoWindow
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mBaiduMap.hideInfoWindow();
    }

    @Override
    public boolean onMapPoiClick(MapPoi mapPoi) {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}
