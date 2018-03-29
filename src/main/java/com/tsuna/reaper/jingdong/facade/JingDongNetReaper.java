package com.tsuna.reaper.jingdong.facade;

import com.tsuna.reaper.jingdong.common.ChromeDriverFactory;
import com.tsuna.reaper.jingdong.page.HomePage;
import com.tsuna.reaper.jingdong.page.LoginPage;
import com.tsuna.reaper.jingdong.page.MyJingBeanPage;
import com.tsuna.reaper.jingdong.page.RegisteredHomePage;
import org.openqa.selenium.WebDriver;

public class JingDongNetReaper {

    public HomePage loadHomePage() {
        WebDriver webDriver = ChromeDriverFactory.getDriver();
        HomePage homePage = new HomePage(webDriver);
        homePage.load();
        return homePage;
    }

    public RegisteredHomePage userLogin(HomePage homePage) {
        LoginPage loginPage = homePage.clickLoginAncher();
        loginPage.clickAccountLoginAnchor();
        loginPage.inputPassword();
        loginPage.inputUserName();
        return loginPage.clickLoginSubmitBtn();
    }

    public MyJingBeanPage goToMyJingBeanPage(RegisteredHomePage registeredHomePage) {
        registeredHomePage.hoverMyJingDongLabel();
        MyJingBeanPage myJingBeanPage = registeredHomePage.clickMyJingBeanAnchorAndForwardToMyJingBeanPage();
        registeredHomePage.close();
        return myJingBeanPage;
    }
}
