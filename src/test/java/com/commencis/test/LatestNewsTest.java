package com.commencis.test;

import com.commencis.base.LatestNews;
import org.testng.annotations.Test;

public class LatestNewsTest extends LatestNews {

    @Test
    public void verify_each_news_has_author_and_image() {
        verifyEachNewsHasAuthor();
        verifyEachNewsHasImage();
    }

    @Test
    public void click_one_of_the_news_verify_title_and_news_content() {
        clickOneOfNewsAndVerifyBrowserTitleIsTheSameWithNewsTitle();
        verifyLinksWithinNewsContent();
    }
}
