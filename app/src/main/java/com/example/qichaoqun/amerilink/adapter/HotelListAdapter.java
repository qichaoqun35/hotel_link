package com.example.qichaoqun.amerilink.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.CursorJoiner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.qichaoqun.amerilink.NetWork.Encryption;
import com.example.qichaoqun.amerilink.NetWork.GetUtc;
import com.example.qichaoqun.amerilink.NetWork.MyNetWork;
import com.example.qichaoqun.amerilink.NetWork.ResultCallback;
import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.bean.ChoiceInfor;
import com.example.qichaoqun.amerilink.bean.HotelList;
import com.example.qichaoqun.amerilink.bean.HotelMoney;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

/**
 * @author qichaoqun
 * @date 2018/8/26
 */
public class HotelListAdapter extends BaseAdapter {
    public static final char ONE_STAR = '1';
    public static final char TWO_STAR = '2';
    public static final char THREE_STAR = '3';
    public static final char FOUR_STAR = '4';
    public static final char ALL_STAR = '5';
    private Context mContext;
    private List<HotelList.HotelListBean> mList = null;
    private final LayoutInflater mInflater;
    private ImageView mStarOne;
    private ImageView mStarTwo;
    private ImageView mStarThree;
    private ImageView mStarFour;
    private ImageView mStarFive;

    public HotelListAdapter(Context context, List<HotelList.HotelListBean> list) {
        mContext = context;
        mList = list;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.hotel_list_item, null);

        ImageView hotelImage = (ImageView) convertView.findViewById(R.id.hotel_image);
        TextView hotelName = (TextView) convertView.findViewById(R.id.hotel_name);
        mStarOne = (ImageView) convertView.findViewById(R.id.star_one);
        mStarTwo = (ImageView) convertView.findViewById(R.id.star_two);
        mStarThree = (ImageView) convertView.findViewById(R.id.star_three);
        mStarFour = (ImageView) convertView.findViewById(R.id.star_four);
        mStarFive = (ImageView) convertView.findViewById(R.id.star_five);
        TextView starsText = (TextView) convertView.findViewById(R.id.stars_text);
        TextView addressText = (TextView) convertView.findViewById(R.id.address_text);
        TextView distanceText = (TextView) convertView.findViewById(R.id.distance_text);
        TextView moneyText = (TextView) convertView.findViewById(R.id.money_text);

        Glide.with(mContext)
                .load(mList.get(position).getThumbnail())
                .placeholder(R.drawable.load_image)
                .skipMemoryCache(false)
                .thumbnail(0.1f)
                .into(hotelImage);
        hotelName.setText(mList.get(position).getHotel_name());
        float statNo = mList.get(position).getStar();
        String starSo = String.valueOf(statNo);
        starsText.setText(starSo.substring(0, 1));
        Log.i("酒店的第一个星级是：：：", "getView: " + String.valueOf(mList.get(position).getStar()).substring(0, 1));

        setStarts(starSo.charAt(0));

        if (mList.get(position).getAddress() == null) {
            addressText.setText(mContext.getResources().getString(R.string.no_result));
        } else {
            addressText.setText(mList.get(position).getAddress());
        }
        distanceText.setText(String.valueOf(mList.get(position).getDistance()).substring(0, 4) + " km");
        //设置酒店的价格
        if (-1 == (int) mList.get(position).getNight_rate_before_tax()) {
            moneyText.setText(mContext.getResources().getString(R.string.no_result));
        } else {
            //获取用户选择的货币类型，根据货币类型设置相应的价格
            moneyText.setText(getHotelMoney(mList.get(position).getNight_rate_before_tax()).substring(0, 4));
        }

        return convertView;
    }

    private void setStarts(char star) {
        Log.i("星级为：：：", "setStarts: " + star);
        switch (star) {
            case ONE_STAR:
                mStarOne.setVisibility(View.VISIBLE);
                break;
            case TWO_STAR:
                mStarOne.setVisibility(View.VISIBLE);
                mStarTwo.setVisibility(View.VISIBLE);
                break;
            case THREE_STAR:
                mStarOne.setVisibility(View.VISIBLE);
                mStarTwo.setVisibility(View.VISIBLE);
                mStarThree.setVisibility(View.VISIBLE);
                break;
            case FOUR_STAR:
                mStarOne.setVisibility(View.VISIBLE);
                mStarTwo.setVisibility(View.VISIBLE);
                mStarThree.setVisibility(View.VISIBLE);
                mStarFour.setVisibility(View.VISIBLE);
                break;
            case ALL_STAR:
                mStarOne.setVisibility(View.VISIBLE);
                mStarTwo.setVisibility(View.VISIBLE);
                mStarThree.setVisibility(View.VISIBLE);
                mStarFour.setVisibility(View.VISIBLE);
                mStarFive.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }


    public String getHotelMoney(double moneyAmount) {
        //获取用户设置的货币类型
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("settings", Context.MODE_PRIVATE);
        String money = sharedPreferences.getString("money", null);
        switch (money) {
            case "USD":
                return "$" + String.valueOf(moneyAmount);
            case "CAD":
                break;
            case "EUR":
                return String.valueOf(moneyAmount);
            case "JPY":
                return String.valueOf(moneyAmount);
            case "CNY":
                return "￥" + String.valueOf(moneyAmount * 6.8234);
            case "BRL":
                return String.valueOf(moneyAmount);
            case "INR":
                return String.valueOf(moneyAmount);
                default:
        }
        return null;
    }
}
