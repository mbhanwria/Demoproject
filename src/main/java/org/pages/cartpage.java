package org.pages;

import org.base.baseTest;
import org.objects.cartpageobjects;
import org.objects.homepageobjects;
import org.openqa.selenium.WebElement;
import org.slf4j.ILoggerFactory;
import org.testng.Assert;
import org.util.controlmethods;

public class cartpage {

    controlmethods cr = new controlmethods();

    public void buyProduct() {

        cr.getWebElement("XPATH", homepageobjects.cartCount).click();
        WebElement productname = cr.getWebElement("XPATH", cartpageobjects.productname);
        Assert.assertTrue(productname.isDisplayed());
        baseTest.log.debug("Product name verified");
        cr.waits(3);
        cr.getWebElement("ID", cartpageobjects.checkoutbutton).click();
        cr.getWebElement("ID", cartpageobjects.firstname).sendKeys("user1");
        cr.getWebElement("ID", cartpageobjects.lastname).sendKeys("lats");
        cr.getWebElement("ID", cartpageobjects.postalcode).sendKeys("123456");
        cr.waits(3);
        cr.getWebElement("XPATH", cartpageobjects.continuebutton).click();
        cr.waits(4);
        WebElement productprice = cr.getWebElement("XPATH", cartpageobjects.productprice);
        Assert.assertTrue(productprice.isDisplayed());
        cr.waits(3);
        baseTest.log.debug("Product price verified");
        cr.getWebElement("ID", cartpageobjects.finishbutton).click();
        cr.waits(5);
        WebElement message = cr.getWebElement("XPATH", cartpageobjects.successfulordermessage);
        Assert.assertTrue(message.isDisplayed());
        cr.waits(3);
        baseTest.log.debug("Order placed successfully");
    }

    public void buyProductError() {

        cr.getWebElement("XPATH", homepageobjects.cartCount).click();
        WebElement productname = cr.getWebElement("XPATH", cartpageobjects.productname);
        Assert.assertTrue(productname.isDisplayed());
        cr.waits(3);
        cr.getWebElement("ID", cartpageobjects.checkoutbutton).click();
        cr.getWebElement("ID", cartpageobjects.firstname).sendKeys("user1");
        WebElement last = cr.getWebElement("ID", cartpageobjects.lastname);
        try{
            last.sendKeys("ls");
            System.out.print("Test Case Failed");
        }
        catch (Exception e){
            System.out.print("Test Case Passed");
        }
        baseTest.log.debug("Last name is not editable");

    }
}
