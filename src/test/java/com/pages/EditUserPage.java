package com.pages;

import com.microsoft.playwright.Locator;

import com.microsoft.playwright.Page;

public class EditUserPage {

    private Page page;

    private final Locator editIcon;

    private final Locator statusDropdown;

    private final Locator saveButton;

    private final Locator loadingSpinner;

    public EditUserPage(Page page) {

        this.page = page;

        editIcon = page.locator("//i[@class='oxd-icon bi-pencil-fill']").first();

        statusDropdown = page.locator("//label[text()='Status']/following::div[1]//div[contains(@class,'oxd-select-text')]").first();

        saveButton = page.locator("//button[normalize-space()='Save']");

        loadingSpinner = page.locator(".oxd-form-loader");

    }

    public void editUserStatus(String newStatus) {

        editIcon.click();


        statusDropdown.click();

        Locator newStatusOption = page.locator("//div[@role='listbox']//span[text()='" + newStatus + "']");

        newStatusOption.click();

        saveButton.click();

    }

}

 

