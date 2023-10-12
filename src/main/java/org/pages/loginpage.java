package org.pages;

import org.apache.logging.log4j.Logger;
import org.base.baseTest;
import org.objects.loginpageobjects;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.util.constants;
import org.util.controlmethods;

import java.util.List;

public class loginpage{
    controlmethods cr = new controlmethods();

    public void signin() {
        cr.getWebElement("ID", loginpageobjects.username).sendKeys(constants.usernameone);
        cr.getWebElement("ID", loginpageobjects.password).sendKeys(constants.password);
        cr.getWebElement("ID",loginpageobjects.loginbutton).click();
        cr.waits(4);
        String title = baseTest.driver.getTitle();
        Assert.assertEquals(title,"Swag Labs");
        cr.waits(3);
        baseTest.log.debug("Logged in successfully");
    }

    public void lockedoutsignin() {
        cr.getWebElement("ID", loginpageobjects.username).sendKeys(constants.lockedoutusername);
        cr.getWebElement("ID", loginpageobjects.password).sendKeys(constants.password);
        cr.getWebElement("ID",loginpageobjects.loginbutton).click();
        cr.waits(4);
        WebElement message = cr.getWebElement("XPATH",loginpageobjects.lockedouterrormessage);
        Assert.assertTrue(message.isDisplayed());
        cr.waits(3);
        baseTest.log.debug("Locked out");
    }

    public void problemusersignin() {
        cr.getWebElement("ID", loginpageobjects.username).sendKeys(constants.problemusername);
        cr.getWebElement("ID", loginpageobjects.password).sendKeys(constants.password);
        cr.getWebElement("ID",loginpageobjects.loginbutton).click();
        cr.waits(4);
        String title = baseTest.driver.getTitle();
        Assert.assertEquals(title,"Swag Labs");
        cr.waits(3);
        List<WebElement> imagelist = cr.getWebElements("XPATH",loginpageobjects.wrongimage);
        Assert.assertEquals(imagelist.size(),6);
        baseTest.log.debug("Images don't match with product images");
    }

    public void errorusersignin() {
        cr.getWebElement("ID", loginpageobjects.username).sendKeys(constants.errorusername);
        cr.getWebElement("ID", loginpageobjects.password).sendKeys(constants.password);
        cr.getWebElement("ID",loginpageobjects.loginbutton).click();
        cr.waits(10);
        String title = baseTest.driver.getTitle();
        Assert.assertEquals(title,"Swag Labs");
        cr.waits(3);
        baseTest.log.debug("Error User Logged in successfully");
    }


}
