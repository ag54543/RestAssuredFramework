package com.sample.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetAPITest {
    @Test
    public void getUserAPI(){
        given()
                .relaxedHTTPSValidation()
                .when()
                .get("https://gorest.co.in/public/v1/users/51")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data.name",equalTo("Bhudev Bhattacharya"))
                .and()
                .header("x-frame-options", equalTo("SAMEORIGIN"));
    }

    @Test
    public void getUserAPITwo(){
      Response response = given().relaxedHTTPSValidation().get("https://gorest.co.in/public/v1/users/51");
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.time());
    }
}
