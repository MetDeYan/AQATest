package com.example.AQATest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.springframework.web.util.UriComponentsBuilder;

import static org.hamcrest.Matchers.*;

public class EKEmployeesEducationTest {

    private static final String BASE_URI = "http://localhost:3000/api/employees";
    private static final String EMPLOYEE_ID = "34263d5c-7332-11ec-aa3e-0242ac11000a";
    private static final String EDUCATION = "education";
    private static final String EDUCATION_ID = "cd956307-3534-47ca-a275-b5825c125053";

    public String UrlBuild() {
        return UriComponentsBuilder
                .fromHttpUrl(BASE_URI)
                .pathSegment(EMPLOYEE_ID)
                .pathSegment(EDUCATION)
                .toUriString();
    }

    @Test
    public void getEmployeeEducation() {
        RestAssured.baseURI =  UrlBuild();
        Response response = RestAssured.given()
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body("rows.education[0]", equalTo("Academy of Public Administration under the President of the Republic of Belarus"))
                .extract()
                .response();
        response.prettyPrint();
    }

    @Test
    public void addEmployeeEducation() {
        RestAssured.baseURI = UrlBuild();
        Response response = RestAssured.given()
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
    public void deleteEmployeeEducation() {
        RestAssured.baseURI = UrlBuild();
        Response response = RestAssured.given()
                .when()
                .delete(EDUCATION_ID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body("id", equalTo(EDUCATION_ID))
                .extract()
                .response();
        response.prettyPrint();
    }

}
