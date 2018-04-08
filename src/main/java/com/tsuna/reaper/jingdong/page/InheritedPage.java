package com.tsuna.reaper.jingdong.page;

/**
 * This interface indicates a page is opened by using another
 * link like <a href='xxxxxx' target='_blank'>xxxxx</a>.
 * In this way,the origin page which includes the link is
 * called parent page,and the new page is inherited page.
 */
public interface InheritedPage {

    String getParentWindowHandle();

    void closeParentWindow();
}
