package com.orangehrm.tests;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PimPage;
import com.orangehrm.pages.SideMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PimTest extends BaseTest {

    private LoginPage loginPage;
    private SideMenuPage sideMenuPage;
    private PimPage pimPage;

    @BeforeMethod
    public void login() {
        loginPage = new LoginPage(driver);
        sideMenuPage = new SideMenuPage(driver);
        pimPage = new PimPage(driver);
        loginPage.login("Admin", "admin123");
        sideMenuPage.clickMenu("PIM");
    }

    @Test(description = "Should access PIM module successfully")
    public void testAccessPimModule() {
        Assert.assertTrue(pimPage.isOnPimPage());
    }

    @Test(description = "Should display employee list with records")
    public void testEmployeeListHasRecords() {
        Assert.assertTrue(pimPage.getTableRowCount() > 0);
    }

    @Test(description = "Should display table headers correctly")
    public void testTableHeadersVisible() {
        Assert.assertTrue(pimPage.isTableHeaderVisible());
        String headers = pimPage.getTableHeaderText();
        Assert.assertTrue(headers.contains("Id"));
        Assert.assertTrue(headers.contains("Last Name"));
    }

    @Test(description = "Should find employee by name")
    public void testSearchEmployeeByName() {
        pimPage.searchByName("John");
        Assert.assertTrue(pimPage.getTableRowCount() > 0);
    }
}