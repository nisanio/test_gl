package com.caballerosalas.gltest.phone;



import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneUtils {

    public List<PhoneResponse> buildPhoneResponseList(List<Phone> phones){

        List<PhoneResponse> phoneResponses = new ArrayList<PhoneResponse>();
        for (Phone phone : phones) {
            PhoneResponse phoneResponse = new PhoneResponse();
            phoneResponse.setNumber(phone.getNumber());
            phoneResponse.setCitycode(phone.getCitycode());
            phoneResponse.setCountrycode(phone.getCountrycode());
            phoneResponses.add(phoneResponse);
        }

        return phoneResponses;
    }
}
