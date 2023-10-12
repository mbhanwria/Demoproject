package org.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test3 {
    @Test
            public void getSingle() {
        Response resp = RestAssured.get("https://reqres.in/api/users/2");
        int code = resp.getStatusCode();
        Assert.assertEquals(code, 200);
        System.out.println("code is" + code);
        baseTest.log.debug("Get single requested successfully");
    }






}
