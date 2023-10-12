package org.util;

import org.base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class controlmethods{
    public WebElement getWebElement(String locatortype, String locatorvalue) {
        switch (locatortype) {
            case "XPATH":
                return baseTest.driver.findElement(By.xpath(locatorvalue));
            case "ID":
                return baseTest.driver.findElement(By.id(locatorvalue));
            case "CSS":
                return baseTest.driver.findElement(By.cssSelector(locatorvalue));
            case "NAME":
                return baseTest.driver.findElement(By.name(locatorvalue));
            default:
                return null;


        }
    }
        public List<WebElement> getWebElements(String locatortype, String locatorvalue){
            switch (locatortype) {
                case "XPATH":
                    return (List<WebElement>) baseTest.driver.findElements(By.xpath(locatorvalue));
                case "ID":
                    return (List<WebElement>) baseTest.driver.findElements(By.id(locatorvalue));
                case "CSS":
                    return (List<WebElement>) baseTest.driver.findElements(By.cssSelector(locatorvalue));
                case "NAME":
                    return (List<WebElement>) baseTest.driver.findElements(By.name(locatorvalue));
                default:
                    return null;
            }
        }

    public void waits(long time) {

                baseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

    }


    }

