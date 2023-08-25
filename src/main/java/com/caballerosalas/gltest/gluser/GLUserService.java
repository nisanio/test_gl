package com.caballerosalas.gltest.gluser;

import com.caballerosalas.gltest.errorhandling.CustomDataNotFoundException;
import com.caballerosalas.gltest.phone.Phone;
import com.caballerosalas.gltest.phone.PhoneRepository;
import com.caballerosalas.gltest.phone.PhoneService;
import com.caballerosalas.gltest.phone.PhoneUtils;
import com.caballerosalas.gltest.security.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public  class GLUserService {

    private final GLUserRepository userRepository;
    private final PhoneRepository phoneRepository;



    @Autowired
    JwtTokenUtils jwtUtil;

    @Autowired
    GLUserUtils userUtils;

    @Autowired
    PhoneUtils phoneUtils;

    @Autowired
    PhoneService phoneService;

    @Autowired
    public GLUserService(GLUserRepository userRepository, PhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }

    // for debugging
    public List<GLUser> getUsers() {

        return userRepository.findAll();

    }

    public GLUserResponse getUserByEmail(String email, String token) {

        Optional<GLUser> userRequested = userRepository.findUserByEmail(email);
        if (!userRequested.isPresent()){
            throw new CustomDataNotFoundException("User not found");
        }
        if (!jwtUtil.validateAccessToken(token)){
            throw new CustomDataNotFoundException("Token Invalid");
        }

        Optional<List<Phone>> phones = phoneRepository.findPhonesByUserId(userRequested.get().getId());
        List<Phone> phoneList = Collections.emptyList();
        if (phones.isPresent()){
            phoneList = phones.get();
        }
        return userUtils.buildUserResponse(userRequested.get(), phoneList);

    }

    public GLUserResponse addNewUser(GLUserResponse user){
        List<Phone> newPhones = Collections.emptyList(); // ?

        userUtils.validate(user);

        GLUser newUser = userRepository.save(user.toGLUser());
        List<Phone> phoneList = user.toPhoneList();
        for (Phone phone : phoneList) {
            phone.setUser(newUser);
        }

        if (!user.getPhones().isEmpty()){
            newPhones = phoneRepository.saveAll(phoneList);
        }

        return userUtils.buildUserResponse(newUser, newPhones);
    }


}

