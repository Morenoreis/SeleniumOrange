package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.SideMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    private LoginPage loginPage;
    private SideMenuPage sideMenuPage;
    private AdminPage adminPage;

    @BeforeMethod
    public void login() {
        loginPage = new LoginPage(driver);
        sideMenuPage = new SideMenuPage(driver);
        adminPage = new AdminPage(driver);
        loginPage.login("Admin", "admin123");
        sideMenuPage.clickMenu("Admin");
    }

    @Test(description = "Should access Admin module successfully")
    public void testAccessAdminModule() {
        Assert.assertTrue(adminPage.isOnAdminPage());
    }

    @Test(description = "Should display table headers correctly")
    public void testTableHeadersVisible() {
        Assert.assertTrue(adminPage.isTableHeaderVisible());
        String headers = adminPage.getTableHeaderText();
        Assert.assertTrue(headers.contains("Username"));
        Assert.assertTrue(headers.contains("User Role"));
    }

    @Test(description = "Should find existing user in search")
    public void testSearchExistingUser() {
        adminPage.searchByUsername("Admin");
        Assert.assertTrue(adminPage.getTableRowCount() > 0);
    }

    @Test(description = "Should show No Records Found for invalid user")
    public void testSearchNonExistingUser() {
        adminPage.searchByUsername("usuarioinexistente999");
        Assert.assertTrue(adminPage.isNoRecordsFoundVisible());
    }
}