package com.caballerosalas.gltest.gluser;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PasswordUtils {
    static final String ONE_UPPERCASE = "^[^A-Z]*[A-Z][^A-Z]*$";
    static final String TWO_DIGITS = "^\\D*(\\d)\\D*(\\d)\\D*$";
    static private Boolean validateOneUppercase(String password){
        return Pattern.compile(ONE_UPPERCASE)
                .matcher(password)
                .matches();
    }

    static private Boolean validateTwoDigits(String password){
        return Pattern.compile(TWO_DIGITS, Pattern.CASE_INSENSITIVE)
                .matcher(password)
                .matches();
    }

    static private Boolean validateLength(String password){
        return ((password.length() >= 8) &&  (password.length() <= 12));
    }

    static public Boolean validatePassword(String password){
        Boolean le = PasswordUtils.validateLength(password);
        Boolean un = PasswordUtils.validateOneUppercase(password);
        Boolean to = PasswordUtils.validateTwoDigits(password);
        return PasswordUtils.validateLength(password) &&
                PasswordUtils.validateOneUppercase(password) &&
                PasswordUtils.validateTwoDigits(password);
    }
}
