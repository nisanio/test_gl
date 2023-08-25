package com.caballerosalas.gltest.tests

import com.caballerosalas.gltest.gluser.GLUser
import com.caballerosalas.gltest.security.JwtTokenUtils
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.test.util.ReflectionTestUtils
import spock.lang.Specification

class ValidateAccessTokenSpecification extends Specification {
    def "should be false with a null token"(){
        given:
        def JwtTokenUtils jwtTokenUtils = new JwtTokenUtils()

        when:
        boolean jwt = jwtTokenUtils.validateAccessToken(null)

        then:
        !jwt
    }

    def "should be true with a valid token"(){
        given:

        def GLUser gl_user = new GLUser(
                UUID.fromString('a977eae8-430a-11ee-be56-0242ac120002'),
        "alejandro",
        "caballerosalas@gmail.com",
                "a2asfGfdfdf4")
        def JwtTokenUtils jwtTokenUtils = new JwtTokenUtils()
        ReflectionTestUtils.setField(jwtTokenUtils, "SECRET_KEY", "alejandro");

        when:
        String token = jwtTokenUtils.generateAccessToken(gl_user)
        boolean jwt = jwtTokenUtils.validateAccessToken(token)

        then:
        jwt
    }


}
