package com.tsuna.reaper.jingdong.page;

import com.tsuna.reaper.jingdong.common.WebDriverConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void enableMyJingBeanAnchor() {
        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        executor.executeScript("document.getElementById('ttbar-myjd').lastChild.style.display='block'");
    }

    public MyJingBeanPage clickMyJingBeanAnchor() {
        myJingBeanAnchor.click();
        new WebDriverWait(getWebDriver(), WebDriverConstants.DEFAULT_TIME_OUT_SECONDS).until(ExpectedConditions.titleIs("我的京豆-我的京东"));
        return new MyJingBeanPage(getWebDriver(), getWebDriver().getWindowHandle());
    }

}
