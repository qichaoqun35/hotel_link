package com.example.qichaoqun.amerilink.bean;

import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/9/1
 */
public class MyLocation {

    /**
     * status : 0
     * result : {"location":{"lng":113.50206899999993,"lat":34.81276496525756},"formatted_address":"河南省郑州市中原区科学大道","business":"","addressComponent":{"country":"中国","country_code":0,"country_code_iso":"CHN","country_code_iso2":"CN","province":"河南省","city":"郑州市","city_level":2,"district":"中原区","town":"","adcode":"410102","street":"科学大道","street_number":"","direction":"","distance":""},"pois":[{"addr":"创新大道与科学大道交汇处东北角","cp":" ","direction":"东南","distance":"435","name":"万科城4期秋棠苑","poiType":"房地产","point":{"x":113.50021845370703,"y":34.815603599902204},"tag":"房地产;住宅区","tel":"","uid":"eb13fb0716d397470c0e6b3a","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"高新区科学大道与白松路（创新大道）交汇处西南角","cp":" ","direction":"东","distance":"545","name":"美立方","poiType":"房地产","point":{"x":113.4971911641384,"y":34.81315862356015},"tag":"房地产;写字楼","tel":"","uid":"15011eefc510a209ca09f0d3","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"郑州市科学大道与创新大道交叉口","cp":" ","direction":"东","distance":"644","name":"美景M3立方体","poiType":"公司企业","point":{"x":113.49628387557333,"y":34.81266221033095},"tag":"公司企业;园区","tel":"","uid":"fc27a7733ce428fc4afc8d31","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"河南省郑州市高新技术开发区科学大道","cp":" ","direction":"东南","distance":"763","name":"九洲汇智广场","poiType":"房地产","point":{"x":113.49631082473863,"y":34.81584068462303},"tag":"房地产;住宅区","tel":"","uid":"5cf282b270897d2aadb22abc","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"白松路附近","cp":" ","direction":"东北","distance":"789","name":"郑州金源热镀锌有限公司","poiType":"公司企业","point":{"x":113.49849370712788,"y":34.80771273130131},"tag":"公司企业;公司","tel":"","uid":"9217f4c4da74a7f49900507f","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"红松路附近","cp":" ","direction":"西南","distance":"938","name":"郑州轻工学院教师公寓","poiType":"房地产","point":{"x":113.5096955768373,"y":34.815722142348676},"tag":"房地产;住宅区","tel":"","uid":"741079cc137082aa95f08cb0","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}}],"roads":[],"poiRegions":[],"sematic_description":"万科城4期秋棠苑东南435米","cityCode":268}
     */

    private int status;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * location : {"lng":113.50206899999993,"lat":34.81276496525756}
         * formatted_address : 河南省郑州市中原区科学大道
         * business :
         * addressComponent : {"country":"中国","country_code":0,"country_code_iso":"CHN","country_code_iso2":"CN","province":"河南省","city":"郑州市","city_level":2,"district":"中原区","town":"","adcode":"410102","street":"科学大道","street_number":"","direction":"","distance":""}
         * pois : [{"addr":"创新大道与科学大道交汇处东北角","cp":" ","direction":"东南","distance":"435","name":"万科城4期秋棠苑","poiType":"房地产","point":{"x":113.50021845370703,"y":34.815603599902204},"tag":"房地产;住宅区","tel":"","uid":"eb13fb0716d397470c0e6b3a","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"高新区科学大道与白松路（创新大道）交汇处西南角","cp":" ","direction":"东","distance":"545","name":"美立方","poiType":"房地产","point":{"x":113.4971911641384,"y":34.81315862356015},"tag":"房地产;写字楼","tel":"","uid":"15011eefc510a209ca09f0d3","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"郑州市科学大道与创新大道交叉口","cp":" ","direction":"东","distance":"644","name":"美景M3立方体","poiType":"公司企业","point":{"x":113.49628387557333,"y":34.81266221033095},"tag":"公司企业;园区","tel":"","uid":"fc27a7733ce428fc4afc8d31","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"河南省郑州市高新技术开发区科学大道","cp":" ","direction":"东南","distance":"763","name":"九洲汇智广场","poiType":"房地产","point":{"x":113.49631082473863,"y":34.81584068462303},"tag":"房地产;住宅区","tel":"","uid":"5cf282b270897d2aadb22abc","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"白松路附近","cp":" ","direction":"东北","distance":"789","name":"郑州金源热镀锌有限公司","poiType":"公司企业","point":{"x":113.49849370712788,"y":34.80771273130131},"tag":"公司企业;公司","tel":"","uid":"9217f4c4da74a7f49900507f","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}},{"addr":"红松路附近","cp":" ","direction":"西南","distance":"938","name":"郑州轻工学院教师公寓","poiType":"房地产","point":{"x":113.5096955768373,"y":34.815722142348676},"tag":"房地产;住宅区","tel":"","uid":"741079cc137082aa95f08cb0","zip":"","parent_poi":{"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}}]
         * roads : []
         * poiRegions : []
         * sematic_description : 万科城4期秋棠苑东南435米
         * cityCode : 268
         */

        private LocationBean location;
        private String formatted_address;
        private String business;
        private AddressComponentBean addressComponent;
        private String sematic_description;
        private int cityCode;
        private List<PoisBean> pois;
        private List<?> roads;
        private List<?> poiRegions;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public AddressComponentBean getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponentBean addressComponent) {
            this.addressComponent = addressComponent;
        }

        public String getSematic_description() {
            return sematic_description;
        }

        public void setSematic_description(String sematic_description) {
            this.sematic_description = sematic_description;
        }

        public int getCityCode() {
            return cityCode;
        }

        public void setCityCode(int cityCode) {
            this.cityCode = cityCode;
        }

        public List<PoisBean> getPois() {
            return pois;
        }

        public void setPois(List<PoisBean> pois) {
            this.pois = pois;
        }

        public List<?> getRoads() {
            return roads;
        }

        public void setRoads(List<?> roads) {
            this.roads = roads;
        }

        public List<?> getPoiRegions() {
            return poiRegions;
        }

        public void setPoiRegions(List<?> poiRegions) {
            this.poiRegions = poiRegions;
        }

        public static class LocationBean {
            /**
             * lng : 113.50206899999993
             * lat : 34.81276496525756
             */

            private double lng;
            private double lat;

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class AddressComponentBean {
            /**
             * country : 中国
             * country_code : 0
             * country_code_iso : CHN
             * country_code_iso2 : CN
             * province : 河南省
             * city : 郑州市
             * city_level : 2
             * district : 中原区
             * town :
             * adcode : 410102
             * street : 科学大道
             * street_number :
             * direction :
             * distance :
             */

            private String country;
            private int country_code;
            private String country_code_iso;
            private String country_code_iso2;
            private String province;
            private String city;
            private int city_level;
            private String district;
            private String town;
            private String adcode;
            private String street;
            private String street_number;
            private String direction;
            private String distance;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public int getCountry_code() {
                return country_code;
            }

            public void setCountry_code(int country_code) {
                this.country_code = country_code;
            }

            public String getCountry_code_iso() {
                return country_code_iso;
            }

            public void setCountry_code_iso(String country_code_iso) {
                this.country_code_iso = country_code_iso;
            }

            public String getCountry_code_iso2() {
                return country_code_iso2;
            }

            public void setCountry_code_iso2(String country_code_iso2) {
                this.country_code_iso2 = country_code_iso2;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public int getCity_level() {
                return city_level;
            }

            public void setCity_level(int city_level) {
                this.city_level = city_level;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getTown() {
                return town;
            }

            public void setTown(String town) {
                this.town = town;
            }

            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }
        }

        public static class PoisBean {
            /**
             * addr : 创新大道与科学大道交汇处东北角
             * cp :
             * direction : 东南
             * distance : 435
             * name : 万科城4期秋棠苑
             * poiType : 房地产
             * point : {"x":113.50021845370703,"y":34.815603599902204}
             * tag : 房地产;住宅区
             * tel :
             * uid : eb13fb0716d397470c0e6b3a
             * zip :
             * parent_poi : {"name":"","tag":"","addr":"","point":{"x":0,"y":0},"direction":"","distance":"","uid":""}
             */

            private String addr;
            private String cp;
            private String direction;
            private String distance;
            private String name;
            private String poiType;
            private PointBean point;
            private String tag;
            private String tel;
            private String uid;
            private String zip;
            private ParentPoiBean parent_poi;

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getCp() {
                return cp;
            }

            public void setCp(String cp) {
                this.cp = cp;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPoiType() {
                return poiType;
            }

            public void setPoiType(String poiType) {
                this.poiType = poiType;
            }

            public PointBean getPoint() {
                return point;
            }

            public void setPoint(PointBean point) {
                this.point = point;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }

            public ParentPoiBean getParent_poi() {
                return parent_poi;
            }

            public void setParent_poi(ParentPoiBean parent_poi) {
                this.parent_poi = parent_poi;
            }

            public static class PointBean {
                /**
                 * x : 113.50021845370703
                 * y : 34.815603599902204
                 */

                private double x;
                private double y;

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }
            }

            public static class ParentPoiBean {
                /**
                 * name :
                 * tag :
                 * addr :
                 * point : {"x":0,"y":0}
                 * direction :
                 * distance :
                 * uid :
                 */

                private String name;
                private String tag;
                private String addr;
                private PointBeanX point;
                private String direction;
                private String distance;
                private String uid;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getAddr() {
                    return addr;
                }

                public void setAddr(String addr) {
                    this.addr = addr;
                }

                public PointBeanX getPoint() {
                    return point;
                }

                public void setPoint(PointBeanX point) {
                    this.point = point;
                }

                public String getDirection() {
                    return direction;
                }

                public void setDirection(String direction) {
                    this.direction = direction;
                }

                public String getDistance() {
                    return distance;
                }

                public void setDistance(String distance) {
                    this.distance = distance;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public static class PointBeanX {
                    /**
                     * x : 0
                     * y : 0
                     */

                    private int x;
                    private int y;

                    public int getX() {
                        return x;
                    }

                    public void setX(int x) {
                        this.x = x;
                    }

                    public int getY() {
                        return y;
                    }

                    public void setY(int y) {
                        this.y = y;
                    }
                }
            }
        }
    }
}
