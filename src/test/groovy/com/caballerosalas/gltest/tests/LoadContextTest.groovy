package com.caballerosalas.gltest.tests

import com.caballerosalas.gltest.GLTestApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired (required = false)
    private GLTestApplication glTestApplication

    def "when context is loaded then all expected beans are created"() {
        expect: "the glTestApplication is created"
        glTestApplication
    }
}
