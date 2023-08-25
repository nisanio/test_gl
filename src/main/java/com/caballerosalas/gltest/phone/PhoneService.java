package com.caballerosalas.gltest.phone;

import com.caballerosalas.gltest.gluser.GLUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getPhones(GLUser user){
        Optional<List<Phone>> phoneResponse = phoneRepository.findPhonesByUserId(user.getId());
        return phoneResponse.orElseGet(Arrays::asList);
    }

}
