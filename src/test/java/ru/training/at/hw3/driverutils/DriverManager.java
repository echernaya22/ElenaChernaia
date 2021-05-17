package ru.training.at.hw3.driverutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class DriverManager implements DriverInterface {
    public static WebDriver driver;

    public WebDriver setupDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts()
                    .implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
