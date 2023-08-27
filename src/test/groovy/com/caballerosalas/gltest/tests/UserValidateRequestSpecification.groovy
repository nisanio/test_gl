package com.caballerosalas.gltest.tests

import com.caballerosalas.gltest.errorhandling.GLTestException
import com.caballerosalas.gltest.gluser.GLUser
import com.caballerosalas.gltest.gluser.GLUserRepository
import com.caballerosalas.gltest.gluser.GLUserUtils
import com.caballerosalas.gltest.gluser.GLUserResponse
import org.spockframework.spring.SpringBean
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserValidateRequestSpecification extends Specification {


    def "should thrown GLTestException with short password"(){
        given:
            def utils = new GLUserUtils()
            def user = new GLUserResponse()
            user.setName("alejandro")
            user.setEmail("caballerosalas@gmail.com")
            user.setPassword("ale")


        when:
        utils.validate(user)

        then:
        thrown(GLTestException)
    }

    def "should thrown GLTestException with big password"(){
        given:
        def utils = new GLUserUtils()
        def user = new GLUserResponse()
        user.setName("alejandro")
        user.setEmail("caballerosalas@gmail.com")
        user.setPassword("ale")


        when:
        utils.validate(user)

        then:
        thrown(GLTestException)
    }

    def "should thrown GLTestException with password with more than one uppercase"(){
        given:
        def utils = new GLUserUtils()
        def user = new GLUserResponse()
        user.setName("alejandro")
        user.setEmail("caballerosalas@gmail.com")
        user.setPassword("MM12password")


        when:
        utils.validate(user)

        then:
        thrown(GLTestException)
    }

    def "should thrown GLTestException with password with more than two numbers"(){
        given:
        def utils = new GLUserUtils()
        def user = new GLUserResponse()
        user.setName("alejandro")
        user.setEmail("caballerosalas@gmail.com")
        user.setPassword("M122password")


        when:
        utils.validate(user)

        then:
        thrown(GLTestException)
    }

}
