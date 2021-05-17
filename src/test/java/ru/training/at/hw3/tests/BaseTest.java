package ru.training.at.hw3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.driverutils.DriverManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private SoftAssert softAssert;
    private WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    public void close() {
        webDriver.close();
    }
}
