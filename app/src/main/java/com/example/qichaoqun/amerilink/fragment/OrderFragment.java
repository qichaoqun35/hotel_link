package com.example.qichaoqun.amerilink.fragment;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qichaoqun.amerilink.base.BasePager;

/**
 * @author qichaoqun
 * @date 2018/8/22
 */
@SuppressLint("ValidFragment")
public class OrderFragment extends Fragment {
    private BasePager mBasePager;

    public OrderFragment(BasePager basePager){
        mBasePager = basePager;
    }
    public OrderFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mBasePager != null) {
            return mBasePager.mView;
        }
        return null;
    }
}
