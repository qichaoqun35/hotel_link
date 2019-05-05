package com.example.qichaoqun.amerilink.bean;

import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/30
 */
public class MapHotel {


    private ResultBean result;
    private List<HotelsBean> hotels;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<HotelsBean> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelsBean> hotels) {
        this.hotels = hotels;
    }

    public static class ResultBean {
        /**
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
            /**
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

    public static class HotelsBean {
        /**
         * hotel_id : 64246
         * name : 洛杉矶帕萨迪纳/蒙罗维亚万怡酒店
         * star : 3
         * pic : https://img.aichotels-content.com/public/hotels/1001/64246/supplier/1.jpg
         * intro : <p><b>酒店设施</b><br/>酒店共有152间房间。酒店设施包括餐厅、用餐区、酒吧、送餐服务、会议室和商务中心。设置有无线网络提供客人便利上网。驾车前来的客人，可将车辆停放于酒店的停车场。</p><p><b>客房设施</b><br/>房间里备有空调和浴室。此外亦提供书桌等设备。冰箱、微波炉和煮茶/咖啡机让房客在住宿期间倍感舒适方便。熨衣设备为旅客在路途中提供便利和舒适。互联网接口、电话、电视机和无线网络使房间设备更加完善。浴室里内包含了吹风机。酒店提供家庭房和禁烟房。</p><p><b>运动/休闲</b><br/>炎热的日子里，酒店拥有许多解暑的好去处，比如游泳池和室外游泳池。游泳区的气泡按摩池为身体带来舒缓放松。各种康乐项目提供多样化的休闲娱乐，其中包含健身中心和SPA。  </p><p><b>餐饮</b><br/>客人可在早餐和晚餐之间选择。</p>
         * address :  700 West Huntington Drive Monrovia CA 91016
         * currency : USD
         * country_short : US
         * country_name : US
         * country_id : 233
         * city : Monrovia
         * city_id : 8644
         * state_name : California
         * metro : 0
         * postcode : 91016
         * phone : null
         * fax : null
         * latitude : 34.140195116667
         * longitude : -118.0147403
         * distance : 0.04754600087394
         * name_en : Courtyard Los Angeles Pasadena/Monrovia
         * intro_en : <p><b>Facilities</b><br/>The hotel comprises a total of 152 rooms. Services and facilities at the hotel include a restaurant, a dining area, a bar, room service, a conference room and a business centre. Wireless internet access is available to guests. Those arriving in their own vehicles can leave them in the car park of the accommodation.</p><p><b>Rooms</b><br/>Each of the rooms is appointed with air conditioning and a bathroom. There is also a desk. A fridge, a microwave and a tea/coffee station ensure a comfortable stay. An ironing set is also available for travellers' convenience. Other features include internet access, a telephone, a TV and WiFi. A hairdryer is provided in the bathrooms. The establishment offers family rooms and non-smoking rooms.</p><p><b>Sports/Entertainment</b><br/>The hotel features various options for cooling off on hot days, including a pool and an outdoor pool. The hot tub is the perfect place to relax. A range of options are available, including a gym and a spa.  </p><p><b>Meals</b><br/>Guests can choose options including breakfast and dinner.</p>
         * address_en :  700 West Huntington Drive Monrovia CA 91016
         * picture_flag : 11
         * sort_weight : 25
         * speed_weight : 750
         */

        private int hotel_id;
        private String name;
        private float star;
        private String pic;
        private String intro;
        private String address;
        private String currency;
        private String country_short;
        private String country_name;
        private int country_id;
        private String city;
        private String city_id;
        private String state_name;
        private String metro;
        private String postcode;
        private Object phone;
        private Object fax;
        private String latitude;
        private String longitude;
        private double distance;
        private String name_en;
        private String intro_en;
        private String address_en;
        private int picture_flag;
        private int sort_weight;
        private String speed_weight;

        public int getHotel_id() {
            return hotel_id;
        }

        public void setHotel_id(int hotel_id) {
            this.hotel_id = hotel_id;
        }

        public float getStar() {
            return star;
        }

        public void setStar(float star) {
            this.star = star;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCountry_short() {
            return country_short;
        }

        public void setCountry_short(String country_short) {
            this.country_short = country_short;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public int getCountry_id() {
            return country_id;
        }

        public void setCountry_id(int country_id) {
            this.country_id = country_id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getState_name() {
            return state_name;
        }

        public void setState_name(String state_name) {
            this.state_name = state_name;
        }

        public String getMetro() {
            return metro;
        }

        public void setMetro(String metro) {
            this.metro = metro;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getFax() {
            return fax;
        }

        public void setFax(Object fax) {
            this.fax = fax;
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

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getIntro_en() {
            return intro_en;
        }

        public void setIntro_en(String intro_en) {
            this.intro_en = intro_en;
        }

        public String getAddress_en() {
            return address_en;
        }

        public void setAddress_en(String address_en) {
            this.address_en = address_en;
        }

        public int getPicture_flag() {
            return picture_flag;
        }

        public void setPicture_flag(int picture_flag) {
            this.picture_flag = picture_flag;
        }

        public int getSort_weight() {
            return sort_weight;
        }

        public void setSort_weight(int sort_weight) {
            this.sort_weight = sort_weight;
        }

        public String getSpeed_weight() {
            return speed_weight;
        }

        public void setSpeed_weight(String speed_weight) {
            this.speed_weight = speed_weight;
        }
    }
}
