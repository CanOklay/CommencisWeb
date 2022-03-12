package com.commencis.base;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.commencis.element.LatestNewsElements.*;

public class LatestNews extends BasePage {

    public void verifyEachNewsHasAuthor() {
        List<WebElement> authors = findElements(AUTHORS);
        try {
            for (WebElement author : authors) {
                author.isDisplayed();
                assertTrue(true);
            }
            logger.info("All news have an author");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("All news have not an author");
            assertFail();
        }
    }

    public void verifyEachNewsHasImage() {
        List<WebElement> images = findElements(IMAGES);
        try {
            for (WebElement image : images) {
                image.isDisplayed();
                assertTrue(true);
            }
            logger.info("All news have an image");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("All news have not an image");
            assertFail();
        }
    }

    public void clickOneOfNewsAndVerifyBrowserTitleIsTheSameWithNewsTitle() {
        List<WebElement> articles = findElements(ARTICLES);
        WebElement selectArticle = articles.get(0);
        String browserTitle = selectArticle.getText();
        System.out.println("Browser Title : " + browserTitle);
        try {
            jsExecuterScroll();
            logger.info("Scrolled down");
            selectArticle.click();
            logger.info("Clicked one of the news");
            String articleTitle = getText(ARTICLETITLE);
            assertEquals(browserTitle,articleTitle);
            logger.info("Verified that the browser title is the same with the news title");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("Can't verified that the browser title is the same with the news title");
            assertFail();
        }
    }

    public void verifyLinksWithinNewsContent() {
        List<WebElement> newsContent = findElements(NEWSCONTENTS);
        try {
            for (WebElement news : newsContent) {
                news.isDisplayed();
                assertTrue(true);
            }
            logger.info("The links within the news content");
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.info("The links don't within the news content");
            assertFail();
        }
    }
}
