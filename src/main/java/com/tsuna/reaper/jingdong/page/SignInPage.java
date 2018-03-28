package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage {
    private WebDriver driver;

    @FindBy(how = How.CSS, css = "a.sign-in")
    private WebElement signInAnchor;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInAnchor() {
        signInAnchor.click();
    }

    public void backwardToMyJingBeanPage() {
        driver.navigate().back();
    }

    public void close() {
        driver.close();
    }
}
