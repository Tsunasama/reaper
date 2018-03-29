package com.tsuna.reaper.jingdong.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

/**
 * An implementation of WebDriverEventListener
 */
public class CustomWebDriverListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.beforeChangeValueOf(element, driver, keysToSend);
        element.clear();
    }
}
