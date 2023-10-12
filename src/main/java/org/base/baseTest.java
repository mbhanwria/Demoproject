package org.base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.util.constants;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.apache.logging.log4j.Logger.*;

public class baseTest {
    public static WebDriver driver;
    public String defaultwindow;
    public static Logger log = getLogger(baseTest.class.getName());

    @BeforeClass
    @Parameters("browser")
    public void browserInitialisation(String browser){
        setupDriver(browser);
        driver.manage().window().maximize();
        driver.get(constants.url);
        driver.manage().window().maximize();
        log.debug("Sauce Demo Launched Successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        defaultwindow = driver.getWindowHandle();

    }
    public void setupDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }



    }
    @AfterClass
    public void closeapplication(){
        driver.close();
        log.debug("Windows closed successfully");
    }

    public void switchToWindow(String defaultwindow){
        driver.switchTo().window(defaultwindow);

    }

}
