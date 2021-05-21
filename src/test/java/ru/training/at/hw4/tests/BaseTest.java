package ru.training.at.hw4.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.training.at.hw4.driverutils.DriverManager;

public class BaseTest {

    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        webDriver = DriverManager.setupDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void deleteCookies() {
        webDriver.manage().deleteAllCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
