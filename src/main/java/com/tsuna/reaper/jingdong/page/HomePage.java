package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {
    private final String url = "https://www.jd.com";

    @FindBy(how = How.LINK_TEXT, linkText = "登录")
    private WebElement login;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void load() {
        getWebDriver().get(url);
    }

    public void close() {
        getWebDriver().close();
    }

    public LoginPage clickLoginAncher() {
        login.click();
        return new LoginPage(getWebDriver());
    }
}
