package com.example.AQATest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class EKEmployeesAuthTest {

    private static final String BASE_URI = "http://localhost:8090/api/employees";
    private static final String EMPLOYEE_ID = "34263d5c-7332-11ec-aa3e-0242ac11000a";
    private static final String LANGUAGE = "languages";
    private static final String GET_TOKEN_URL = "https://auth-test.intexsoft.by/auth/realms/master/protocol/openid-connect/token";

    private String accessToken;

    @Before
    public void setup() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "intexsoft-expertise-keeper");
        params.add("username", "denis.metelitsa");
        params.add("password", "Vfksirf2127_!");
        Response response = RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParams(params)
                .when()
                .post(GET_TOKEN_URL);
        accessToken = response.jsonPath().get("access_token").toString();
//        accessToken = "Bearer " + response.jsonPath().get("access_token").toString();
    }

    public String UrlBuild() {
        return UriComponentsBuilder
                .fromHttpUrl(BASE_URI)
                .pathSegment(EMPLOYEE_ID)
                .pathSegment(LANGUAGE)
                .toUriString();
    }

    @Test
    public void getEmployeeLanguageThroughFacade() {
        RestAssured.baseURI = UrlBuild();
        Response response = RestAssured.given()
//                .header("Authorization", accessToken)
                .auth().oauth2(accessToken)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();
    }

}
