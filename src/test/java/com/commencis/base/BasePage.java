package com.commencis.base;

import com.commencis.logs.Logs;
import com.commencis.test.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
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

    public void scroll(By by) {
        TouchActions touchActions = new TouchActions(driver);
        WebElement element = findElement(by);
        Point point = element.getLocation();
        int x = point.getX();
        int y = point.getY();
        touchActions.scroll(x, y);
        touchActions.perform();
    }

    public void jsExecuterScroll() {
        // Create instance of Javascript executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Identify the WebElement which will appear after scrolling down
        js.executeScript("window.scrollBy(0,500)", "");
    }

    public void assertEquals(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText);
    }

    public void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    public void assertFail() {
        Assert.fail();
    }
}
