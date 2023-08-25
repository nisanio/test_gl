package com.caballerosalas.gltest.gluser;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailUtils {
    static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    static Boolean validateEmailFormat(String email){
        return Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE)
                .matcher(email)
                .matches();
    }
}
