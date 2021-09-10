package com.sample.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteAPITest {
    @Test
    public void deleteAPI(){
        given().relaxedHTTPSValidation()
                .header("Authorization", "Bearer bce84d2cb0a1648c89d4c7a7029006f77f5394946780778cdb9f854734cba957")
                .when()
                .delete("https://gorest.co.in/public/v1/users/997")
                .then()
                .assertThat()
                .statusCode(204);
    }
}
