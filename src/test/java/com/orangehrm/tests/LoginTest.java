package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Valid login should redirect to dashboard")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        Assert.assertTrue(loginPage.isDashboardVisible(),
                "Dashboard should be visible after login");
    }

    @Test(description = "Invalid login should show error message")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "wrongpassword");
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Invalid credentials"),
                "Error message should be displayed");
    }

    @Test(description = "Empty fields should show required error")
    public void testEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Assert.assertTrue(loginPage.isRequiredErrorVisible(),
                "Required error message should appear");
    }
}