package com.caballerosalas.gltest.tests

import com.caballerosalas.gltest.gluser.GLUserService
import com.caballerosalas.gltest.phone.PhoneService
import com.caballerosalas.gltest.phone.PhoneUtils
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import spock.lang.Shared
import spock.lang.Specification
import static org.springframework.http.HttpStatus.*


@AutoConfigureMockMvc
@WebMvcTest
class GLTestApplicationTest  extends Specification{


    @Autowired
    private MockMvc mvc

    @SpringBean
    GLUserService userService = Stub()

    @SpringBean
    PhoneService phoneService = Stub()

    @SpringBean
    PhoneUtils phoneUtils = Stub()



    def "when get is performed then the response has status 200'"() {
        given:
        userService.getUsers() >> Arrays.asList()
        expect:
        mvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect( status().isOk() ).andReturn();

    }
}

