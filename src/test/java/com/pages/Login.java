package com.pages;
 
import com.microsoft.playwright.Page;
 
public class Login{
    private Page page;
 
    private final String usernameInput = "//input[@placeholder='Username']";
    private final String passwordInput = "//input[@placeholder='Password']";
    private final String loginButton = "//button[@type='submit']";
 
    public Login(Page page) {
        this.page = page;
    }
 
    public void enterUsername(String username) {
        page.locator(usernameInput).fill(username);
    }
 
    public void enterPassword(String password) {
        page.locator(passwordInput).fill(password);
    }
 
    public void clickLogin() {
        page.locator(loginButton).click();
        // Wait for a selector indicating successful login, e.g. Admin tab visible
        page.waitForSelector("//span[text()='Admin']", new Page.WaitForSelectorOptions().setTimeout(5000));
    }
 
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
 
 