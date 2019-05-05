package com.example.qichaoqun.amerilink.pager;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.base.BasePager;

/**
 * @author qichaoqun
 * @date 2018/8/22
 */
public class OrderPager extends BasePager implements SwipeRefreshLayout.OnRefreshListener {

    private static final int REFRESH_COMPLETE = 0x01;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public OrderPager(Context context) {
        super(context);
    }

    @Override
    public View inintView() {
        View view = View.inflate(mContext, R.layout.order_layout,null);
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.my_pull_refresh);
        mSwipeRefreshLayout.setColorSchemeColors(mContext.getResources().getColor(android.R.color.holo_blue_light));
        mSwipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        return view;
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    mSwipeRefreshLayout.setRefreshing(false);
                    break;
            }
        }
    };


    @Override
    public void inintData() {
        super.inintData();
    }

    @Override
    public void onRefresh() {
        Toast.makeText(mContext,"下拉刷新啦。。。。",Toast.LENGTH_SHORT).show();
        //数据刷新完成以后将刷新动画停止
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }
}
