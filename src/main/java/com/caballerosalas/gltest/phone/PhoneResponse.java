package com.caballerosalas.gltest.phone;

import java.util.UUID;

public class PhoneResponse {
//    private UUID phoneId;
    private long number;
    private String citycode;
    private String countrycode;

//    private UUID userId;

    public PhoneResponse() {
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

}
