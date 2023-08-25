package com.caballerosalas.gltest.gluser;

import com.caballerosalas.gltest.phone.PhoneResponse;
import com.caballerosalas.gltest.phone.PhoneService;
import com.caballerosalas.gltest.phone.PhoneUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class GLUserController {
    private final GLUserService userService;
    private final PhoneService phoneService;

    @Autowired
    PhoneUtils phoneUtils;

    @Autowired
    public GLUserController(GLUserService userService, PhoneService phoneService) {
        this.userService = userService;
        this.phoneService = phoneService;
    }

    @GetMapping(path = "/api/users")
    public List<GLUser> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/api/login/{email}")
    public ResponseEntity<GLUserResponse> getLogin(@PathVariable String email,
                                                   @RequestHeader(name = "Authorization") String token) {

        GLUserResponse user = userService.getUserByEmail(email, token);
        List<PhoneResponse> phones = phoneUtils.buildPhoneResponseList(phoneService.getPhones(user.toGLUser()));
        user.setPhones(phones);
        return new ResponseEntity<GLUserResponse>(user, HttpStatus.OK);
    }

    @PostMapping(path = "api/sign-up")
    public GLUserResponse registerNewUser(@RequestBody GLUserResponse user) {

        return userService.addNewUser(user);

    }
}
