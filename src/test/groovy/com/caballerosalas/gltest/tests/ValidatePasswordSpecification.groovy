package com.caballerosalas.gltest.tests

import com.caballerosalas.gltest.gluser.PasswordUtils
import spock.lang.Specification

class ValidatePasswordSpecification extends Specification {
    def "should be false with a password with less than 8 characters"(){
        given:
        def String password = "M12pas"

        when:
        boolean valid = PasswordUtils.validatePassword(password)

        then:
        !valid
    }
    def "should be false with a password with more than 12 characters"(){
        given:
        def String password = "M12passwordverylong"

        when:
        boolean valid = PasswordUtils.validatePassword(password)

        then:
        !valid
    }
    def "should be false with a password with more than one uppercase"(){
        given:
        def String password = "MM12password"

        when:
        boolean valid = PasswordUtils.validatePassword(password)

        then:
        !valid
    }
    def "should be false with a password with more than two numbers"(){
        given:
        def String password = "M122password"

        when:
        boolean valid = PasswordUtils.validatePassword(password)

        then:
        !valid
    }
    def "should be true with a password formatted according to rles"(){
        given:
        def String password = "a2asfGfdfdf4"

        when:
        boolean valid = PasswordUtils.validatePassword(password)

        then:
        valid
    }
}
