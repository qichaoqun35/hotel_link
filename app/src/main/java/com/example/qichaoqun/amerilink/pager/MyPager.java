package com.example.qichaoqun.amerilink.pager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.activity.DanWeiActivity;
import com.example.qichaoqun.amerilink.activity.LanguageActivity;
import com.example.qichaoqun.amerilink.activity.MainActivity;
import com.example.qichaoqun.amerilink.activity.MoneyActivity;
import com.example.qichaoqun.amerilink.adapter.CountAdapter;
import com.example.qichaoqun.amerilink.adapter.SettingAdapter;
import com.example.qichaoqun.amerilink.base.BasePager;
import com.example.qichaoqun.amerilink.bean.DanweiEvent;
import com.example.qichaoqun.amerilink.bean.MoneyEvent;
import com.example.qichaoqun.amerilink.utils.ActManger;
import com.example.qichaoqun.amerilink.utils.GetSettings;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/22
 */
public class MyPager extends BasePager implements AdapterView.OnItemClickListener {

    private ListView mCountListView;
    private ListView mSettingListView;
    public static final int MY_PAGER_ZERO = 0;
    public static final int MY_PAGER_FIRST = 1;
    public static final int MY_PAGER_SECOND = 2;
    public static final int MY_PAGER_THIRD = 3;
    private List<String> mList = null;
    private GetSettings mGetSettings;

    public MyPager(Context context) {
        super(context);
    }

    @Override
    public View inintView() {
        View view = View.inflate(mContext, R.layout.my_layout, null);
        mCountListView = view.findViewById(R.id.account_list_view);
        mSettingListView = view.findViewById(R.id.setting_list_view);

        //为list view设置事件监听器
        mCountListView.setOnItemClickListener(this);
        mSettingListView.setOnItemClickListener(this);

        //注册eventbus用于监听事件的回调
        EventBus.getDefault().register(this);
        return view;
    }

    /**
     * 用于接收事件订阅者，当受到通知后更改货币类型进行的操作
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMoney(MoneyEvent moneyEvent){
        Log.i("设置money的通知是：：", "onEventMainThread: "+moneyEvent.getMoney());
        inintData();
    }

    /**
     * 用于接收事件订阅者，当受到通知后更改单位的操作
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventDanwei(DanweiEvent danweiEvent){
        Log.i("设置单位的通知是：：", "onEventMainThread: "+danweiEvent.getDanwei());
        inintData();
    }


    @Override
    public void inintData() {
        super.inintData();
        //为listview设置适配器
        //我的账号的数据适配
        mCountListView.setAdapter(new CountAdapter(mContext));

        //我的设置的数据适配
        mList = new ArrayList<>();
        //从配置文件中加载配置文件内容，并且设置到前台页面
        mGetSettings = new GetSettings(mContext);
        mList.add(mGetSettings.getSetting("language"));
        mList.add(mGetSettings.getSetting("money"));
        mList.add(mGetSettings.getSetting("danwei"));
        mSettingListView.setAdapter(new SettingAdapter(mContext, mList));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.account_list_view:
                getAccountItem(position);
                break;
            case R.id.setting_list_view:
                getSettingItem(position);
                break;
            default:
                break;
        }
    }

    /**
     * 设置第一个listview中的监听事件的选项条目
     * @param position 条目的位置
     */
    private void getAccountItem(int position) {
        switch (position) {
            //搜索
            case MY_PAGER_ZERO:
                break;
            //登陆
            case MY_PAGER_SECOND:
                break;
            //开发面板
            case MY_PAGER_THIRD:
                break;
            default:
                break;
        }
    }

    /**
     * 设置第一个listview中的监听事件的选项条目
     * @param position 条目的位置
     */
    private void getSettingItem(int position) {
        switch (position) {
            //当前语言
            case MY_PAGER_ZERO:
                //选择设置语言，国际化,跳转到语言选择的页面
                Intent intent = new Intent(mContext, LanguageActivity.class);
                mContext.startActivity(intent);
                ActManger actManger = ActManger.getAppManger();
                actManger.addActivity((Activity) mContext);
                break;
            //当前货币
            case MY_PAGER_FIRST:
                Intent intent1 = new Intent(mContext, MoneyActivity.class);
                mContext.startActivity(intent1);
                break;
            //单位
            case MY_PAGER_SECOND:
                Intent intent2 = new Intent(mContext, DanWeiActivity.class);
                mContext.startActivity(intent2);
                break;
            default:
                break;
        }
    }

}
