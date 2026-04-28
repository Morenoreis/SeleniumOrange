package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.SideMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    private LoginPage loginPage;
    private SideMenuPage sideMenuPage;

    @BeforeMethod
    public void login() {
        loginPage = new LoginPage(driver);
        sideMenuPage = new SideMenuPage(driver);
        loginPage.login("Admin", "admin123");
    }

    @Test(description = "Should display all main menu items")
    public void testMainMenuItemsVisible() {
        Assert.assertTrue(sideMenuPage.isMenuItemVisible("Admin"));
        Assert.assertTrue(sideMenuPage.isMenuItemVisible("PIM"));
        Assert.assertTrue(sideMenuPage.isMenuItemVisible("Leave"));
        Assert.assertTrue(sideMenuPage.isMenuItemVisible("Time"));
        Assert.assertTrue(sideMenuPage.isMenuItemVisible("Recruitment"));
    }

    @Test(description = "Should navigate to Admin module")
    public void testNavigateToAdmin() {
        sideMenuPage.clickMenu("Admin");
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin"));
    }

    @Test(description = "Should navigate to PIM module")
    public void testNavigateToPim() {
        sideMenuPage.clickMenu("PIM");
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim"));
    }

    @Test(description = "Should navigate to Leave module")
    public void testNavigateToLeave() {
        sideMenuPage.clickMenu("Leave");
        Assert.assertTrue(driver.getCurrentUrl().contains("/leave"));
    }
}