package com.orangehrm.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL =
            "https://opensource-demo.orangehrmlive.com/web";

    @BeforeMethod
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--silent");
        options.addArguments("--log-level=3");

        boolean isCI = System.getenv("CI") != null;
        if (isCI) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        } else {
            options.addArguments("--start-maximized");
        }

        driver = new ChromeDriver(options);
        driver.get(BASE_URL + "/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
