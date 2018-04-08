package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;

/**
 * This class means a page is a 'standard' page which has many
 * standard behavior.
 */
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

    public void switchToThisPage() {
        driver.switchTo().window(getWindowHandler());
    }
}
