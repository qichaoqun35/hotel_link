package com.example.qichaoqun.amerilink.fragment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qichaoqun.amerilink.NetWork.Encryption;
import com.example.qichaoqun.amerilink.NetWork.GetUtc;
import com.example.qichaoqun.amerilink.NetWork.MyNetWork;
import com.example.qichaoqun.amerilink.NetWork.ResultCallback;
import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.activity.HotelActivity;
import com.example.qichaoqun.amerilink.adapter.HotelListAdapter;
import com.example.qichaoqun.amerilink.bean.ChoiceInfor;
import com.example.qichaoqun.amerilink.bean.HotelList;
import com.example.qichaoqun.amerilink.bean.HotelMoney;
import com.example.qichaoqun.amerilink.bean.MoneyEvent;
import com.example.qichaoqun.amerilink.utils.ToolsUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * @author qichaoqun
 * @date 2018/8/26
 */
@SuppressLint("ValidFragment")
public class ListModeFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Context mContext;
    private ChoiceInfor mChoiceInfor;
    private ListView mListView;
    private TextView mTextView;
    private ProgressBar mProgressBar;
    private HotelList mHotelList = null;

    public ListModeFragment(Context context, ChoiceInfor choiceInfor) {
        mChoiceInfor = choiceInfor;
        mContext = context;
    }

    public ListModeFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        container = (ViewGroup) inflater.inflate(R.layout.list_mode_fragment, container, false);

        mListView = container.findViewById(R.id.hotel_list);
        mListView.setOnItemClickListener(this);
        mTextView = container.findViewById(R.id.no_content_text);
        mProgressBar = container.findViewById(R.id.progress_bar);

        return container;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //注册广播，用与接收当货币类型发生变化时，刷新列表
        EventBus.getDefault().register(this);
        //网络访问数据
        getHotelList();
    }

    /**
     * 货币类型发生改变，更新价格列表
     * @param moneyEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMoneyChange(MoneyEvent moneyEvent){
        if(mHotelList.getHotel_list() != null && mHotelList.getHotel_list().size() > 0){
            mListView.setAdapter(new HotelListAdapter(mContext,mHotelList.getHotel_list()));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //将hotel_id传递到酒店详情信息页面
        //通过hotel_id来得到相关的酒店的信息
        Bundle bundle = new Bundle();
        bundle.putSerializable("choice",mChoiceInfor);
        Intent intent = new Intent(mContext, HotelActivity.class);
        intent.putExtras(bundle);
        intent.putExtra("hotel_id", String.valueOf(mHotelList.getHotel_list().get(position).getHotel_id()));
        mContext.startActivity(intent);
    }


    /**
     * 获取手机应用语言
     * @return 语言
     */
    private String getLanguage() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("settings", Context.MODE_PRIVATE);
        return sharedPreferences.getString("language", null);
    }

    /**
     * 获取酒店价格列表
     */
    public void getHotelList() {
        String path = "https://testopenapi.aichotels-service.com/multiplesupplier/public/search/hotels";
        //获取手机语言
        String language = getLanguage();
        if("简体中文".equals(language) || "繁体中文".equals(language)){
            path = "https://testopenapi.aichotels-service.com/multiplesupplier/public/search/hotels?locale=zh_CN";
        }
        String reqUrl = "/multiplesupplier/public/search/hotels";
        String secret = "0c67e1@2e4?KD5da6a4#5a2H60sd3";
        String token = Encryption.generateSignature("POST", reqUrl, GetUtc.getUTCTimeStr(), secret);
        MyNetWork.getInstance(mContext).postAsynHttp(path, token, getJson(), new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("请求失败", "onError: " + "网络数据请求失败");
                Toast.makeText(mContext,getResources().getString(R.string.no_time),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String str) throws IOException {
                Log.i("请求得到的酒店数据：：", "onResponse: " + str);
                ToolsUtils.getDate(str);
                try {
                    Gson gson = new Gson();
                    mHotelList = gson.fromJson(str,HotelList.class);
                    if(mHotelList.getHotel_list() != null && mHotelList.getHotel_list().size() > 0){
                        mListView.setAdapter(new HotelListAdapter(mContext,mHotelList.getHotel_list()));
                    }else{
                        mTextView.setVisibility(View.VISIBLE);
                    }
                }catch (Exception e){
                    Log.i("Gson解析错误", "onResponse: "+e.getStackTrace());
                    e.printStackTrace();
                    Toast.makeText(mContext,getResources().getString(R.string.error),Toast.LENGTH_SHORT).show();
                }
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }

    public String getJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("hotel_ids", "");
            jsonObject.put("latitude", mChoiceInfor.getCityLatitude());
            jsonObject.put("longitude", mChoiceInfor.getCityLongitude());
            jsonObject.put("radius", 20);
            jsonObject.put("check_in", mChoiceInfor.getInDate());
            jsonObject.put("check_out", mChoiceInfor.getOutDate());
            jsonObject.put("room_number", mChoiceInfor.getRoomAmount());
            jsonObject.put("adult_number", mChoiceInfor.getAdultSum());
            Log.i("json解析中总的成人数", "getJson: "+mChoiceInfor.getAdultSum());
            jsonObject.put("kids_number", mChoiceInfor.getChildrenPre());
            jsonObject.put("light", 0);
            return jsonObject.toString().trim();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
