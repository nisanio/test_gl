package com.caballerosalas.gltest.gluser;

import com.caballerosalas.gltest.phone.Phone;
import com.caballerosalas.gltest.phone.PhoneUtils;
import com.caballerosalas.gltest.security.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
public class GLUserUtils {

    @Autowired
    JwtTokenUtils jwtUtil;

    @Autowired
    PhoneUtils phoneUtils;

    public GLUserResponse buildUserResponse(GLUser user, List<Phone> phones){
        GLUserResponse userResponse = new GLUserResponse();
        userResponse.setUserId(user.getId());
        userResponse.setName(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setCreated(new Date());
        userResponse.setLastLogin(new Date());
        userResponse.setToken(jwtUtil.generateAccessToken(user));
        userResponse.setActive(user.isAccountNonExpired());
        userResponse.setPhones(phoneUtils.buildPhoneResponseList(phones));
        return userResponse;
    }
}
