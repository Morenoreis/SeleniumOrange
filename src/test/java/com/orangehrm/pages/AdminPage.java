package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AdminPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By searchUsernameInput = By.cssSelector(
            ".oxd-form .oxd-input-group:first-child input.oxd-input");
    private final By searchButton = By.cssSelector(
            "button[type='submit']");
    private final By tableRows = By.cssSelector(
            ".oxd-table-body .oxd-table-row");
    private final By tableHeader = By.cssSelector(
            ".oxd-table-header");

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOnAdminPage() {
        return wait.until(ExpectedConditions
                .urlContains("/admin/viewSystemUsers")) != null;
    }

    public void searchByUsername(String username) {
        WebElement input = wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchUsernameInput));
        input.clear();
        input.sendKeys(username);
        driver.findElement(searchButton).click();
        try { Thread.sleep(1500); } catch (InterruptedException e) {}
    }

    public int getTableRowCount() {
        return driver.findElements(tableRows).size();
    }

    public boolean isNoRecordsFoundVisible() {
        try {
            Thread.sleep(1000);
            List<WebElement> allElements = driver.findElements(
                    By.xpath("//*[contains(text(),'No Records Found')]"));
            if (!allElements.isEmpty()) return true;

            List<WebElement> tableBody = driver.findElements(tableRows);
            return tableBody.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTableHeaderVisible() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(tableHeader)) != null;
    }

    public String getTableHeaderText() {
        return driver.findElement(tableHeader).getText();
    }
}