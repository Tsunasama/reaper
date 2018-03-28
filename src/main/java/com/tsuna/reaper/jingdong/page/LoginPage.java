package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static String userName = "xxxxxxx";
    private static String passWord = "xxxxxxx";
    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, linkText = "账户登录")
    private WebElement loginAnchor;

    @FindBy(how = How.ID, id = "loginname")
    private WebElement userNameInput;

    @FindBy(how = How.ID, id = "nloginpwd")
    private WebElement passwordInput;

    @FindBy(how = How.ID, id = "loginsubmit")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAccountLoginAnchor() {
        loginAnchor.click();
    }

    public void inputUserName() {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void inputPassword() {
        passwordInput.clear();
        passwordInput.sendKeys(passWord);
    }

    public RegisteredHomePage clickLoginSubmitBtn() {
        loginButton.click();
        return new RegisteredHomePage(driver);
    }
}
