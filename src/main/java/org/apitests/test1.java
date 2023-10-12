package org.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Loader;
import org.base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {

    @Test
    public void getlist() {

    Response resp = RestAssured.get("https://reqres.in/api/users/2");
    int code = resp.getStatusCode();
    Assert.assertEquals(code,200);
    System.out.println("Get List code is" + code);
    baseTest.log.debug("Get List request successful");
}






}
