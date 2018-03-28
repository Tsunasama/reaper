package com.tsuna.reaper.jingdong.page;

import com.tsuna.reaper.jingdong.ChromeDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final String url = "https://www.jd.com";
    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, linkText = "登录")
    private WebElement login;

    public HomePage() {
        driver = ChromeDriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }

    public LoginPage clickLoginAncher() {
        login.click();
        return new LoginPage(driver);
    }

    public static void main(String... args) {
        HomePage page = new HomePage();
        page.load();
        LoginPage loginPage = page.clickLoginAncher();
        loginPage.clickAccountLoginAnchor();
        loginPage.inputUserName();
        loginPage.inputPassword();
        RegisteredHomePage registeredHomePage = loginPage.clickLoginSubmitBtn();
        registeredHomePage.hoverMyJingDongLabel();
        registeredHomePage.clickMyJingBeanAnchor();
        MyJingBeanPage myJingBeanPage = registeredHomePage.forWardToMyJingBeanPage();
        registeredHomePage.close();
        SignInPage signInPage = myJingBeanPage.clickGoToSignInBtnAndForwardToSignInPage();
        signInPage.clickSignInAnchor();
        signInPage.backwardToMyJingBeanPage();
        signInPage.close();
    }
}
