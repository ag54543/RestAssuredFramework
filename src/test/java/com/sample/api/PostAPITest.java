package com.sample.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class PostAPITest {
Logger log = Logger.getLogger(String.valueOf(PostAPITest.class));
    @Test
    public void testOne(){
        Response response =
        given()
                .relaxedHTTPSValidation()
                .header("Content-Type","application/json")
                .and()
                .header("Authorization", "Bearer bce84d2cb0a1648c89d4c7a7029006f77f5394946780778cdb9f854734cba957")
                .and()
                .body("{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"ashishone123.ramakrishna@15ce.com\", \"status\":\"active\"}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .extract().response();
//                .statusCode(201)
//                .body("status",equalTo("active"));
        System.out.println(response.getBody().prettyPrint());

    }

    @Test
    public void testTwo() throws JSONException {
        log.info("Inside log#####################################################");
        JSONObject jsonObject = new JSONObject("{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"ashishone66.ramakrishna@15ce.com\", \"status\":\"active\"}");
        String randomStr = RandomStringUtils.random(5, true, false);
        jsonObject.put("email",randomStr+"@15ce.com");
        RequestSpecification requestSpecification =
                given().header("Content-Type","application/json")
                .and().header("Authorization", "Bearer bce84d2cb0a1648c89d4c7a7029006f77f5394946780778cdb9f854734cba957")
                .and()
                .body(jsonObject.toString());
        Response response =  requestSpecification.relaxedHTTPSValidation().post("https://gorest.co.in/public/v1/users");
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        System.out.println("email.. "+response.jsonPath().getJsonObject("data.email"));
        Assert.assertEquals("active",response.jsonPath().getString("data.status"));

    }
}
