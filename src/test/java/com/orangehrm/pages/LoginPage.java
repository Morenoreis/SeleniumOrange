package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By errorMessage = By.cssSelector(".oxd-alert-content-text");
    private final By requiredError = By.cssSelector(".oxd-input-field-error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillUsername(String username) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameInput));
        field.clear();
        field.sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(errorMessage))
                .getText();
    }

    public boolean isRequiredErrorVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(requiredError)) != null;
    }

    public boolean isDashboardVisible() {
        return wait.until(
                ExpectedConditions.urlContains("/dashboard")) != null;
    }
}