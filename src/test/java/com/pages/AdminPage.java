package com.pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
public class AdminPage {
    private Page page;
    private final Locator adminTab;
    private final Locator addButton;
    private final Locator userRoleDropdown;
    private final Locator employeeNameInput;
    private final Locator usernameInput;
    private final Locator statusDropdown;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator saveButton;
    public AdminPage(Page page) {
        this.page = page;
        adminTab = page.locator("//span[text()='Admin']");
        addButton = page.locator("//button[normalize-space()='Add']");
        userRoleDropdown = page.locator("//label[text()='User Role']/following::div[1]//div[contains(@class,'oxd-select-text')]").first();
        employeeNameInput = page.locator("//input[@placeholder='Type for hints...']");
        usernameInput = page.locator("//label[text()='Username']/following::input[1]");
        statusDropdown = page.locator("//label[text()='Status']/following::div[1]//div[contains(@class,'oxd-select-text')]").first();
        passwordInput = page.locator("//label[text()='Password']/following::input[1]");
        confirmPasswordInput = page.locator("//label[text()='Confirm Password']/following::input[1]");
        saveButton = page.locator("//button[normalize-space()='Save']");
    }
    public void openAdmin() {
        adminTab.click();
    }
    public void clickAdd() {
        addButton.click();
        System.out.println("11");
    }

    public void fillUserDetails(String empName, String username,
                                 String password, String confirmPassword, String userRole, String status) {
    	System.out.println("12");
    	userRoleDropdown.click();
        page.locator("//div[@role='listbox']//span[text()='Admin']").click();
        employeeNameInput.fill(empName);
        page.locator("//div[@role='listbox']//span[contains(text(),'" + empName + "')]").click();
        usernameInput.fill(username);
        statusDropdown.click();
        page.locator("//div[@role='listbox']//span[text()='Enabled']").click();
        passwordInput.fill(password);
        confirmPasswordInput.fill(confirmPassword);
        saveButton.click();
    }
    public void admininput(String empName, String username,
                                 String password, String confirmPassword, String userRole, String status) {
    	openAdmin();
    	clickAdd();
    	fillUserDetails(empName, username,
                 password, confirmPassword,  userRole,  status);
    }
}