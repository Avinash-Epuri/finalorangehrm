package com.pages;

import com.microsoft.playwright.Locator;

import com.microsoft.playwright.Page;

public class DeleteUserPage {

     private Page page;


    private final Locator deleteIcon;

    private final Locator confirmDeleteButton;

    private final Locator loadingSpinner;

    public DeleteUserPage(Page page) {

        this.page = page;

        deleteIcon = page.locator("//div[@role='rowgroup']//div[2]//div[1]//div[6]//div[1]//button[1]//i[1]").first();

        confirmDeleteButton = page.locator("//button[normalize-space()='Yes, Delete']");

        loadingSpinner = page.locator(".oxd-form-loader");

    }

    public void deleteUser() {

        deleteIcon.click();

        confirmDeleteButton.click();

    }

}


 
