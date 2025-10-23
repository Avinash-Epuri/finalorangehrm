package com.tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Page;
import com.pages.AdminPage;
import com.pages.DeleteUserPage;
import com.pages.EditUserPage;
import com.pages.Login;
import com.pages.SearchPage;
import com.utilities.TestBase;

public class LoginTest extends TestBase {
    Page page;

    @Test
    public void testValidLogin() throws InterruptedException {
        // Initialize Playwright Page from TestBase
    	page = getPage(); // Assuming getPage() is defined in TestBase to return a valid Page instance

        // Step 1: Login
        Login loginPage = new Login(page);
        loginPage.login("Admin", "admin123");

        // Step 2: Add a new user
        AdminPage adminPage = new AdminPage(page);
        String employeeName = "joker john selvam";
        String newUsername = "Avinash333";
        String newPassword = "Jellyfish@123";
        String confirmPassword = "Jellyfish@123";
        String userRole = "Admin";
        String status = "Enabled";
        adminPage.admininput(employeeName, newUsername, newPassword, confirmPassword, userRole, status);

        // Step 3: Search for the user
        SearchPage searchPage = new SearchPage(page);
        searchPage.searchUser(newUsername, userRole, status);

        // Step 4: Edit user status
        EditUserPage editUserPage = new EditUserPage(page);
        editUserPage.editUserStatus("Disabled");

        // Step 5: Verify updated status
        searchPage.searchUser(newUsername, userRole, "Disabled");

        // Step 6: Delete the user
        DeleteUserPage dl = new DeleteUserPage(page);
        dl.deleteUser();
    }
}