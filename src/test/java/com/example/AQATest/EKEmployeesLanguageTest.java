package com.example.AQATest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import static org.hamcrest.Matchers.*;

public class EKEmployeesLanguageTest {

    private static final String BASE_URI = "http://localhost:3000/api/employees";
    private static final String EMPLOYEE_ID = "34263d5c-7332-11ec-aa3e-0242ac11000a";
    private static final String LANGUAGE = "languages";

    private static final String LANGUAGE_ID = "70f1df62-fe0a-4e78-b8f1-958e3752f08f";
    private static final String LANGUAGE_LEVEL_ID = "74385500-763c-4573-9b11-f8cf2a91fb9f";
    private static final String PUT_LANGUAGE_LEVEL_ID = "e6f298a1-ac2c-4f80-a39d-a27d2cfc22f8";
    private static final String LANGUAGE_ENTITY_ID = "125c1c78-41ab-4ae4-a111-7289721ecf53";

    public String UrlBuild() {
        return UriComponentsBuilder
                .fromHttpUrl(BASE_URI)
                .pathSegment(EMPLOYEE_ID)
                .pathSegment(LANGUAGE)
                .toUriString();
    }

    public JSONObject createPostBody() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("languageId", LANGUAGE_ID);
        requestParams.put("spokenLanguageLevelId", LANGUAGE_LEVEL_ID);
        requestParams.put("readingLanguageLevelId", LANGUAGE_LEVEL_ID);
        return requestParams;
    }

    public JSONObject createPutBody() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("languageId", LANGUAGE_ID);
        requestParams.put("spokenLanguageLevelId", PUT_LANGUAGE_LEVEL_ID);
        requestParams.put("readingLanguageLevelId", PUT_LANGUAGE_LEVEL_ID);
        return requestParams;
    }

    @Test
    public void getEmployeeLanguage() {
        RestAssured.baseURI = UrlBuild();
        Response response = RestAssured.given()
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body("rows.language.title[0]", equalTo("English"))
                .extract()
                .response();
        response.prettyPrint();
    }

    @Test
    public void addEmployeeLanguage() {
        RestAssured.baseURI = UrlBuild();
        JSONObject requestParams = createPostBody();
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestParams)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();
    }


    @Test
    public void editEmployeeLanguage() {
        RestAssured.baseURI = UrlBuild();
        JSONObject requestParams = createPutBody();
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestParams)
                .when()
                .put(LANGUAGE_ENTITY_ID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body("id", equalTo(LANGUAGE_ENTITY_ID))
                .extract()
                .response();
        response.prettyPrint();
    }

    @Test
    public void deleteEmployeeLanguage() {
        RestAssured.baseURI = UrlBuild();
        Response response = RestAssured.given()
                .when()
                .delete(LANGUAGE_ENTITY_ID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body("id", equalTo(LANGUAGE_ENTITY_ID))
                .extract()
                .response();
        response.prettyPrint();
    }

}
