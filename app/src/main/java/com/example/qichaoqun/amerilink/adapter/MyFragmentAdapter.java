package com.example.qichaoqun.amerilink.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList = null;
    private List<String> mListTitle = null;

    public MyFragmentAdapter(FragmentManager fm,List<Fragment> fragmentList,List<String> listTitle) {
        super(fm);
        mFragmentList = fragmentList;
        mListTitle = listTitle;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) mListTitle.get(position % mListTitle.size());
    }
}
