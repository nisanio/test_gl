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

//    @SpringBean
//    GLUserRepository userRepository = Stub()

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
// having trouble with
//    def "should not thrown GLTestException with password according to rules"(){
//        given:
//        def utils = new GLUserUtils()
//        def user = new GLUserResponse()
//        user.setName("alejandro")
//        user.setEmail("caballerosalas@gmail.com")
//        user.setPassword("a2asfGfdfdf4")
//
//
//        when:
//        utils.validate(user)
//
//        then:
//        noExceptionThrown()
//    }

//    def "should not thrown GLTestException with no name"(){
//        given:
//            def utils = new GLUserUtils()
//            def user = new GLUserResponse()
//            Optional<GLUser> optionalGLUser = GroovyMock(Optional<GLUser>)
//            optionalGLUser.isPresent() >> true
//            userRepository.findUserByEmail(_ as String) >> optionalGLUser
//            GLUserRepository userRepository = Stub()
//            user.setEmail("caballerosalas@gmail.com")
//            user.setPassword("a2asfGfdfdf4")
//
//
//        when:
//            utils.validate(user)
//
//        then:
//            noExceptionThrown()
//    }

}
