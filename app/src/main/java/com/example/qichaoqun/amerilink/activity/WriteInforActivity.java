package com.example.qichaoqun.amerilink.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qichaoqun.amerilink.NetWork.Encryption;
import com.example.qichaoqun.amerilink.NetWork.GetUtc;
import com.example.qichaoqun.amerilink.NetWork.MyNetWork;
import com.example.qichaoqun.amerilink.NetWork.ResultCallback;
import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.bean.ChoiceInfor;
import com.example.qichaoqun.amerilink.bean.OrderCheck;
import com.example.qichaoqun.amerilink.bean.Passenger;
import com.example.qichaoqun.amerilink.utils.ToolsUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class WriteInforActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ChoiceInfor mChoiceInfor;
    private String mHotelId;
    private String mRoomKey;
    private Toolbar mToolbar;
    private TextView roomName;
    private TextView roomAddress;
    private TextView roomType;
    private TextView roomDesc;
    private TextView inDate;
    private TextView outDate;
    private TextView sum;
    private String mAddress;
    private ProgressBar mProgressBar;
    private LinearLayout mParentLayout;
    private Button mSureButton;
    private Button mCancelButton;
    private TextView mShouldPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_infor_layout);
        //获取传递过来的信息
        Intent intent = getIntent();
        mChoiceInfor = (ChoiceInfor) intent.getExtras().getSerializable("choice");
        mHotelId = intent.getStringExtra("hotel_id");
        mRoomKey = intent.getStringExtra("room_key");
        mAddress = intent.getStringExtra("room_address");
        //设置toolbar
        setToolBar();
        //初始化控件
        findViews();
        //加载数据，校验订单
        getOrderData();
        //代码生成客人信息
        setPassengerInfor();
    }


    private void findViews() {
        roomName = (TextView)findViewById( R.id.room_name );
        roomAddress = (TextView)findViewById( R.id.room_address );
        roomType = (TextView)findViewById( R.id.room_type );
        roomDesc = (TextView)findViewById( R.id.room_desc );
        inDate = (TextView)findViewById( R.id.in_date );
        outDate = (TextView)findViewById( R.id.out_date );
        sum = (TextView)findViewById( R.id.sum );
        mProgressBar = (ProgressBar)findViewById(R.id.progress_bar);
        mParentLayout = (LinearLayout)findViewById(R.id.parent_control);
        mSureButton = (Button)findViewById(R.id.sure_button);
        mCancelButton = (Button)findViewById(R.id.cancel_button);
        mShouldPay = (TextView)findViewById(R.id.should_pay_money);

        mSureButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);
    }


    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.write_tool_bar);
        mToolbar.setTitle(getResources().getString(R.string.write_infor));
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

    public void getOrderData() {
        String path = "https://testopenapi.aichotels-service.com/multiplesupplier/public/booking/prebook";
        //获取手机语言
        String language = getLanguage();
        if ("简体中文".equals(language) || "繁体中文".equals(language)) {
            path = path + "?locale=zh_CN";
        }
        String reqUrl = "/multiplesupplier/public/booking/prebook";
        String secret = "0c67e1@2e4?KD5da6a4#5a2H60sd3";
        String token = Encryption.generateSignature("POST", reqUrl, GetUtc.getUTCTimeStr(), secret);
        MyNetWork.getInstance(this).postAsynHttp(path, token, setJson(), new ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("订单校验数据加载失败", "onError: "+e.getMessage());
                Toast.makeText(WriteInforActivity.this,getResources().getString(R.string.net_error),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(String str) throws IOException {
                Log.i("订单校验的内容为", "onResponse: "+str);
                //ToolsUtils.getDate(str);
                try{
                    Gson gson = new Gson();
                    OrderCheck orderCheck = gson.fromJson(str, OrderCheck.class);
                    //设置订单信息
                    setCard(orderCheck);
                }catch (Exception e){
                    Log.i("订单校验json数据解析失败", "onResponse: "+e.getMessage());
                }
            }
        });
    }

    /**
     * 动态生成组件,包括成人 数量，性别，姓和名
     * 儿童的 数量，性别，姓和名
     * 房间的数量
     */
    private void setPassengerInfor() {
        //获取房间数两和每个房间的成人数量
        int roomNumber = mChoiceInfor.getRoomAmount();
        int preAdult = mChoiceInfor.getAdultSum()+mChoiceInfor.getChildrenPre();

        //加载布局文件
        View oneAdultLayout = View.inflate(this,R.layout.one_adult_infor,null);
        View oneRoomLayout = View.inflate(this,R.layout.one_room_layout,null);
        LinearLayout adultsLayout = oneRoomLayout.findViewById(R.id.adults_infor_layout);
        //根据成人的数量在布局中添加成人的信息
        for(int i = 0;i < roomNumber;i++){
            int child = 0;
            int adult = 0;
            for(int j = 0;j < preAdult;j++){
                //得到已有布局，将布局添加到父控件中
                adultsLayout.addView(oneAdultLayout,-1);
                View view = adultsLayout.getChildAt(j);
                TextView adultText = (TextView) view.findViewById(R.id.adult_number);
                if(j < mChoiceInfor.getAdultSum()){
                    adultText.setText(getResources().getString(R.string.adult)+String.valueOf(++adult));
                }else{
                    adultText.setText(getResources().getString(R.string.kids)+String.valueOf(++child));
                }
                Spinner spinner = (Spinner)view.findViewById(R.id.sex_choice);
                spinner.setOnItemSelectedListener(this);

                oneAdultLayout = View.inflate(this,R.layout.one_adult_infor,null);
                oneAdultLayout.setPadding(0,10,0,10);
            }
            //将生成的组件添加到最上层组件中
            mParentLayout.addView(oneRoomLayout,i);
            TextView roomNumberText = (TextView) oneRoomLayout.findViewById(R.id.room_number);
            roomNumberText.setText(getResources().getString(R.string.room_number)+String.valueOf(i+1));

            oneRoomLayout = View.inflate(this,R.layout.one_room_layout,null);
            adultsLayout = oneRoomLayout.findViewById(R.id.adults_infor_layout);
        }
    }

    /**
     * 校验订单，发送数据进行订单的校验
     * @return json字符串
     */
    private String setJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("hotel_id",mHotelId);
            jsonObject.put("check_in",mChoiceInfor.getInDate());
            jsonObject.put("check_out",mChoiceInfor.getOutDate());
            jsonObject.put("room_number",mChoiceInfor.getRoomAmount());
            jsonObject.put("adult_number",mChoiceInfor.getAdultSum());
            jsonObject.put("kids_number",mChoiceInfor.getChildrenPre());
            jsonObject.put("room_key",mRoomKey);
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.i("json设置数据失败", "setJson: "+"json设置数据失败");
        }
        return null;
    }

    /**
     * 获取用户设置的手机系统语言
     * @return 语言的类型
     */
    private String getLanguage() {
        SharedPreferences sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        return sharedPreferences.getString("language", null);
    }

    /**
     * 设置初始化订单上的各个卡片上的值
     * @param card 含有各种信息的对象
     */
    public void setCard(OrderCheck card) {
        roomName.setText(card.getRoom_list().get(0).getRoom_name().split("<br />")[0]);
        roomAddress.setText(mAddress);
        roomType.setText(getResources().getString(R.string.room_type)+card.getRoom_list().get(0).getRoom_type());
        roomDesc.setText(card.getRoom_list().get(0).getRoom_desc());
        inDate.setText(card.getRoom_list().get(0).getRates_and_cancellation_policies().get(0).getRates().get(0).getCheck_in());
        outDate.setText(card.getRoom_list().get(0).getRates_and_cancellation_policies().get(0).getRates().get(0).getCheck_out());
        sum.setText("$"+card.getRoom_list().get(0).getRates_and_cancellation_policies().get(0).getTotal_amount_after_tax());
        mShouldPay.setText("$"+card.getRoom_list().get(0).getRates_and_cancellation_policies().get(0).getTotal_amount_after_tax());
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel_button:
                finish();
            case R.id.sure_button:
                //封装各种信息，请求生成订单
                //getBooking();
                getPassengerInfor();
                Intent intent = new Intent(this,PayInforActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 将用户添加在订单中的各个值封装成json对象
     * @return json字符串
     */
    public String getBooking() {
        //封装个中信息到json中去
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("partner_reservation_id","");
            jsonObject.put("hotel_id","");
            jsonObject.put("room_key","");
            jsonObject.put("check_in","");
            jsonObject.put("check_out","");
            jsonObject.put("room_nunber","");
            jsonObject.put("adult_number","");
            jsonObject.put("kids_number","");
            //数组
            jsonObject.put("guests",getJSONArray());
            jsonObject.put("special_request","");
            //数组
            jsonObject.put("children_ages","");
            jsonObject.put("card_type","");
            jsonObject.put("card_number","");
            jsonObject.put("expire_date","");
            jsonObject.put("card_holder","");
            jsonObject.put("total_before_tax","");
            jsonObject.put("total_after_tax","");
            jsonObject.put("currency","");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray getJSONArray(){
        JSONArray jsonArray = new JSONArray();

        for(int i = 0;i < mChoiceInfor.getRoomAmount();i++){
            JSONObject jsonObject = new JSONObject();
            try {

                JSONArray beforeNameAdult = new JSONArray();
                jsonObject.put("adult_name_prefix",beforeNameAdult);

                JSONArray nameAdult = new JSONArray();
                jsonObject.put("adult_given_name",nameAdult);

                JSONArray xingAdult = new JSONArray();
                jsonObject.put("adult_surname",xingAdult);

                JSONArray beforeNameChild = new JSONArray();
                jsonObject.put("child_name_prefix",beforeNameChild);

                JSONArray nameChild = new JSONArray();
                jsonObject.put("adult_given_name",nameChild);

                JSONArray xingChild = new JSONArray();
                jsonObject.put("child_surname ",xingChild);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(jsonObject);
        }
        return null;
    }

    /**
     * 动态的获取动态生成的信息组件中的内容
     * 并且将其封装在相对应的对象中
     */
    private void getPassengerInfor(){
        //得到父控件
        for(int i = 0;i < mParentLayout.getChildCount();i++){
            //得到一个房型中的客人的信息
            LinearLayout oneRoomLayout = (LinearLayout)mParentLayout.getChildAt(i);
            LinearLayout oneRoomPassengers = (LinearLayout)oneRoomLayout.findViewById(R.id.adults_infor_layout);
            for(int j = 0;j < oneRoomPassengers.getChildCount();j++){
                //得到房间中第一个客人的信息
                View view = (LinearLayout)oneRoomPassengers.getChildAt(j);
                TextView type = (TextView) view.findViewById(R.id.adult_number);
                Spinner spinner = (Spinner) view.findViewById(R.id.sex_choice);
                EditText lastName = (EditText) view.findViewById(R.id.adult_ming);
                EditText firstName = (EditText) view.findViewById(R.id.adult_xing);

                Passenger passenger = new Passenger();
                Log.i("type", "getPassengerInfor: "+type.getText());
                Log.i("spinner", "getPassengerInfor: "+spinner.getSelectedItem());
                Log.i("lastName", "getPassengerInfor: "+lastName.getText());
                Log.i("firstName", "getPassengerInfor: "+firstName.getText());
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
