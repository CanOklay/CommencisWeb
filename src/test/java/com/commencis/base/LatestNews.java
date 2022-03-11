package com.commencis.base;

import org.openqa.selenium.WebElement;

import java.util.List;

import static com.commencis.element.LatestNewsElements.*;

public class LatestNews extends BasePage {

    public void checkEachNewsHasAuthor() {
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

    public void checkEachNewsHasImage() {
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
}
