package com.utilities;
 
import com.microsoft.playwright.*;
import com.utilities.configuration;
 
import java.io.File;
import java.nio.file.Paths;
 
import org.testng.annotations.*;
 
public class TestBase {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
 
    protected String baseUrl;
    protected String userName;
    protected String password;
 
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browserName) {
        // ✅ Load config inside setup method
        baseUrl = configuration.readPropertyFileData("baseUrl", "config");
        userName = configuration.readPropertyFileData("userName", "config");
        password = configuration.readPropertyFileData("password", "config");
 
        System.out.println("Navigating to: " + baseUrl); // ✅ Debug print
 
        playwright = Playwright.create();
 
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(3000));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
 
        context = browser.newContext();
        page = context.newPage();
        page.navigate(baseUrl); // ✅ Now this will work
    }
    public static String captureScreenshot(String testName) {
        String path = "./target/screenshots/" + testName + ".png";
        new File("./target/screenshots").mkdirs(); // Ensure folder exists
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        return path;
    }
 
//    @AfterMethod
//    public void tearDown() {
//        if (page != null) page.close();
//        if (context != null) context.close();
//        if (browser != null) browser.close();
//        if (playwright != null) playwright.close();
//    }
 
    public Page getPage() {
        return page;
    }
}