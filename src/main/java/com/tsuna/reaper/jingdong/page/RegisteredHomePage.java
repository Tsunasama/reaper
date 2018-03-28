package com.tsuna.reaper.jingdong.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisteredHomePage {
    private static final int DEFAULT_TIME_OUT_SECONDS = 10;

    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, linkText = "我的京东")
    private WebElement myJingDongLabel;
    @FindBy(how = How.LINK_TEXT, linkText = "我的京豆")
    private WebElement myJingBeanAnchor;


    public RegisteredHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverMyJingDongLabel() {
        Actions actionBuilder = new Actions(driver);
        actionBuilder.moveToElement(myJingDongLabel).pause(500);
        actionBuilder.build();
        actionBuilder.perform();
    }

    public void clickMyJingBeanAnchor() {
        myJingBeanAnchor.click();
    }

    public MyJingBeanPage forWardToMyJingBeanPage() {
        new WebDriverWait(driver, DEFAULT_TIME_OUT_SECONDS).until(ExpectedConditions.titleIs("我的京豆-我的京东"));
        driver.navigate().forward();
        return new MyJingBeanPage(driver);
    }

    public void close() {
        driver.close();
    }
}
