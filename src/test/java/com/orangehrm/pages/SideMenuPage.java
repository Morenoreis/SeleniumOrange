package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SideMenuPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By menuItems = By.cssSelector(
            ".oxd-sidepanel-body a.oxd-main-menu-item");

    public SideMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickMenu(String menuName) {
        List<WebElement> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItems));
        items.stream()
                .filter(item -> item.getText().trim().equals(menuName))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public boolean isMenuItemVisible(String menuName) {
        List<WebElement> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(menuItems));
        return items.stream()
                .anyMatch(item -> item.getText().trim().equals(menuName));
    }
}