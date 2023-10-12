package org.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.base.baseTest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test2 {


    @Test
    public void postUserDetails() {

        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        JSONObject js = new JSONObject();
        js.put("id","10");
        js.put("email","johngreen@gmail.com");
        js.put("first_name", "John");
        js.put("last_name", "Green");
        js.put("avatar", "https://reqres.in/img/faces/6-image.jpg");
        request.body(js.toJSONString());
        Response response = request.post("https://reqres.in/api/users");
        int code = response.getStatusCode();
        Assert.assertEquals(code,201);
        System.out.println("Post request code is" + code);
        baseTest.log.debug("User details posted  successfully");

    }

}
