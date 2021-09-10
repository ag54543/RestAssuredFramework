package com.sample.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteAPITest {
    @Test
    public void deleteAPI(){
        given().relaxedHTTPSValidation()
                .header("Authorization", "")
                .when()
                .delete("https://gorest.co.in/public/v1/users/997")
                .then()
                .assertThat()
                .statusCode(204);
    }
}
