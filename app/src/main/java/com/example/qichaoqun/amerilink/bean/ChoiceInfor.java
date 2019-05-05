package com.example.qichaoqun.amerilink.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/26
 * 用户选择的搜索条件
 */
public class ChoiceInfor implements Serializable{
    private String adultAmount;
    private int adultSum;

    /**
     * 房间中的成人数量，成人和少年的总和
     * @return
     */
    public int getAdultSum() {
        return adultPre+yongPre;
    }

    public void setAdultSum(int adultSum) {
        this.adultSum = adultSum;
    }

    public String getAdultAmount() {
        return String.valueOf(passengerAmount - (Integer.valueOf(childrenPre) * Integer.valueOf(roomAmount)));
    }

    public void setAdultAmount(String adultAmount) {
        this.adultAmount = adultAmount;
    }

    public String getKidsAmount() {
        return String.valueOf(Integer.valueOf(childrenPre) * Integer.valueOf(roomAmount));
    }

    public void setKidsAmount(String kidsAmount) {
        this.kidsAmount = kidsAmount;
    }

    private String kidsAmount;
    private String hotelId;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    private String city;
    private String cityLongitude;
    private String cityLatitude;
    private String inDate;

    public List<String> getList() {
        return mList;
    }

    public void setList(List<String> list) {
        mList = list;
    }

    private List<String> mList;

    public ChoiceInfor() {
    }

    public ChoiceInfor(String city, String cityLongitude, String cityLatitude, String inDate, String outDate, int passengerAmount, int roomAmount, int adultPre, int yongPre, int childrenPre, boolean isHaveEarly) {
        this.city = city;
        this.cityLongitude = cityLongitude;
        this.cityLatitude = cityLatitude;
        this.inDate = inDate;
        this.outDate = outDate;
        this.passengerAmount = passengerAmount;
        this.roomAmount = roomAmount;
        this.adultPre = adultPre;
        this.yongPre = yongPre;
        this.childrenPre = childrenPre;
        this.isHaveEarly = isHaveEarly;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityLongitude() {
        return cityLongitude;
    }

    public void setCityLongitude(String cityLongitude) {
        this.cityLongitude = cityLongitude;
    }

    public String getCityLatitude() {
        return cityLatitude;
    }

    public void setCityLatitude(String cityLatitude) {
        this.cityLatitude = cityLatitude;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public int getPassengerAmount() {
        return passengerAmount;
    }

    public void setPassengerAmount(int passengerAmount) {
        this.passengerAmount = passengerAmount;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
    }

    public int getAdultPre() {
        return adultPre;
    }

    public void setAdultPre(int adultPre) {
        this.adultPre = adultPre;
    }

    public int getYongPre() {
        return yongPre;
    }

    public void setYongPre(int yongPre) {
        this.yongPre = yongPre;
    }

    public int getChildrenPre() {
        return childrenPre;
    }

    public void setChildrenPre(int childrenPre) {
        this.childrenPre = childrenPre;
    }

    public boolean isHaveEarly() {
        return isHaveEarly;
    }

    public void setHaveEarly(boolean haveEarly) {
        isHaveEarly = haveEarly;
    }

    private String outDate;
    private int passengerAmount;
    private int roomAmount;
    private int adultPre;
    private int yongPre;
    private int childrenPre;
    private boolean isHaveEarly;

}
