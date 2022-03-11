package com.commencis.base;

import com.commencis.logs.Logs;
import com.commencis.test.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage extends BaseTest {

    Logger logger = LogManager.getLogger(Logs.class.getName());

    public WebElement findElement(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElements(by);
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public void clickElement(By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by));
        action.click();
        action.build().perform();
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public void clear(By by) {
        findElement(by).clear();
    }

    public void clearBackSpace(By by) {
        WebElement element = findElement(by);
        while (!element.getAttribute("value").equals("")) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void wait(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public void screenShot(String text) {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        String date = dateFormat.format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/report/screenshot/" + text + "(" + date + ")" + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void assertEquals(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

    public void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    public void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public void assertEqualsInteger(String first, int second) {
        Assert.assertEquals(first, second);
    }

    public void assertFail() {
        Assert.fail();
    }
}
