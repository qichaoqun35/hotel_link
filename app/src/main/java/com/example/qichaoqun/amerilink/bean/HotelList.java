package com.example.qichaoqun.amerilink.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/26
 * 封装了酒店的信息,在酒店查询列表中显示
 */
public class HotelList implements Serializable {

    private ResultBean result;
    private KeyWordBean key_word;
    private Object search_id;
    private List<HotelListBean> hotel_list;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public KeyWordBean getKey_word() {
        return key_word;
    }

    public void setKey_word(KeyWordBean key_word) {
        this.key_word = key_word;
    }

    public Object getSearch_id() {
        return search_id;
    }

    public void setSearch_id(Object search_id) {
        this.search_id = search_id;
    }

    public List<HotelListBean> getHotel_list() {
        return hotel_list;
    }

    public void setHotel_list(List<HotelListBean> hotel_list) {
        this.hotel_list = hotel_list;
    }

    public static class ResultBean {
        /*
         * return_status : {"success":"true","exception":""}
         */

        private ReturnStatusBean return_status;

        public ReturnStatusBean getReturn_status() {
            return return_status;
        }

        public void setReturn_status(ReturnStatusBean return_status) {
            this.return_status = return_status;
        }

        public static class ReturnStatusBean {
            /*
             * success : true
             * exception :
             */

            private String success;
            private String exception;

            public String getSuccess() {
                return success;
            }

            public void setSuccess(String success) {
                this.success = success;
            }

            public String getException() {
                return exception;
            }

            public void setException(String exception) {
                this.exception = exception;
            }
        }
    }

    public static class KeyWordBean {
        /*
         * hotel_ids : null
         * latitude : 34.1400
         * longitude : -118.0152
         * radius : 20
         * check_in : 2018-08-27
         * check_out : 2018-08-28
         * room_number : 2
         * adult_number : 2
         * kids_number : 0
         * light : 0*/


        private Object hotel_ids;
        private String latitude;
        private String longitude;
        private String radius;
        private String check_in;
        private String check_out;
        private String room_number;
        private String adult_number;
        private String kids_number;
        private String light;

        public Object getHotel_ids() {
            return hotel_ids;
        }

        public void setHotel_ids(Object hotel_ids) {
            this.hotel_ids = hotel_ids;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getRadius() {
            return radius;
        }

        public void setRadius(String radius) {
            this.radius = radius;
        }

        public String getCheck_in() {
            return check_in;
        }

        public void setCheck_in(String check_in) {
            this.check_in = check_in;
        }

        public String getCheck_out() {
            return check_out;
        }

        public void setCheck_out(String check_out) {
            this.check_out = check_out;
        }

        public String getRoom_number() {
            return room_number;
        }

        public void setRoom_number(String room_number) {
            this.room_number = room_number;
        }

        public String getAdult_number() {
            return adult_number;
        }

        public void setAdult_number(String adult_number) {
            this.adult_number = adult_number;
        }

        public String getKids_number() {
            return kids_number;
        }

        public void setKids_number(String kids_number) {
            this.kids_number = kids_number;
        }

        public String getLight() {
            return light;
        }

        public void setLight(String light) {
            this.light = light;
        }
    }

    public static class HotelListBean {
        /*
         * hotel_id : 64246
         * hotel_name : Courtyard Los Angeles Pasadena/Monrovia
         * country_short : US
         * state_province : California
         * city : Monrovia
         * distance : 0.04754600087394
         * address :  700 West Huntington Drive Monrovia CA 91016
         * postal_code : 91016
         * star : 3
         * thumbnail : https://img.aichotels-content.com/public/hotels/1001/64246/supplier/1.jpg
         * latitude : 34.140195116667
         * longitude : -118.0147403
         * phone : null
         * picture_flag : 11
         * night_rate_after_tax : 215.60
         * night_rate_before_tax : 187.79
         * currency : USD
         * weight : 999.95245399913*/


        private int hotel_id;
        private String hotel_name;
        private String country_short;
        private String state_province;
        private String city;
        private double distance;
        private String address;
        private String postal_code;
        private float star;
        private String thumbnail;
        private String latitude;
        private String longitude;
        private Object phone;
        private int picture_flag;
        private float night_rate_after_tax;
        private float night_rate_before_tax;
        private String currency;
        private double weight;

        public int getHotel_id() {
            return hotel_id;
        }

        public void setHotel_id(int hotel_id) {
            this.hotel_id = hotel_id;
        }

        public String getHotel_name() {
            return hotel_name;
        }

        public void setHotel_name(String hotel_name) {
            this.hotel_name = hotel_name;
        }

        public String getCountry_short() {
            return country_short;
        }

        public void setCountry_short(String country_short) {
            this.country_short = country_short;
        }

        public String getState_province() {
            return state_province;
        }

        public void setState_province(String state_province) {
            this.state_province = state_province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }


        public float getStar() {
            return star;
        }

        public void setStar(float star) {
            this.star = star;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public int getPicture_flag() {
            return picture_flag;
        }

        public void setPicture_flag(int picture_flag) {
            this.picture_flag = picture_flag;
        }


        public float getNight_rate_after_tax() {
            return night_rate_after_tax;
        }

        public void setNight_rate_after_tax(float night_rate_after_tax) {
            this.night_rate_after_tax = night_rate_after_tax;
        }

        public float getNight_rate_before_tax() {
            return night_rate_before_tax;
        }

        public void setNight_rate_before_tax(float night_rate_before_tax) {
            this.night_rate_before_tax = night_rate_before_tax;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }
}
