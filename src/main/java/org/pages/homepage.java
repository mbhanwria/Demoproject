package org.pages;

import org.base.baseTest;
import org.bouncycastle.oer.OERDefinition;
import org.objects.homepageobjects;
import org.objects.loginpageobjects;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.util.constants;
import org.util.controlmethods;

public class homepage{
    controlmethods cr = new controlmethods();
    baseTest br = new baseTest();
    WebElement cartcount;
    public void addToCart() {
       // br.switchToWindow(br.defaultwindow);
        cr.getWebElement("XPATH", homepageobjects.addToCart).click();
        cr.waits(5);
        cartcount = cr.getWebElement("XPATH", homepageobjects.cartCount);
        Assert.assertTrue(cartcount.isDisplayed());
        cr.waits(3);
        //cr.getWebElement("ID",homepageobjects.removeProduct).click();
        baseTest.log.debug("Product added to cart successfully");
    }

    public void removeProductFromCart() {
        cr.getWebElement("XPATH", homepageobjects.addToCart).click();
        cr.waits(10);
        cartcount = cr.getWebElement("XPATH", homepageobjects.cartCount);
        Assert.assertTrue(cartcount.isDisplayed());
        baseTest.log.debug("Cart count verified");
        cr.waits(10);
        cr.getWebElement("ID",homepageobjects.removeProduct).click();
        cr.waits(2);
        cartcount = cr.getWebElement("XPATH", homepageobjects.cartCount);
        Assert.assertTrue(cartcount.isDisplayed());
        baseTest.log.debug("Remove button is not clickable");

    }

}
