package com.example.qichaoqun.amerilink.base;

import android.content.Context;
import android.view.View;

import java.io.Serializable;

/**
 * @author qichaoqun
 * @date 2018/8/22
 */
public abstract class BasePager{

    /**
     * 接收传递过来的上下文
     */
    public Context mContext;
    /**
     * 保存传递过来的视图
     */
    public View mView;
    public boolean inintFlag = false;

    public BasePager(Context context){
        mContext = context;
        mView = inintView();
    }

    /**
     * 初始化和加载视图
     * @return 视图页面
     */
    public abstract View inintView();

    /**
     * 初始化加载数据，最后设置在视图上
     */
    public void inintData(){

    }
}
