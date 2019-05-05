package com.example.qichaoqun.amerilink.bean;

import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/9/1
 */
public class RealCity {

    /**
     * result : {"return_status":{"success":"true","exception":""}}
     * city_list : [{"city_id":"1584","name":"Irkutsk","areaname":null,"center_latitude":"52.280106","center_longitude":"104.282562"},{"city_id":"1798","name":"Kaliningrad","areaname":null,"center_latitude":"54.711521","center_longitude":"20.509174"},{"city_id":"1913","name":"Krasnodar","areaname":null,"center_latitude":"45.034637","center_longitude":"38.973194"},{"city_id":"1948","name":"Samara","areaname":null,"center_latitude":"53.186844","center_longitude":"50.093685"},{"city_id":"1965","name":"Kirov","areaname":null,"center_latitude":"58.594994","center_longitude":"49.666866"},{"city_id":"2042","name":"St. Petersburg","areaname":null,"center_latitude":"59.939049","center_longitude":"30.315800"},{"city_id":"2395","name":"Moscow","areaname":"","center_latitude":"55.741329","center_longitude":"37.597927"},{"city_id":"2721","name":"Novosibirsk","areaname":null,"center_latitude":"55.030087","center_longitude":"82.920509"},{"city_id":"2761","name":"Perm","areaname":null,"center_latitude":"58.008484","center_longitude":"56.241497"},{"city_id":"2974","name":"Orenburg","areaname":null,"center_latitude":"51.764477","center_longitude":"55.127785"},{"city_id":"3450","name":"Tyumen","areaname":null,"center_latitude":"57.152306","center_longitude":"65.532753"},{"city_id":"3615","name":"Ufa","areaname":null,"center_latitude":"54.735104","center_longitude":"55.958683"},{"city_id":"3635","name":"Ulyanovsk","areaname":null,"center_latitude":"54.293610","center_longitude":"48.395744"},{"city_id":"3727","name":"Volgograd","areaname":null,"center_latitude":"48.709805","center_longitude":"44.520058"},{"city_id":"3730","name":"Voronezh","areaname":null,"center_latitude":"51.664410","center_longitude":"39.204536"},{"city_id":"5118","name":"Livingston","areaname":"Scotland","center_latitude":"55.885269","center_longitude":"-3.508579"},{"city_id":"5601","name":"Paisley","areaname":"Scotland","center_latitude":"55.843018","center_longitude":"-4.439353"},{"city_id":"601499","name":"Krasnoyarsk","areaname":null,"center_latitude":"56.013546","center_longitude":"92.871117"},{"city_id":"6137274","name":"Ivanovo","areaname":null,"center_latitude":"57.016502","center_longitude":"40.996277"},{"city_id":"6297525","name":"Vnukovo","areaname":null,"center_latitude":"55.602188","center_longitude":"37.276855"},{"city_id":"6301403","name":"Yekaterinburg","areaname":null,"center_latitude":"56.825321","center_longitude":"60.645554"},{"city_id":"6304368","name":"Nizhny Novgorod","areaname":null,"center_latitude":"56.326530","center_longitude":"44.005306"},{"city_id":"6314580","name":"Kazan","areaname":null,"center_latitude":"55.794205","center_longitude":"49.116402"},{"city_id":"804","name":"Chelyabinsk","areaname":null,"center_latitude":"55.167706","center_longitude":"61.395107"},{"city_id":"8304","name":"Kaluga","areaname":null,"center_latitude":"54.530159","center_longitude":"36.269836"},{"city_id":"aic00034","name":"Sevastopol","areaname":"Crimea","center_latitude":"45.414283","center_longitude":"34.540688"}]
     */

    private ResultBean result;
    private List<CityListBean> city_list;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<CityListBean> getCity_list() {
        return city_list;
    }

    public void setCity_list(List<CityListBean> city_list) {
        this.city_list = city_list;
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

    public static class CityListBean {
        /**
         * city_id : 1584
         * name : Irkutsk
         * areaname : null
         * center_latitude : 52.280106
         * center_longitude : 104.282562
         */

        private String city_id;
        private String name;
        private Object areaname;
        private String center_latitude;
        private String center_longitude;

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getAreaname() {
            return areaname;
        }

        public void setAreaname(Object areaname) {
            this.areaname = areaname;
        }

        public String getCenter_latitude() {
            return center_latitude;
        }

        public void setCenter_latitude(String center_latitude) {
            this.center_latitude = center_latitude;
        }

        public String getCenter_longitude() {
            return center_longitude;
        }

        public void setCenter_longitude(String center_longitude) {
            this.center_longitude = center_longitude;
        }
    }
}
