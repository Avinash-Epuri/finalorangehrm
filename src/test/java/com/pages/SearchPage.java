package com.pages;
 
 
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
public class SearchPage {
    private Page page;
    private final Locator employeeNameInput;
    private final Locator usernameInput;
    private final Locator userRoleDropdown;
    private final Locator statusDropdown;
    private final Locator searchButton;
    private final Locator firstResultRow;
    private final Locator loadingSpinner;
    public SearchPage(Page page) {
        this.page = page;
        employeeNameInput = page.locator("//input[@placeholder='Type for hints...']");
        usernameInput = page.locator("//label[text()='Username']/following::input[1]");
        userRoleDropdown = page.locator("//label[text()='User Role']/following::div[1]//div[contains(@class,'oxd-select-text')]").first();
        statusDropdown = page.locator("//label[text()='Status']/following::div[1]//div[contains(@class,'oxd-select-text')]").first();
        searchButton = page.locator("//button[normalize-space()='Search']");
        loadingSpinner = page.locator(".oxd-form-loader");
        firstResultRow = page.locator("//div[@class='oxd-table-body']//div[contains(@class, 'oxd-table-card')]").first();
    }

    public void searchUser(String username, String role, String status) {

        usernameInput.fill(username);

        userRoleDropdown.click();
        page.locator("//div[@role='listbox']//span[text()='" + role + "']").click();

        statusDropdown.click();
        page.locator("//div[@role='listbox']//span[text()='" + status + "']").click();

        searchButton.click();

    }
}
