package com.example.qichaoqun.amerilink.pager;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.example.liangmutian.mypicker.DatePickerDialog;
import com.example.liangmutian.mypicker.DateUtil;
import com.example.qichaoqun.amerilink.NetWork.GlideImageLoader;
import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.activity.CityActivity;
import com.example.qichaoqun.amerilink.activity.HotelListActivity;
import com.example.qichaoqun.amerilink.activity.MainActivity;
import com.example.qichaoqun.amerilink.activity.PassengerActivity;
import com.example.qichaoqun.amerilink.adapter.RecyclerViewAdapter;
import com.example.qichaoqun.amerilink.base.BasePager;
import com.example.qichaoqun.amerilink.bean.ChoiceInfor;
import com.example.qichaoqun.amerilink.bean.CityEvent;
import com.example.qichaoqun.amerilink.bean.MyLocation;
import com.example.qichaoqun.amerilink.bean.PassengersInfor;
import com.example.qichaoqun.amerilink.utils.ToolsUtils;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import org.apache.commons.codec.binary.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/22
 */
public class SearchPager extends BasePager implements View.OnClickListener {

    private Dialog mDateDialog;
    private ChoiceInfor mChoiceInfor;

    public SearchPager(Context context) {
        super(context);
    }

    private Banner searchBanner;
    private Toolbar myToolbar;
    private TextView topSearch;
    private TextView cityText;
    private LinearLayout locationImage;
    private TextView inDate;
    private TextView outDate;
    private TextView totalDay;
    private LinearLayout choicePassengerLayout;
    private TextView totalRoom;
    private TextView totalAdult;
    private TextView totalChild;
    private int mAllRommAmount = 1;
    private int mAllPassengerAmount;
    private int mAdultAmount1 = 1;
    private int mYoungAmount1 = 0;
    private int mChildrenAmount1 = 0;
    private boolean mIsHaveEarly;
    private Button searchButton;
    private double latitude = 34.1400;
    private double longitude = -118.0152;
    private String city = "Monrovia";
    private List<String> mList = null;

    private void findViews(View view) {
        searchBanner = (Banner) view.findViewById(R.id.search_banner);
        myToolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
        topSearch = (TextView) view.findViewById(R.id.top_search);
        cityText = (TextView) view.findViewById(R.id.city_text);
        locationImage = (LinearLayout) view.findViewById(R.id.location_image);
        inDate = (TextView) view.findViewById(R.id.in_date);
        outDate = (TextView) view.findViewById(R.id.out_date);
        totalDay = (TextView) view.findViewById(R.id.total_day);
        choicePassengerLayout = (LinearLayout) view.findViewById(R.id.choice_passenger_layout);
        totalRoom = (TextView) view.findViewById(R.id.total_room);
        totalAdult = (TextView) view.findViewById(R.id.total_adult);
        totalChild = (TextView) view.findViewById(R.id.total_child);
        searchButton = (Button) view.findViewById(R.id.search_button);
        cityText.setText("Monrovia");
        inDate.setText(ToolsUtils.getCurrentTime());
        outDate.setText(ToolsUtils.getAfterDayTime());

        topSearch.setOnClickListener(this);
        cityText.setOnClickListener(this);
        locationImage.setOnClickListener(this);
        inDate.setOnClickListener(this);
        outDate.setOnClickListener(this);
        choicePassengerLayout.setOnClickListener(this);
        searchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_search:
                break;
            case R.id.city_text:
                Intent intent = new Intent(mContext, CityActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.location_image:
                //获取定位，当前位置
                getMyLocation();
                break;
            case R.id.in_date:
                //获取选择的入住时间
                showDateDialog(DateUtil.getDateForString(ToolsUtils.getCurrentTime()), "in");
                break;
            case R.id.out_date:
                //获取选择的退房时间
                showDateDialog(DateUtil.getDateForString(ToolsUtils.getAfterDayTime()), "out");
                break;
            case R.id.choice_passenger_layout:
                Intent intent1 = new Intent(mContext, PassengerActivity.class);
                mContext.startActivity(intent1);
                //获取乘客的各种信息
                break;
            case R.id.search_button:
                searchHotel();
                break;
            default:
                break;
        }
    }

    private void searchHotel() {
        //获取各种信息，并且封装成对象
        //获取动态的地理位置
        Log.i("经纬度", "searchHotel: "+latitude);
        mChoiceInfor = new ChoiceInfor(city,
                String.valueOf(longitude),
                String.valueOf(latitude),
                inDate.getText()+"",
                outDate.getText()+"",
                mAllPassengerAmount,
                mAllRommAmount,
                mAdultAmount1,
                mYoungAmount1,
                mChildrenAmount1,
                mIsHaveEarly);
        mChoiceInfor.setList(mList);
        //跳转到酒店信息的页面
        Bundle bundle = new Bundle();
        bundle.putSerializable("choice", mChoiceInfor);
        Intent intent = new Intent(mContext, HotelListActivity.class);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }


    @Override
    public View inintView() {
        SDKInitializer.initialize(mContext.getApplicationContext());
        View view = View.inflate(mContext, R.layout.search_pager_layout, null);
        findViews(view);
        //注册广播
        EventBus.getDefault().register(this);
        return view;
    }

    /**
     * 用于处理城市信息的变更
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventCity(CityEvent cityEvent){
        city = cityEvent.getCityName();
        Log.i("event 中的城市的名称为：：", "onEventCity: "+cityEvent.getCityName());
        latitude = Double.parseDouble(cityEvent.getLatitude());
        Log.i("event 中的城市的纬度为：：", "onEventCity: "+cityEvent.getLatitude());
        longitude = Double.parseDouble(cityEvent.getLongitude());
        Log.i("event 中的城市的经度为：：", "onEventCity: "+cityEvent.getLongitude());
        cityText.setText(city);
    }

    /**
     * 用于更新乘客信息的变更,获取所有客人的信息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventPassenger(PassengersInfor passengersInfor){
        mAllRommAmount = passengersInfor.getAllRommAmount();
        Log.i("event 中的房间的数量为：：", "onEventCity: "+passengersInfor.getAllRommAmount());
        mAllPassengerAmount = passengersInfor.getAllPassengerAmount();
        mAdultAmount1 = passengersInfor.getAdultAmount1();
        mYoungAmount1 = passengersInfor.getYoungAmount1();
        mChildrenAmount1 = passengersInfor.getChildrenAmount1();
        mIsHaveEarly = passengersInfor.getHaveEatly();
        mList = passengersInfor.getList();
        Log.i("event中的包含儿童的信息的集合中的大小为", "onEventPassenger: "+mList.size());
        totalRoom.setText(String.valueOf(mAllRommAmount));
        totalAdult.setText(String.valueOf(mAllRommAmount*(mAdultAmount1+mYoungAmount1)));
        totalChild.setText(String.valueOf(mAllRommAmount*mChildrenAmount1));
    }


    @Override
    public void inintData() {
        super.inintData();
        //加载顶部轮播图的图片资源
        List<String> list = new ArrayList<>();
        list.add("https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_H.jpg");
        list.add("https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_A.jpg");
        list.add("https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_B.jpg");
        list.add("https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_C.jpg");
        list.add("https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_D.jpg");
        searchBanner.setImages(list).setImageLoader(new GlideImageLoader()).start();
        myToolbar.setTitle("");
    }

    private void showDateDialog(List<Integer> date, final String way) {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(mContext);
        builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {
                //此处将获取到的日期
                if ("in".equals(way)) {
                    inDate.setText(dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                            + (dates[2] > 9 ? dates[2] : ("0" + dates[2])));
                } else {
                    outDate.setText(dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                            + (dates[2] > 9 ? dates[2] : ("0" + dates[2])));
                }
                //设置共有几个晚上
                setTotalNight();
            }

            @Override
            public void onCancel() {
            }
        })
                .setSelectYear(date.get(0) - 1)
                .setSelectMonth(date.get(1) - 1)
                .setSelectDay(date.get(2) - 1);
        //设置显示的最小的时间点，均为今天
        builder.setMinYear(DateUtil.getYear());
        builder.setMinMonth(DateUtil.getDateForString(DateUtil.getToday()).get(1));
        builder.setMinDay(DateUtil.getDateForString(DateUtil.getToday()).get(2));
        mDateDialog = builder.create();
        mDateDialog.show();
    }

    /**
     * 设置共有多少个晚上
     */
    private void setTotalNight() {
        String inTime[] = inDate.getText().toString().split("-");
        String outTime[] = outDate.getText().toString().split("-");
        int inData = getDataFormat(inTime);
        int outData = getDataFormat(outTime);
        if (outData > inData) {
            int nights = outData - inData;
            totalDay.setText(String.valueOf(nights));
        }
    }

    /**
     * 将字符数组转为int类型的数字
     * @param str 字符数组
     * @return int类型的变量
     */
    private Integer getDataFormat(String[] str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return Integer.valueOf(sb.toString());
    }

    /**
     * 获取用户当前的位置
     */
    public void getMyLocation() {
        Location location = beginLocatioon();
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        Log.i("手机定位到的纬度为：：", "getLocation: " + latitude);
        Log.i("手机定位到的经度为：：", "getLocation: " + longitude);
        ToolsUtils.getlocation(latitude, longitude, new ToolsUtils.MyLocation() {
            @Override
            public void getMyLocation(String str) {
                Log.i("接口回调中的str位置信息是多少：：", "getMyLocation: " + str);
                Gson gson = new Gson();
                final MyLocation myLocation = gson.fromJson(str, MyLocation.class);
                if (myLocation != null) {
                    //设置称位置信息
                    city = myLocation.getResult().getAddressComponent().getCity();
                    cityText.post(new Runnable() {
                        @Override
                        public void run() {
                            cityText.setText(myLocation.getResult().getAddressComponent().getCity());
                        }
                    });
                }
            }
        });
    }

    public Location beginLocatioon() {
        LocationManager lm = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        //获得位置服务
        String provider = judgeProvider(lm);
        //有位置提供器的情况
        if (provider != null) {
            //为了压制getLastKnownLocation方法的警告
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                return null;
            }
            return lm.getLastKnownLocation(provider);
        } else {
            //不存在位置提供器的情况
            Toast.makeText(mContext, "不存在位置提供器的情况", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    private String judgeProvider(LocationManager locationManager) {
        List<String> prodiverlist = locationManager.getProviders(true);
        if (prodiverlist.contains(LocationManager.NETWORK_PROVIDER)) {
            return LocationManager.NETWORK_PROVIDER;//网络定位
        } else if (prodiverlist.contains(LocationManager.GPS_PROVIDER)) {
            return LocationManager.GPS_PROVIDER;//GPS定位
        } else {
            Toast.makeText(mContext, "没有可用的位置提供器", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
}
