package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;

public abstract class PageBase {
    private String windowHandler;
    private WebDriver driver;

    PageBase(WebDriver driver) {
        this.driver = driver;
        this.windowHandler = driver.getWindowHandle();
    }

    public void close() {
        driver.switchTo().window(getWindowHandler()).close();
    }

    WebDriver getWebDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    private String getWindowHandler() {
        return windowHandler;
    }

    void switchToThisPage() {
        driver.switchTo().window(getWindowHandler());
    }
}
