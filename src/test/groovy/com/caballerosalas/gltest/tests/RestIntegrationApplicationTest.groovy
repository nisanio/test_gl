package com.caballerosalas.gltest.tests

import groovy.json.JsonSlurper
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RestIntegrationApplicationTest extends  Specification {
    static String url = "http://localhost:8080"
    RESTClient client = new RESTClient(url)
    static String payloadString = "{\n" +
            "\n" +
            "            \"email\":\"caballerosalas@gmail.com\",\n" +
            "            \"password\": \"a2asfGfdfdf4\",\n" +
            "            \"phones\": [\n" +
            "                    {\n" +
            "                        \"number\": 25874,\n" +
            "                        \"citycode\": \"56\",\n" +
            "                        \"countrycode\": \"59\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"number\": 1977,\n" +
            "                        \"citycode\": \"52\",\n" +
            "                        \"countrycode\": \"23\"\n" +
            "                    }\n" +
            "            ]\n" +
            "        }"


    def "when post a user with right data, it is created and the response contains data, including jwt token"(){
        given:
            def jsonSlurper = new JsonSlurper()
            def payload = jsonSlurper.parseText(payloadString)
            def requestBody = payload
        when:
            def responsePost = client.post(path:"/api/sign-up", body: payload, requestContentType: 'application/json')
            def token = responsePost.responseData.token
            client.headers["Authorization"] = token
            def response = client.get(path:"/api/login/caballerosalas@gmail.com", requestContentType: 'application/json')


        then:
        response.status == 200
        responsePost.status == 201
        response.responseData.name == null
        response.responseData.email == "caballerosalas@gmail.com"

    }

    // RESTClient throws an Exception  when a 404, it is by design even if the endpoint is correctly behaving
    def "when no token is send, response is 404"(){ //
        given:
        def jsonSlurper = new JsonSlurper()
        def payload = jsonSlurper.parseText(payloadString)
        def requestBody = payload
        when:
        def responsePost = client.post(path:"/api/sign-up", body: payload, requestContentType: 'application/json')
        def response = client.get(path:"/api/login/caballerosalas@gmail.com", requestContentType: 'application/json')

        then:
        thrown(HttpResponseException)


    }

}
