package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyJingBeanPage {
    private static final int DEFAULT_TIME_OUT_SECONDS = 10;

    @FindBy(how = How.LINK_TEXT, linkText = "去签到 >")
    private WebElement goToSignInBtn;

    private WebDriver driver;

    public MyJingBeanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignInPage clickGoToSignInBtnAndForwardToSignInPage() {
        goToSignInBtn.click();
        new WebDriverWait(driver, DEFAULT_TIME_OUT_SECONDS).until(ExpectedConditions.titleIs(
                "【京东会员】京豆兑换、专享礼包、领优惠券等会员特权，尽在京东会员俱乐部（vip.jd.com）！"
        ));
        driver.navigate().forward();
        return new SignInPage(driver);
    }


}
