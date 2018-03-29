package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractInheritedPage extends PageBase implements InheritedPage {
    private String parentHandler;

    AbstractInheritedPage(WebDriver driver, String parentHandler) {
        super(driver);
        this.parentHandler = parentHandler;
    }

    void switchToParentWindow() {
        if (parentHandler == null)
            return;
        getWebDriver().switchTo().window(getParentWindowHandle());
    }

    @Override
    public String getParentWindowHandle() {
        return parentHandler;
    }

    @Override
    public void closeParentWindow() {
        switchToParentWindow();
        getWebDriver().close();
        switchToThisPage();
    }
}
