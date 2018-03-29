package com.tsuna.reaper.jingdong.page;

import com.tsuna.reaper.jingdong.common.WindowUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyJingBeanPage extends AbstractInheritedPage {
    private static final int DEFAULT_TIME_OUT_SECONDS = 10;

    @FindBy(how = How.LINK_TEXT, linkText = "去签到 >")
    private WebElement goToSignInBtn;

    MyJingBeanPage(WebDriver driver, String parentWindowHandler) {
        super(driver, parentWindowHandler);
        PageFactory.initElements(driver, this);
    }

    public SignInPage clickGoToSignInBtnAndForwardToSignInPage() {
        goToSignInBtn.click();
        String newWindowTitle = "【京东会员】京豆兑换、专享礼包、领优惠券等会员特权，尽在京东会员俱乐部（vip.jd.com）！";
        new WebDriverWait(getWebDriver(), DEFAULT_TIME_OUT_SECONDS).until(ExpectedConditions.titleIs(newWindowTitle));
        WindowUtil.switchToWindowUsingTitle(getWebDriver(), newWindowTitle);
        return new SignInPage(getWebDriver(), getWebDriver().getWindowHandle());
    }


}
