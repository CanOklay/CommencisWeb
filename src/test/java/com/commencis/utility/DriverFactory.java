package com.commencis.utility;

import com.commencis.config.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    //protected static RemoteWebDriver driver; //for docker
    ConfigFileReader configFileReader = new ConfigFileReader();
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;

    public void operaDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        OperaOptions options = new OperaOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translate");
        capabilities.setCapability(OperaOptions.CAPABILITY, options);
        //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
    }

    public void firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translate");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
    }

    public void chromeDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translate");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
    }

    public void remoteWebDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translate");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
    }
}
