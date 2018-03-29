package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {
    private final String userName = "";
    private final String passWord = "";

    @FindBy(how = How.LINK_TEXT, linkText = "账户登录")
    private WebElement loginAnchor;

    @FindBy(how = How.ID, id = "loginname")
    private WebElement userNameInput;

    @FindBy(how = How.ID, id = "nloginpwd")
    private WebElement passwordInput;

    @FindBy(how = How.ID, id = "loginsubmit")
    private WebElement loginButton;

    LoginPage(WebDriver driver) {
        super(driver);
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
        return new RegisteredHomePage(getWebDriver());
    }
}
