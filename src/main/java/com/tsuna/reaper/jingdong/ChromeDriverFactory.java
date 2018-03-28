package com.tsuna.reaper.jingdong;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverFactory {

    private static ChromeDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static synchronized ChromeDriver getDriver() {
        return driver;
    }
}
