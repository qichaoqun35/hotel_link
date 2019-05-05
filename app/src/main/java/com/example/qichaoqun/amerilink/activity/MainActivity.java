package com.example.qichaoqun.amerilink.activity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.qichaoqun.amerilink.R;
import com.example.qichaoqun.amerilink.base.BasePager;
import com.example.qichaoqun.amerilink.fragment.MyFragment;
import com.example.qichaoqun.amerilink.fragment.OrderFragment;
import com.example.qichaoqun.amerilink.fragment.SearchFragment;
import com.example.qichaoqun.amerilink.pager.MyPager;
import com.example.qichaoqun.amerilink.pager.OrderPager;
import com.example.qichaoqun.amerilink.pager.SearchPager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.example.qichaoqun.amerilink.R.id.frame_layout;

/**
 * @author qichaoqun
 * @date 20180822
 */
public class MainActivity extends AppCompatActivity {

    public static final int PAGER_ZERO = 0;
    public static final int PAGER_TWO = 1;
    public static final int PAGER_THREE = 2;
    /**
     * 获取底部导航栏的监听事件
     * 根据用户选择的功能来显示不同的页面
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                //搜索页面
                case R.id.ameri_search:
                    setFragment(PAGER_ZERO);
                    return true;
                    //订单页面
                case R.id.ameri_order:
                    setFragment(PAGER_TWO);
                    return true;
                    //关于我的亚眠
                case R.id.ameri_my:
                    setFragment(PAGER_THREE);
                    return true;
                default:
            }
            return false;
        }
    };

    private List<BasePager> pagers = null;
    private SearchFragment mSearchFragment = null;
    private OrderFragment mOrderFragment = null;
    private MyFragment mMyFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置底部导航栏
        setBottomNavigation();

        //初始化相关页面及其视图相关
        pagers = new ArrayList<BasePager>();
        pagers.add(new SearchPager(this));
        pagers.add(new OrderPager(this));
        pagers.add(new MyPager(this));

        //预先加载的页面是第一个
        setFragment(PAGER_ZERO);
    }


    /**
     * 将底部导航栏的相关的动画去掉
     */
    @SuppressLint("RestrictedApi")
    private void setBottomNavigation() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);

            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
                itemView.setShiftingMode(false);
                itemView.setChecked(itemView.getItemData().isChecked());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(mListener);
    }

    /**
     * 创建Fragment
     *
     * @param flag 标识符，根据不同的内容区创建不同的Fragment
     *             使用此方法完美解决，导航栏闪退的问题，和视频中fragment的使用问题
     *             推荐使用下面的这种方法去动态的创建fragment
     */
    public void setFragment(int flag) {
        final int position = flag;
        //获取fragment的管理器
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏所有的fragment
        hiddenAllFragment(transaction);
        switch (flag) {
            case PAGER_ZERO:
                if (mSearchFragment == null) {
                    mSearchFragment = new SearchFragment(getBasePager(PAGER_ZERO));
                    transaction.add(R.id.frame_layout, mSearchFragment);
                } else {
                    transaction.show(mSearchFragment);
                }
                break;
            case PAGER_TWO:
                if (mOrderFragment == null) {
                    mOrderFragment = new OrderFragment(getBasePager(PAGER_TWO));
                    transaction.add(R.id.frame_layout, mOrderFragment);
                } else {
                    transaction.show(mOrderFragment);
                }
                break;
            case PAGER_THREE:
                if (mMyFragment == null) {
                    mMyFragment = new MyFragment(getBasePager(PAGER_THREE));
                    transaction.add(R.id.frame_layout, mMyFragment);
                } else {
                    transaction.show(mMyFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏已经存在的fragment
     * @param transaction fragment管理器对象
     */
    private void hiddenAllFragment(FragmentTransaction transaction) {
        if (mSearchFragment != null) {
            transaction.hide(mSearchFragment);
        }
        if (mOrderFragment != null) {
            transaction.hide(mOrderFragment);
        }
        if (mMyFragment != null) {
            transaction.hide(mMyFragment);
        }
    }

    /**
     * 根据位置获得相对应的页面的实例化对象
     * @param position 当前页面的位置
     * @return 实例化对象
     */
    private BasePager getBasePager(int position) {
        BasePager basePager = pagers.get(position);
        //加载数据，病根据标志符来判断是否再次加载数据
        //如果为false则不再加载数据，为true则会加载数据
        if (basePager != null && !basePager.inintFlag) {
            //获取实例化对象的数据，从此开始加载数据
            basePager.inintData();
            basePager.inintFlag = true;
        }
        return basePager;
    }


}
