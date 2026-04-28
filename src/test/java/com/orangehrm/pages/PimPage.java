package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PimPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By tableRows = By.cssSelector(
            ".oxd-table-body .oxd-table-row");
    private final By tableHeader = By.cssSelector(
            ".oxd-table-header");
    private final By searchNameInput = By.cssSelector(
            ".oxd-form .oxd-autocomplete-text-input input");
    private final By searchButton = By.cssSelector(
            "button[type='submit']");

    public PimPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isOnPimPage() {
        return wait.until(ExpectedConditions
                .urlContains("/pim/viewEmployeeList")) != null;
    }

    public int getTableRowCount() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(tableRows));
        return driver.findElements(tableRows).size();
    }

    public String getTableHeaderText() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(tableHeader)).getText();
    }

    public void searchByName(String name) {
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(searchNameInput))
                .sendKeys(name);
        driver.findElement(searchButton).click();
    }

    public boolean isTableHeaderVisible() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(tableHeader)) != null;
    }
}