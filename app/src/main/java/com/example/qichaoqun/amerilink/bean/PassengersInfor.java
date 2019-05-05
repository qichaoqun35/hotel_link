package com.example.qichaoqun.amerilink.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/9/9
 */
public class PassengersInfor implements Serializable{
    private int mAllRommAmount;
    private int mAdultAmount1;

    public List<String> getList() {
        return mList;
    }

    public void setList(List<String> list) {
        mList = list;
    }

    private List<String> mList;

    public PassengersInfor(int allRommAmount,int allPassengerAmount, int adultAmount1, int youngAmount1, int childrenAmount1, boolean isHaveEarly) {
        mAllRommAmount = allRommAmount;
        mAdultAmount1 = adultAmount1;
        mYoungAmount1 = youngAmount1;
        mChildrenAmount1 = childrenAmount1;
        mAllPassengerAmount = allPassengerAmount;
        mIsHaveEarly = isHaveEarly;
    }

    public int getAllRommAmount() {
        return mAllRommAmount;
    }

    public void setAllRommAmount(int allRommAmount) {
        mAllRommAmount = allRommAmount;
    }

    public int getAdultAmount1() {
        return mAdultAmount1;
    }

    public void setAdultAmount1(int adultAmount1) {
        mAdultAmount1 = adultAmount1;
    }

    public int getYoungAmount1() {
        return mYoungAmount1;
    }

    public void setYoungAmount1(int youngAmount1) {
        mYoungAmount1 = youngAmount1;
    }

    public int getChildrenAmount1() {
        return mChildrenAmount1;
    }

    public void setChildrenAmount1(int childrenAmount1) {
        mChildrenAmount1 = childrenAmount1;
    }

    public int getAllPassengerAmount() {
        return mAllPassengerAmount;
    }

    public void setAllPassengerAmount(int allPassengerAmount) {
        mAllPassengerAmount = allPassengerAmount;
    }

    public boolean getHaveEatly() {
        return mIsHaveEarly;
    }

    public void setHaveEarly(boolean haveEarly) {
        mIsHaveEarly = haveEarly;
    }

    private int mYoungAmount1;
    private int mChildrenAmount1;
    private int mAllPassengerAmount;
    private boolean mIsHaveEarly;
}
