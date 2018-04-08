package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;

/**
 * A standard page which is also an 'inherited page',see {@link InheritedPage} and {@link PageBase}
 */
public abstract class AbstractInheritedPage extends PageBase implements InheritedPage {
    private String parentHandler;

    AbstractInheritedPage(WebDriver driver, String parentHandler) {
        super(driver);
        this.parentHandler = parentHandler;
    }

    protected void switchToParentWindow() {
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
