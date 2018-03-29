package com.tsuna.reaper.jingdong.page;

import com.tsuna.reaper.jingdong.common.WebDriverConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisteredHomePage extends PageBase {

    @FindBy(how = How.LINK_TEXT, linkText = "我的京东")
    private WebElement myJingDongLabel;
    @FindBy(how = How.LINK_TEXT, linkText = "我的京豆")
    private WebElement myJingBeanAnchor;


    RegisteredHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public void hoverMyJingDongLabel() {
        Actions actionBuilder = new Actions(getWebDriver());
        actionBuilder.moveToElement(myJingDongLabel).pause(500).build().perform();
    }

    public MyJingBeanPage clickMyJingBeanAnchorAndForwardToMyJingBeanPage() {
        myJingBeanAnchor.click();
        new WebDriverWait(getWebDriver(), WebDriverConstants.DEFAULT_TIME_OUT_SECONDS).until(ExpectedConditions.titleIs("我的京豆-我的京东"));
        getWebDriver().navigate().forward();
        return new MyJingBeanPage(getWebDriver(), getWebDriver().getWindowHandle());
    }

}
