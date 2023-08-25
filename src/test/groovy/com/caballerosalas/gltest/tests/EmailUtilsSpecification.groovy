package com.caballerosalas.gltest.tests

import com.caballerosalas.gltest.gluser.EmailUtils

import spock.lang.Specification


class EmailUtilsSpecification extends Specification {

    def "should be false with a not an at sign"(){
        given:
        def String email = "caballerosalas#gmail.com"

        when:
        boolean valid = EmailUtils.validateEmailFormat(email)

        then:
        !valid
    }

    def "should be false with a not an at username"(){
        given:
        def String email = "@gmail.com"

        when:
        boolean valid = EmailUtils.validateEmailFormat(email)

        then:
        !valid
    }

    def "should be false with a not an at domain"(){
        given:
        def String email = "caballerosalas@"

        when:
        boolean valid = EmailUtils.validateEmailFormat(email)

        then:
        !valid
    }

    def "should be false with a two or more domains"(){
        given:
        def String email = "caballerosalas@gmail.com@gmail.com"

        when:
        boolean valid = EmailUtils.validateEmailFormat(email)

        then:
        !valid
    }

    def "should be false with an invalid domain"(){
        given:
        def String email = "caballerosalas@gmailcom"

        when:
        boolean valid = EmailUtils.validateEmailFormat(email)

        then:
        !valid
    }

    def "should be true with an valid user and domain"(){
        given:
        def String email = "caballerosalas@gmail.com"

        when:
        boolean valid = EmailUtils.validateEmailFormat(email)

        then:
        valid
    }
}
