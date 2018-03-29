package com.tsuna.reaper.jingdong.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class represents a singleton factory to build WebDriver.
 * The webdriver created will be customize here.
 * Including timeouts,window maxmize,listener
 */
public class ChromeDriverFactory {

    private static WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConstants.DEFAULT_IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver = decorateWithListener(driver);
    }

    public static synchronized WebDriver getDriver() {
        return driver;
    }

    private static WebDriver decorateWithListener(WebDriver driver) {
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new CustomWebDriverListener());
        return eventFiringWebDriver;
    }
}
