package com.tsuna.reaper.jingdong;

import com.tsuna.reaper.jingdong.facade.JingDongNetReaper;
import com.tsuna.reaper.jingdong.page.HomePage;
import com.tsuna.reaper.jingdong.page.MyJingBeanPage;
import com.tsuna.reaper.jingdong.page.RegisteredHomePage;

/**
 * Copyright 2018the origin author
 * User: Hibari Kyoya
 * Date: 2018/4/8
 * Time: 11:58
 */
public class Runner {
    public static void main(String... args) {
        JingDongNetReaper reaper = new JingDongNetReaper();
        HomePage homePage = reaper.loadHomePage();
        RegisteredHomePage registeredHomePage = reaper.userLogin(homePage);
        MyJingBeanPage myJingBeanPage = reaper.goToMyJingBeanPage(registeredHomePage);
    }
}
