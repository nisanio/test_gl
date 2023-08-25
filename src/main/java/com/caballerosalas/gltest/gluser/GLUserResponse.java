package com.caballerosalas.gltest.gluser;

import com.caballerosalas.gltest.phone.Phone;
import com.caballerosalas.gltest.phone.PhoneResponse;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GLUserResponse {

    private UUID userId;
    private Date created;
    private Date lastLogin;
    private String token;
    private Boolean isActive;
    private String name;
    private String email;
    private String password;

    private List<PhoneResponse> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<PhoneResponse> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneResponse> phones) {
        this.phones = phones;
    }


    public GLUserResponse() {}

    public GLUser toGLUser() {
        return new GLUser(
                this.userId,
                this.getName(),
                this.getEmail(),
                this.getPassword()
        );
    }

    public List<Phone> toPhoneList() {
        List<Phone> phoneList = new ArrayList<Phone>();

        for (PhoneResponse phoneResponse : phones) {
            Phone phone = new Phone();
            phone.setNumber(phoneResponse.getNumber());
            phone.setCitycode(phoneResponse.getCitycode());
            phone.setCountrycode(phoneResponse.getCountrycode());
            phone.setUser(this.toGLUser());
            phoneList.add(phone);
        }

        return phoneList;
    }

}
