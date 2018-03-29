package com.tsuna.reaper.jingdong.common;

import org.openqa.selenium.WebDriver;

/**
 * A set of window util to control the open and close of window
 */
public class WindowUtil {
    public static boolean isWindowExists(WebDriver driver, String title) {
        boolean isWindowExists = false;
        String originWindowHandler = driver.getWindowHandle();
        for (String handler : driver.getWindowHandles()) {
            String windowTitle = driver.switchTo().window(handler).getTitle();
            if (title.equals(windowTitle)) {
                isWindowExists = true;
                break;
            }
        }
        return isWindowExists;
    }

    public static void switchToWindowUsingTitle(WebDriver driver, String title) {
        boolean isExists = false;
        String originWindowHandler = driver.getWindowHandle();
        for (String handler : driver.getWindowHandles()) {
            String pageTitle = driver.switchTo().window(handler).getTitle();
            if (pageTitle.equals(title)) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            driver.switchTo().window(originWindowHandler);
        }
    }

    public static void closeIndicatedWindowUsingWindowHandler(WebDriver driver, String windowHandler) {
        driver.switchTo().window(windowHandler).close();
    }
}
