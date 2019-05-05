package com.example.qichaoqun.amerilink.bean;

import java.util.List;

/**
 * @author qichaoqun
 * @date 2018/9/1
 */
public class Country {

    /**
     * result : {"return_status":{"success":"true","exception":""}}
     * country_list : [{"country_id":"1","country_code":"AD","name":"Andorra"},{"country_id":"2","country_code":"AE","name":"United Arab Emirates"},{"country_id":"4","country_code":"AG","name":"Antigua and Barbuda"},{"country_id":"5","country_code":"AI","name":"Anguilla"},{"country_id":"6","country_code":"AL","name":"Albania"},{"country_id":"7","country_code":"AM","name":"Armenia"},{"country_id":"8","country_code":"AO","name":"Angola"},{"country_id":"10","country_code":"AR","name":"Argentina"},{"country_id":"11","country_code":"AS","name":"American Samoa"},{"country_id":"12","country_code":"AT","name":"Austria"},{"country_id":"13","country_code":"AU","name":"Australia"},{"country_id":"14","country_code":"AW","name":"Aruba"},{"country_id":"16","country_code":"AZ","name":"Azerbaijan"},{"country_id":"17","country_code":"BA","name":"Bosnia and Herzegovina"},{"country_id":"18","country_code":"BB","name":"Barbados"},{"country_id":"19","country_code":"BD","name":"Bangladesh"},{"country_id":"20","country_code":"BE","name":"Belgium"},{"country_id":"21","country_code":"BF","name":"Burkina Faso"},{"country_id":"22","country_code":"BG","name":"Bulgaria"},{"country_id":"23","country_code":"BH","name":"Bahrain"},{"country_id":"24","country_code":"BI","name":"Burundi"},{"country_id":"25","country_code":"BJ","name":"Benin"},{"country_id":"26","country_code":"BL","name":"Saint Barthélemy"},{"country_id":"27","country_code":"BM","name":"Bermuda"},{"country_id":"28","country_code":"BN","name":"Brunei"},{"country_id":"29","country_code":"BO","name":"Bolivia"},{"country_id":"30","country_code":"BQ","name":"Bonaire"},{"country_id":"31","country_code":"BR","name":"Brazil"},{"country_id":"32","country_code":"BS","name":"Bahamas"},{"country_id":"33","country_code":"BT","name":"Bhutan"},{"country_id":"35","country_code":"BW","name":"Botswana"},{"country_id":"36","country_code":"BY","name":"Belarus"},{"country_id":"37","country_code":"BZ","name":"Belize"},{"country_id":"38","country_code":"CA","name":"Canada"},{"country_id":"39","country_code":"CC","name":"Cocos [Keeling] Islands"},{"country_id":"42","country_code":"CG","name":"Republic of the Congo"},{"country_id":"43","country_code":"CH","name":"Switzerland"},{"country_id":"44","country_code":"CI","name":"Ivory Coast"},{"country_id":"45","country_code":"CK","name":"Cook Islands"},{"country_id":"46","country_code":"CL","name":"Chile"},{"country_id":"47","country_code":"CM","name":"Cameroon"},{"country_id":"48","country_code":"CN","name":"China"},{"country_id":"49","country_code":"CO","name":"Colombia"},{"country_id":"50","country_code":"CR","name":"Costa Rica"},{"country_id":"51","country_code":"CU","name":"Cuba"},{"country_id":"52","country_code":"CV","name":"Cape Verde"},{"country_id":"53","country_code":"CW","name":"Curacao"},{"country_id":"55","country_code":"CY","name":"Cyprus"},{"country_id":"56","country_code":"CZ","name":"Czechia"},{"country_id":"57","country_code":"DE","name":"Germany"},{"country_id":"58","country_code":"DJ","name":"Djibouti"},{"country_id":"59","country_code":"DK","name":"Denmark"},{"country_id":"60","country_code":"DM","name":"Dominica"},{"country_id":"61","country_code":"DO","name":"Dominican Republic"},{"country_id":"62","country_code":"DZ","name":"Algeria"},{"country_id":"63","country_code":"EC","name":"Ecuador"},{"country_id":"64","country_code":"EE","name":"Estonia"},{"country_id":"65","country_code":"EG","name":"Egypt"},{"country_id":"68","country_code":"ES","name":"Spain"},{"country_id":"69","country_code":"ET","name":"Ethiopia"},{"country_id":"70","country_code":"FI","name":"Finland"},{"country_id":"71","country_code":"FJ","name":"Fiji"},{"country_id":"73","country_code":"FM","name":"Micronesia"},{"country_id":"74","country_code":"FO","name":"Faroe Islands"},{"country_id":"75","country_code":"FR","name":"France"},{"country_id":"76","country_code":"GA","name":"Gabon"},{"country_id":"77","country_code":"GB","name":"United Kingdom"},{"country_id":"78","country_code":"GD","name":"Grenada"},{"country_id":"79","country_code":"GE","name":"Georgia"},{"country_id":"80","country_code":"GF","name":"French Guiana"},{"country_id":"82","country_code":"GH","name":"Ghana"},{"country_id":"83","country_code":"GI","name":"Gibraltar"},{"country_id":"84","country_code":"GL","name":"Greenland"},{"country_id":"85","country_code":"GM","name":"Gambia"},{"country_id":"86","country_code":"GN","name":"Guinea"},{"country_id":"87","country_code":"GP","name":"Guadeloupe"},{"country_id":"88","country_code":"GQ","name":"Equatorial Guinea"},{"country_id":"89","country_code":"GR","name":"Greece"},{"country_id":"91","country_code":"GT","name":"Guatemala"},{"country_id":"92","country_code":"GU","name":"Guam"},{"country_id":"94","country_code":"GY","name":"Guyana"},{"country_id":"95","country_code":"HK","name":"Hong Kong"},{"country_id":"97","country_code":"HN","name":"Honduras"},{"country_id":"98","country_code":"HR","name":"Croatia"},{"country_id":"99","country_code":"HT","name":"Haiti"},{"country_id":"100","country_code":"HU","name":"Hungary"},{"country_id":"101","country_code":"ID","name":"Indonesia"},{"country_id":"102","country_code":"IE","name":"Ireland"},{"country_id":"103","country_code":"IL","name":"Israel"},{"country_id":"105","country_code":"IN","name":"India"},{"country_id":"107","country_code":"IQ","name":"Iraq"},{"country_id":"108","country_code":"IR","name":"Iran"},{"country_id":"109","country_code":"IS","name":"Iceland"},{"country_id":"110","country_code":"IT","name":"Italy"},{"country_id":"111","country_code":"JE","name":"Jersey"},{"country_id":"112","country_code":"JM","name":"Jamaica"},{"country_id":"113","country_code":"JO","name":"Jordan"},{"country_id":"114","country_code":"JP","name":"Japan"},{"country_id":"115","country_code":"KE","name":"Kenya"},{"country_id":"116","country_code":"KG","name":"Kyrgyzstan"},{"country_id":"117","country_code":"KH","name":"Cambodia"},{"country_id":"120","country_code":"KN","name":"Saint Kitts and Nevis"},{"country_id":"122","country_code":"KR","name":"South Korea"},{"country_id":"123","country_code":"KW","name":"Kuwait"},{"country_id":"124","country_code":"KY","name":"Cayman Islands"},{"country_id":"125","country_code":"KZ","name":"Kazakhstan"},{"country_id":"126","country_code":"LA","name":"Laos"},{"country_id":"127","country_code":"LB","name":"Lebanon"},{"country_id":"128","country_code":"LC","name":"Saint Lucia"},{"country_id":"129","country_code":"LI","name":"Liechtenstein"},{"country_id":"130","country_code":"LK","name":"Sri Lanka"},{"country_id":"132","country_code":"LS","name":"Lesotho"},{"country_id":"133","country_code":"LT","name":"Lithuania"},{"country_id":"134","country_code":"LU","name":"Luxembourg"},{"country_id":"135","country_code":"LV","name":"Latvia"},{"country_id":"136","country_code":"LY","name":"Libya"},{"country_id":"137","country_code":"MA","name":"Morocco"},{"country_id":"138","country_code":"MC","name":"Monaco"},{"country_id":"139","country_code":"MD","name":"Moldova"},{"country_id":"140","country_code":"ME","name":"Montenegro"},{"country_id":"141","country_code":"MF","name":"Saint Martin"},{"country_id":"142","country_code":"MG","name":"Madagascar"},{"country_id":"144","country_code":"MK","name":"Macedonia"},{"country_id":"145","country_code":"ML","name":"Mali"},{"country_id":"146","country_code":"MM","name":"Myanmar [Burma]"},{"country_id":"147","country_code":"MN","name":"Mongolia"},{"country_id":"148","country_code":"MO","name":"Macao"},{"country_id":"149","country_code":"MP","name":"Northern Mariana Islands"},{"country_id":"150","country_code":"MQ","name":"Martinique"},{"country_id":"151","country_code":"MR","name":"Mauritania"},{"country_id":"152","country_code":"MS","name":"Montserrat"},{"country_id":"153","country_code":"MT","name":"Malta"},{"country_id":"154","country_code":"MU","name":"Mauritius"},{"country_id":"155","country_code":"MV","name":"Maldives"},{"country_id":"156","country_code":"MW","name":"Malawi"},{"country_id":"157","country_code":"MX","name":"Mexico"},{"country_id":"158","country_code":"MY","name":"Malaysia"},{"country_id":"159","country_code":"MZ","name":"Mozambique"},{"country_id":"160","country_code":"NA","name":"Namibia"},{"country_id":"161","country_code":"NC","name":"New Caledonia"},{"country_id":"162","country_code":"NE","name":"Niger"},{"country_id":"163","country_code":"NF","name":"Norfolk Island"},{"country_id":"164","country_code":"NG","name":"Nigeria"},{"country_id":"165","country_code":"NI","name":"Nicaragua"},{"country_id":"166","country_code":"NL","name":"Netherlands"},{"country_id":"167","country_code":"NO","name":"Norway"},{"country_id":"168","country_code":"NP","name":"Nepal"},{"country_id":"170","country_code":"NU","name":"Niue"},{"country_id":"171","country_code":"NZ","name":"New Zealand"},{"country_id":"172","country_code":"OM","name":"Oman"},{"country_id":"173","country_code":"PA","name":"Panama"},{"country_id":"174","country_code":"PE","name":"Peru"},{"country_id":"175","country_code":"PF","name":"French Polynesia"},{"country_id":"176","country_code":"PG","name":"Papua New Guinea"},{"country_id":"177","country_code":"PH","name":"Philippines"},{"country_id":"178","country_code":"PK","name":"Pakistan"},{"country_id":"179","country_code":"PL","name":"Poland"},{"country_id":"182","country_code":"PR","name":"Puerto Rico"},{"country_id":"183","country_code":"PS","name":"Palestine"},{"country_id":"184","country_code":"PT","name":"Portugal"},{"country_id":"185","country_code":"PW","name":"Palau"},{"country_id":"186","country_code":"PY","name":"Paraguay"},{"country_id":"187","country_code":"QA","name":"Qatar"},{"country_id":"188","country_code":"RE","name":"Réunion"},{"country_id":"189","country_code":"RO","name":"Romania"},{"country_id":"190","country_code":"RS","name":"Serbia"},{"country_id":"191","country_code":"RU","name":"Russia"},{"country_id":"192","country_code":"RW","name":"Rwanda"},{"country_id":"193","country_code":"SA","name":"Saudi Arabia"},{"country_id":"194","country_code":"SB","name":"Solomon Islands"},{"country_id":"195","country_code":"SC","name":"Seychelles"},{"country_id":"196","country_code":"SD","name":"Sudan"},{"country_id":"197","country_code":"SE","name":"Sweden"},{"country_id":"198","country_code":"SG","name":"Singapore"},{"country_id":"200","country_code":"SI","name":"Slovenia"},{"country_id":"202","country_code":"SK","name":"Slovakia"},{"country_id":"203","country_code":"SL","name":"Sierra Leone"},{"country_id":"204","country_code":"SM","name":"San Marino"},{"country_id":"205","country_code":"SN","name":"Senegal"},{"country_id":"207","country_code":"SR","name":"Suriname"},{"country_id":"209","country_code":"ST","name":"São Tomé and Príncipe"},{"country_id":"210","country_code":"SV","name":"El Salvador"},{"country_id":"211","country_code":"SX","name":"Sint Maarten"},{"country_id":"212","country_code":"SY","name":"Syria"},{"country_id":"213","country_code":"SZ","name":"Swaziland"},{"country_id":"214","country_code":"TC","name":"Turks and Caicos Islands"},{"country_id":"215","country_code":"TD","name":"Chad"},{"country_id":"217","country_code":"TG","name":"Togo"},{"country_id":"218","country_code":"TH","name":"Thailand"},{"country_id":"219","country_code":"TJ","name":"Tajikistan"},{"country_id":"223","country_code":"TN","name":"Tunisia"},{"country_id":"224","country_code":"TO","name":"Tonga"},{"country_id":"225","country_code":"TR","name":"Turkey"},{"country_id":"226","country_code":"TT","name":"Trinidad and Tobago"},{"country_id":"228","country_code":"TW","name":"Taiwan"},{"country_id":"229","country_code":"TZ","name":"Tanzania"},{"country_id":"230","country_code":"UA","name":"Ukraine"},{"country_id":"231","country_code":"UG","name":"Uganda"},{"country_id":"233","country_code":"US","name":"United States"},{"country_id":"234","country_code":"UY","name":"Uruguay"},{"country_id":"235","country_code":"UZ","name":"Uzbekistan"},{"country_id":"237","country_code":"VC","name":"Saint Vincent and the Grenadines"},{"country_id":"238","country_code":"VE","name":"Venezuela"},{"country_id":"239","country_code":"VG","name":"British Virgin Islands"},{"country_id":"240","country_code":"VI","name":"U.S. Virgin Islands"},{"country_id":"241","country_code":"VN","name":"Vietnam"},{"country_id":"242","country_code":"VU","name":"Vanuatu"},{"country_id":"244","country_code":"WS","name":"Samoa"},{"country_id":"245","country_code":"XK","name":"Kosovo"},{"country_id":"246","country_code":"YE","name":"Yemen"},{"country_id":"248","country_code":"ZA","name":"South Africa"},{"country_id":"249","country_code":"ZM","name":"Zambia"},{"country_id":"250","country_code":"ZW","name":"Zimbabwe"}]
     */

    private ResultBean result;
    private List<CountryListBean> country_list;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<CountryListBean> getCountry_list() {
        return country_list;
    }

    public void setCountry_list(List<CountryListBean> country_list) {
        this.country_list = country_list;
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

    public static class CountryListBean {
        /**
         * country_id : 1
         * country_code : AD
         * name : Andorra
         */

        private String country_id;
        private String country_code;
        private String name;

        public String getCountry_id() {
            return country_id;
        }

        public void setCountry_id(String country_id) {
            this.country_id = country_id;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
