package com.example.qichaoqun.amerilink.bean;

import java.io.Serializable;

/**
 * @author qichaoqun
 * @date 2018/8/30
 */
public class MapInfor implements Serializable {
    public MapInfor(String hotel_id, double latitude, double longitude, String imageUrl, String hotelName) {
        this.hotel_id = hotel_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.hotelName = hotelName;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    private String hotel_id;
    private double latitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    private double longitude;
    private String imageUrl;
    private String hotelName;
}
