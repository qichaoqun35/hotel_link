package com.example.qichaoqun.amerilink.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.adapter.MyFragmentAdapter;
import com.example.qichaoqun.amerilink.base.BasePager;
import com.example.qichaoqun.amerilink.bean.ChoiceInfor;
import com.example.qichaoqun.amerilink.bean.MoneyEvent;
import com.example.qichaoqun.amerilink.fragment.ListModeFragment;
import com.example.qichaoqun.amerilink.fragment.MapModeFragment;
import com.example.qichaoqun.amerilink.pager.ViewPagerCompat;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/26
 */
public class HotelListActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPagerCompat mViewPager;
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;
    private ListModeFragment mListModeFragment;
    private MapModeFragment mMapModeFragment;
    private MyFragmentAdapter mMyFragmentAdapter;
    private ChoiceInfor mChoiceInfor;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_list_layout);
        setToolBar();

        //获取传递过来的数据
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mChoiceInfor = (ChoiceInfor) bundle.getSerializable("choice");

        //设置顶部滑动框
        setTablelayout();
    }

    @SuppressLint("ResourceAsColor")
    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.hotel_list_bar);
        mToolbar.setTitle(getResources().getString(R.string.hotel_list));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.usd:
                        saveMoneyType("USD");
                        break;
                    case R.id.cad:
                        break;
                    case R.id.eur:
                        break;
                    case R.id.jpy:
                        break;
                    case R.id.cny:
                        saveMoneyType("CNY");
                        break;
                    case R.id.brl:
                        break;
                    case R.id.inr:
                        break;
                    default:
                        break;
                }
                //sendMyBorderCast();
                EventBus.getDefault().post(new MoneyEvent(""));
                return true;
            }
        });
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void saveMoneyType(String money) {
        SharedPreferences sharedPreferences = getSharedPreferences("settings",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("money",money);
        editor.commit();
        Toast.makeText(this,getResources().getString(R.string.setting_success),Toast.LENGTH_SHORT).show();
    }

    /**
     * 发送广播
     */
    private void sendMyBorderCast() {
        Intent intent = new Intent();
        intent.setAction("com.amerilink.money.change");
        sendBroadcast(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool, menu);
        return true;
    }

    /**
     * 设置顶部滑动栏
     */
    private void setTablelayout() {
        mTabLayout = (TabLayout) findViewById(R.id.table_layout);
        mViewPager = (ViewPagerCompat) findViewById(R.id.view_pager);

        //实现fragment、viewpager、tablelayout的三者相结合
        mFragmentList = new ArrayList<>();
        mTitleList = new ArrayList<>();

        mListModeFragment = new ListModeFragment(this, mChoiceInfor);
        mMapModeFragment = new MapModeFragment(this, mChoiceInfor);

        mFragmentList.add(mListModeFragment);
        mFragmentList.add(mMapModeFragment);

        mTitleList.add(getResources().getString(R.string.list_mode));
        mTitleList.add(getResources().getString(R.string.map_mode));

        mMyFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragmentList, mTitleList);
        mViewPager.setAdapter(mMyFragmentAdapter);
        //实现viewpager和tablelayout的相结合
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
