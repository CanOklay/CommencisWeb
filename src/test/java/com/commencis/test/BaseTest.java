package com.commencis.test;

import com.commencis.config.ConfigFileReader;
import com.commencis.utility.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest extends DriverFactory {

    ConfigFileReader configFileReader = new ConfigFileReader();

    @BeforeMethod
    public void setup() throws MalformedURLException {
        if (configFileReader.getEnv().equals("local")) {
            if (configFileReader.getBrowser().equals("opera")) {
                operaDriver();
            } else if (configFileReader.getBrowser().equalsIgnoreCase("firefox")) {
                firefoxDriver();
            } else {
                chromeDriver();
            }
        } else {
            remoteWebDriver();
        }
        driver.navigate().to(configFileReader.getBaseUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicityWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configFileReader.getPageLoadTimeout()));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configFileReader.getWebDriverWait()));
    }

    @Test
    public void go() {

    }

    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
