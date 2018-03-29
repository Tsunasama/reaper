package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractInheritedPage {

    @FindBy(how = How.CSS, css = "a.sign-in")
    private WebElement signInAnchor;

    SignInPage(WebDriver driver, String parentWindowHandler) {
        super(driver, parentWindowHandler);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void clickSignInAnchor() {
        signInAnchor.click();
    }

    public void backwardToMyJingBeanPage() {
        getWebDriver().navigate().back();
    }

}
