package com.example.qichaoqun.amerilink.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/8/29
 */
public class RoomInfor {

    private ResultBean result;
    private List<RoomListBean> room_list;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<RoomListBean> getRoom_list() {
        return room_list;
    }

    public void setRoom_list(List<RoomListBean> room_list) {
        this.room_list = room_list;
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

    public static class RoomListBean {
        /**
         * room_name : 大床客房<br />(1 KING BED-NONSMOKING)
         * room_desc : 32" LCD TV-WALK IN SHOWER-CLOCK W/MP3-HBO
         * room_features : COMP HI SPEED-SWEET DREAMS EXPERIENCE BED
         * room_type : NK1
         * rates_and_cancellation_policies : [{"rate_plan_code":"SDT18B","meal_plan_code":"BB","total_amount_before_tax":"157.85","total_amount_after_tax":"173.95","currency":"USD","rates":[{"check_in":"2018-08-29","check_out":"2018-08-30","rooms":"1","amount_before_tax":{"night_rate":"157.85","sub_total":"157.85"},"amount_after_tax":{"night_rate":"173.95","sub_total":"173.95"}}],"cancellation_information":{"support_cancel":"yes","non_refundable":"yes","details":[{"datetime":"2018-08-24T00:00:00","fee_type_value":"173.95","fee_type":"total_amount","amount_penalty":"173.95","policy_code":"CXP"},{"fee_type_value":"173.95","fee_type":"total_amount","amount_penalty":"173.95","policy_code":"CNS"}],"timezone":"America/Los_Angeles UTC-08:00"},"room_key":"TksxLi4qU0RUMThCLi4qMTEzMTM0","nationality":"|","booking_limit":null,"breakfast":{"include":1,"count":-1},"meal_plan_desc":"\u201cBed and Breakfast\u201d, \u201cIt includes the stay for all guests in selected room and includes a breakfast per person per day.\u201d"},{"rate_plan_code":"SDTO1A","meal_plan_code":"RO","total_amount_before_tax":"168.43","total_amount_after_tax":"185.61","currency":"USD","rates":[{"check_in":"2018-08-29","check_out":"2018-08-30","rooms":"1","amount_before_tax":{"night_rate":"168.43","sub_total":"168.43"},"amount_after_tax":{"night_rate":"185.61","sub_total":"185.61"}}],"cancellation_information":{"support_cancel":"yes","non_refundable":"yes","details":[{"datetime":"2018-08-24T00:00:00","fee_type_value":"185.61","fee_type":"total_amount","amount_penalty":"185.61","policy_code":"CXP"},{"fee_type_value":"185.61","fee_type":"total_amount","amount_penalty":"185.61","policy_code":"CNS"}],"timezone":"America/Los_Angeles UTC-08:00"},"room_key":"TksxLi4qU0RUTzFBLi4qMTEzMTM0","nationality":"|","booking_limit":null,"breakfast":{"include":0,"count":0},"meal_plan_desc":"\u201cRoom Only\u201d, \u201cIt only includes the stay for all guests in selected room. No meals are included.\u201d"},{"rate_plan_code":"SDT25C","meal_plan_code":"RO","total_amount_before_tax":"143.55","total_amount_after_tax":"158.19","currency":"USD","rates":[{"check_in":"2018-08-29","check_out":"2018-08-30","rooms":"1","amount_before_tax":{"night_rate":"143.55","sub_total":"143.55"},"amount_after_tax":{"night_rate":"158.19","sub_total":"158.19"}}],"cancellation_information":{"support_cancel":"yes","non_refundable":"yes","details":[{"datetime":"2018-08-24T00:00:00","fee_type_value":"158.19","fee_type":"total_amount","amount_penalty":"158.19","policy_code":"CXP"},{"fee_type_value":"158.19","fee_type":"total_amount","amount_penalty":"158.19","policy_code":"CNS"}],"timezone":"America/Los_Angeles UTC-08:00"},"room_key":"TksxLi4qU0RUMjVDLi4qMTEzMTM0","nationality":"|","booking_limit":null,"breakfast":{"include":0,"count":0},"meal_plan_desc":"\u201cRoom Only\u201d, \u201cIt only includes the stay for all guests in selected room. No meals are included.\u201d"},{"rate_plan_code":"SDT25B","meal_plan_code":"BB","total_amount_before_tax":"144.38","total_amount_after_tax":"159.10","currency":"USD","rates":[{"check_in":"2018-08-29","check_out":"2018-08-30","rooms":"1","amount_before_tax":{"night_rate":"144.38","sub_total":"144.38"},"amount_after_tax":{"night_rate":"159.10","sub_total":"159.10"}}],"cancellation_information":{"support_cancel":"yes","non_refundable":"yes","details":[{"datetime":"2018-08-24T00:00:00","fee_type_value":"159.10","fee_type":"total_amount","amount_penalty":"159.10","policy_code":"CXP"},{"fee_type_value":"159.10","fee_type":"total_amount","amount_penalty":"159.10","policy_code":"CNS"}],"timezone":"America/Los_Angeles UTC-08:00"},"room_key":"TksxLi4qU0RUMjVCLi4qMTEzMTM0","nationality":"|","booking_limit":null,"breakfast":{"include":1,"count":-1},"meal_plan_desc":"\u201cBed and Breakfast\u201d, \u201cIt includes the stay for all guests in selected room and includes a breakfast per person per day.\u201d"},{"rate_plan_code":"SDT18C","meal_plan_code":"RO","total_amount_before_tax":"156.95","total_amount_after_tax":"172.95","currency":"USD","rates":[{"check_in":"2018-08-29","check_out":"2018-08-30","rooms":"1","amount_before_tax":{"night_rate":"156.95","sub_total":"156.95"},"amount_after_tax":{"night_rate":"172.95","sub_total":"172.95"}}],"cancellation_information":{"support_cancel":"yes","non_refundable":"yes","details":[{"datetime":"2018-08-24T00:00:00","fee_type_value":"172.95","fee_type":"total_amount","amount_penalty":"172.95","policy_code":"CXP"},{"fee_type_value":"172.95","fee_type":"total_amount","amount_penalty":"172.95","policy_code":"CNS"}],"timezone":"America/Los_Angeles UTC-08:00"},"room_key":"TksxLi4qU0RUMThDLi4qMTEzMTM0","nationality":"|","booking_limit":null,"breakfast":{"include":0,"count":0},"meal_plan_desc":"\u201cRoom Only\u201d, \u201cIt only includes the stay for all guests in selected room. No meals are included.\u201d"}]
         * bed_info : [{"K":1}]
         * nonsmoking : 1
         * occupancy : null
         * amenities : {"1":1,"14":1}
         * room_pics : []
         * room_size : null
         * rate_supplier_id : 1058
         */

        private String room_name;
        private String room_desc;
        private String room_features;
        private String room_type;
        private int nonsmoking;
        private Object occupancy;
        private AmenitiesBean amenities;
        private Object room_size;
        private int rate_supplier_id;
        private List<RatesAndCancellationPoliciesBean> rates_and_cancellation_policies;
        private List<BedInfoBean> bed_info;
        private List<?> room_pics;

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_desc() {
            return room_desc;
        }

        public void setRoom_desc(String room_desc) {
            this.room_desc = room_desc;
        }

        public String getRoom_features() {
            return room_features;
        }

        public void setRoom_features(String room_features) {
            this.room_features = room_features;
        }

        public String getRoom_type() {
            return room_type;
        }

        public void setRoom_type(String room_type) {
            this.room_type = room_type;
        }

        public int getNonsmoking() {
            return nonsmoking;
        }

        public void setNonsmoking(int nonsmoking) {
            this.nonsmoking = nonsmoking;
        }

        public Object getOccupancy() {
            return occupancy;
        }

        public void setOccupancy(Object occupancy) {
            this.occupancy = occupancy;
        }

        public AmenitiesBean getAmenities() {
            return amenities;
        }

        public void setAmenities(AmenitiesBean amenities) {
            this.amenities = amenities;
        }

        public Object getRoom_size() {
            return room_size;
        }

        public void setRoom_size(Object room_size) {
            this.room_size = room_size;
        }

        public int getRate_supplier_id() {
            return rate_supplier_id;
        }

        public void setRate_supplier_id(int rate_supplier_id) {
            this.rate_supplier_id = rate_supplier_id;
        }

        public List<RatesAndCancellationPoliciesBean> getRates_and_cancellation_policies() {
            return rates_and_cancellation_policies;
        }

        public void setRates_and_cancellation_policies(List<RatesAndCancellationPoliciesBean> rates_and_cancellation_policies) {
            this.rates_and_cancellation_policies = rates_and_cancellation_policies;
        }

        public List<BedInfoBean> getBed_info() {
            return bed_info;
        }

        public void setBed_info(List<BedInfoBean> bed_info) {
            this.bed_info = bed_info;
        }

        public List<?> getRoom_pics() {
            return room_pics;
        }

        public void setRoom_pics(List<?> room_pics) {
            this.room_pics = room_pics;
        }

        public static class AmenitiesBean {
            /**
             * 1 : 1
             * 14 : 1
             */

            @SerializedName("1")
            private int _$1;
            @SerializedName("14")
            private int _$14;

            public int get_$1() {
                return _$1;
            }

            public void set_$1(int _$1) {
                this._$1 = _$1;
            }

            public int get_$14() {
                return _$14;
            }

            public void set_$14(int _$14) {
                this._$14 = _$14;
            }
        }

        public static class RatesAndCancellationPoliciesBean {
            /**
             * rate_plan_code : SDT18B
             * meal_plan_code : BB
             * total_amount_before_tax : 157.85
             * total_amount_after_tax : 173.95
             * currency : USD
             * rates : [{"check_in":"2018-08-29","check_out":"2018-08-30","rooms":"1","amount_before_tax":{"night_rate":"157.85","sub_total":"157.85"},"amount_after_tax":{"night_rate":"173.95","sub_total":"173.95"}}]
             * cancellation_information : {"support_cancel":"yes","non_refundable":"yes","details":[{"datetime":"2018-08-24T00:00:00","fee_type_value":"173.95","fee_type":"total_amount","amount_penalty":"173.95","policy_code":"CXP"},{"fee_type_value":"173.95","fee_type":"total_amount","amount_penalty":"173.95","policy_code":"CNS"}],"timezone":"America/Los_Angeles UTC-08:00"}
             * room_key : TksxLi4qU0RUMThCLi4qMTEzMTM0
             * nationality : |
             * booking_limit : null
             * breakfast : {"include":1,"count":-1}
             * meal_plan_desc : “Bed and Breakfast”, “It includes the stay for all guests in selected room and includes a breakfast per person per day.”
             */

            private String rate_plan_code;
            private String meal_plan_code;
            private String total_amount_before_tax;
            private String total_amount_after_tax;
            private String currency;
            private CancellationInformationBean cancellation_information;
            private String room_key;
            private String nationality;
            private Object booking_limit;
            private BreakfastBean breakfast;
            private String meal_plan_desc;
            private List<RatesBean> rates;

            public String getRate_plan_code() {
                return rate_plan_code;
            }

            public void setRate_plan_code(String rate_plan_code) {
                this.rate_plan_code = rate_plan_code;
            }

            public String getMeal_plan_code() {
                return meal_plan_code;
            }

            public void setMeal_plan_code(String meal_plan_code) {
                this.meal_plan_code = meal_plan_code;
            }

            public String getTotal_amount_before_tax() {
                return total_amount_before_tax;
            }

            public void setTotal_amount_before_tax(String total_amount_before_tax) {
                this.total_amount_before_tax = total_amount_before_tax;
            }

            public String getTotal_amount_after_tax() {
                return total_amount_after_tax;
            }

            public void setTotal_amount_after_tax(String total_amount_after_tax) {
                this.total_amount_after_tax = total_amount_after_tax;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public CancellationInformationBean getCancellation_information() {
                return cancellation_information;
            }

            public void setCancellation_information(CancellationInformationBean cancellation_information) {
                this.cancellation_information = cancellation_information;
            }

            public String getRoom_key() {
                return room_key;
            }

            public void setRoom_key(String room_key) {
                this.room_key = room_key;
            }

            public String getNationality() {
                return nationality;
            }

            public void setNationality(String nationality) {
                this.nationality = nationality;
            }

            public Object getBooking_limit() {
                return booking_limit;
            }

            public void setBooking_limit(Object booking_limit) {
                this.booking_limit = booking_limit;
            }

            public BreakfastBean getBreakfast() {
                return breakfast;
            }

            public void setBreakfast(BreakfastBean breakfast) {
                this.breakfast = breakfast;
            }

            public String getMeal_plan_desc() {
                return meal_plan_desc;
            }

            public void setMeal_plan_desc(String meal_plan_desc) {
                this.meal_plan_desc = meal_plan_desc;
            }

            public List<RatesBean> getRates() {
                return rates;
            }

            public void setRates(List<RatesBean> rates) {
                this.rates = rates;
            }

            public static class CancellationInformationBean {
                /**
                 * support_cancel : yes
                 * non_refundable : yes
                 * details : [{"datetime":"2018-08-24T00:00:00","fee_type_value":"173.95","fee_type":"total_amount","amount_penalty":"173.95","policy_code":"CXP"},{"fee_type_value":"173.95","fee_type":"total_amount","amount_penalty":"173.95","policy_code":"CNS"}]
                 * timezone : America/Los_Angeles UTC-08:00
                 */

                private String support_cancel;
                private String non_refundable;
                private String timezone;
                private List<DetailsBean> details;

                public String getSupport_cancel() {
                    return support_cancel;
                }

                public void setSupport_cancel(String support_cancel) {
                    this.support_cancel = support_cancel;
                }

                public String getNon_refundable() {
                    return non_refundable;
                }

                public void setNon_refundable(String non_refundable) {
                    this.non_refundable = non_refundable;
                }

                public String getTimezone() {
                    return timezone;
                }

                public void setTimezone(String timezone) {
                    this.timezone = timezone;
                }

                public List<DetailsBean> getDetails() {
                    return details;
                }

                public void setDetails(List<DetailsBean> details) {
                    this.details = details;
                }

                public static class DetailsBean {
                    /**
                     * datetime : 2018-08-24T00:00:00
                     * fee_type_value : 173.95
                     * fee_type : total_amount
                     * amount_penalty : 173.95
                     * policy_code : CXP
                     */

                    private String datetime;
                    private String fee_type_value;
                    private String fee_type;
                    private String amount_penalty;
                    private String policy_code;

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }

                    public String getFee_type_value() {
                        return fee_type_value;
                    }

                    public void setFee_type_value(String fee_type_value) {
                        this.fee_type_value = fee_type_value;
                    }

                    public String getFee_type() {
                        return fee_type;
                    }

                    public void setFee_type(String fee_type) {
                        this.fee_type = fee_type;
                    }

                    public String getAmount_penalty() {
                        return amount_penalty;
                    }

                    public void setAmount_penalty(String amount_penalty) {
                        this.amount_penalty = amount_penalty;
                    }

                    public String getPolicy_code() {
                        return policy_code;
                    }

                    public void setPolicy_code(String policy_code) {
                        this.policy_code = policy_code;
                    }
                }
            }

            public static class BreakfastBean {
                /**
                 * include : 1
                 * count : -1
                 */

                private int include;
                private int count;

                public int getInclude() {
                    return include;
                }

                public void setInclude(int include) {
                    this.include = include;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class RatesBean {
                /**
                 * check_in : 2018-08-29
                 * check_out : 2018-08-30
                 * rooms : 1
                 * amount_before_tax : {"night_rate":"157.85","sub_total":"157.85"}
                 * amount_after_tax : {"night_rate":"173.95","sub_total":"173.95"}
                 */

                private String check_in;
                private String check_out;
                private String rooms;
                private AmountBeforeTaxBean amount_before_tax;
                private AmountAfterTaxBean amount_after_tax;

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

                public String getRooms() {
                    return rooms;
                }

                public void setRooms(String rooms) {
                    this.rooms = rooms;
                }

                public AmountBeforeTaxBean getAmount_before_tax() {
                    return amount_before_tax;
                }

                public void setAmount_before_tax(AmountBeforeTaxBean amount_before_tax) {
                    this.amount_before_tax = amount_before_tax;
                }

                public AmountAfterTaxBean getAmount_after_tax() {
                    return amount_after_tax;
                }

                public void setAmount_after_tax(AmountAfterTaxBean amount_after_tax) {
                    this.amount_after_tax = amount_after_tax;
                }

                public static class AmountBeforeTaxBean {
                    /**
                     * night_rate : 157.85
                     * sub_total : 157.85
                     */

                    private String night_rate;
                    private String sub_total;

                    public String getNight_rate() {
                        return night_rate;
                    }

                    public void setNight_rate(String night_rate) {
                        this.night_rate = night_rate;
                    }

                    public String getSub_total() {
                        return sub_total;
                    }

                    public void setSub_total(String sub_total) {
                        this.sub_total = sub_total;
                    }
                }

                public static class AmountAfterTaxBean {
                    /**
                     * night_rate : 173.95
                     * sub_total : 173.95
                     */

                    private String night_rate;
                    private String sub_total;

                    public String getNight_rate() {
                        return night_rate;
                    }

                    public void setNight_rate(String night_rate) {
                        this.night_rate = night_rate;
                    }

                    public String getSub_total() {
                        return sub_total;
                    }

                    public void setSub_total(String sub_total) {
                        this.sub_total = sub_total;
                    }
                }
            }
        }

        public static class BedInfoBean {
            /**
             * K : 1
             */

            private int K;

            public int getK() {
                return K;
            }

            public void setK(int K) {
                this.K = K;
            }
        }
    }
}
