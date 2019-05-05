package com.example.qichaoqun.amerilink.bean;

import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/28
 */
public class HotelInfor {


    /**
     * result : {"return_status":{"success":"true","exception":""}}
     * hotel_id : 113134
     * hotel_data : {"name":"蒙罗维亚希尔顿逸林酒店 - 帕萨迪纳地区","star":4,"pic":"https://s3-us-west-2.amazonaws.com/aic.img/data64/113134/0/M.jpg","intro":"<p><b>酒店设施<\/b><br/>酒店提供餐厅、咖啡厅、酒吧、报刊店、送餐服务和商务中心。公共区域设置有无线网络，方便客人在住宿期间与外界保持联系。旅游纪念品可在纪念品商店选购。驾车前来的客人，可将车辆停放于酒店的停车场。<\/p><p><b>客房设施<\/b><br/>酒店里提供备有空调和浴室的舒适房间。冰箱和微波炉也属于标准配置。互联网接口、电视机和无线网络为客人带来更多舒适方便。浴室配备有淋浴间和浴缸等设备。额外的便利设施包含吹风机等。<\/p><p><b>运动/休闲<\/b><br/>不仅有酒店，还有第三方供应商为住客提供一系列运动及休闲娱乐服务项目。酒店拥有室外游泳池。喜爱运动健身的旅客可利用酒店提供的健身中心（需付费）。  <\/p>","address":" 924 West Huntington Drive Monrovia California 91016","currency":"USD","country_short":"US","country_name":"美国","country_id":"233","city":"蒙罗维亚","city_id":"8644","state_name":"California","metro":"0","postcode":"91016","phone":"+16263571900","fax":"+16263591386","latitude":"34.139385894714","longitude":"-118.01877497035"}
     * rate_supplier_ids : [{"rate_supplier_id":1058},{"rate_supplier_id":1011},{"rate_supplier_id":1500}]
     * otherimages : ["https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_A.jpg ","https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_B.jpg ","https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_C.jpg ","https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_D.jpg ","https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_F.jpg ","https://img.aichotels-content.com/public/hotels/1058/113134/supplier/LAXMVDT_DoubleTree_by_Hilton_Hotel_Monrovia_Pasadena_Area_H.jpg "]
     * sort_weights : 23
     */

    private ResultBean result;
    private int hotel_id;
    private HotelDataBean hotel_data;
    private int sort_weights;
    private List<RateSupplierIdsBean> rate_supplier_ids;
    private List<String> otherimages;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public HotelDataBean getHotel_data() {
        return hotel_data;
    }

    public void setHotel_data(HotelDataBean hotel_data) {
        this.hotel_data = hotel_data;
    }

    public int getSort_weights() {
        return sort_weights;
    }

    public void setSort_weights(int sort_weights) {
        this.sort_weights = sort_weights;
    }

    public List<RateSupplierIdsBean> getRate_supplier_ids() {
        return rate_supplier_ids;
    }

    public void setRate_supplier_ids(List<RateSupplierIdsBean> rate_supplier_ids) {
        this.rate_supplier_ids = rate_supplier_ids;
    }

    public List<String> getOtherimages() {
        return otherimages;
    }

    public void setOtherimages(List<String> otherimages) {
        this.otherimages = otherimages;
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

    public static class HotelDataBean {
        /**
         * name : 蒙罗维亚希尔顿逸林酒店 - 帕萨迪纳地区
         * star : 4
         * pic : https://s3-us-west-2.amazonaws.com/aic.img/data64/113134/0/M.jpg
         * intro : <p><b>酒店设施</b><br/>酒店提供餐厅、咖啡厅、酒吧、报刊店、送餐服务和商务中心。公共区域设置有无线网络，方便客人在住宿期间与外界保持联系。旅游纪念品可在纪念品商店选购。驾车前来的客人，可将车辆停放于酒店的停车场。</p><p><b>客房设施</b><br/>酒店里提供备有空调和浴室的舒适房间。冰箱和微波炉也属于标准配置。互联网接口、电视机和无线网络为客人带来更多舒适方便。浴室配备有淋浴间和浴缸等设备。额外的便利设施包含吹风机等。</p><p><b>运动/休闲</b><br/>不仅有酒店，还有第三方供应商为住客提供一系列运动及休闲娱乐服务项目。酒店拥有室外游泳池。喜爱运动健身的旅客可利用酒店提供的健身中心（需付费）。  </p>
         * address :  924 West Huntington Drive Monrovia California 91016
         * currency : USD
         * country_short : US
         * country_name : 美国
         * country_id : 233
         * city : 蒙罗维亚
         * city_id : 8644
         * state_name : California
         * metro : 0
         * postcode : 91016
         * phone : +16263571900
         * fax : +16263591386
         * latitude : 34.139385894714
         * longitude : -118.01877497035
         */

        private String name;
        private int star;
        private String pic;
        private String intro;
        private String address;
        private String currency;
        private String country_short;
        private String country_name;
        private String country_id;
        private String city;
        private String city_id;
        private String state_name;
        private String metro;
        private String postcode;
        private String phone;
        private String fax;
        private String latitude;
        private String longitude;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
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

        public String getCountry_id() {
            return country_id;
        }

        public void setCountry_id(String country_id) {
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
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
    }

    public static class RateSupplierIdsBean {
        /**
         * rate_supplier_id : 1058
         */

        private int rate_supplier_id;

        public int getRate_supplier_id() {
            return rate_supplier_id;
        }

        public void setRate_supplier_id(int rate_supplier_id) {
            this.rate_supplier_id = rate_supplier_id;
        }
    }
}
