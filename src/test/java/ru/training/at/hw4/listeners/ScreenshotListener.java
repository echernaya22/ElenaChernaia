package ru.training.at.hw4.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.hw3.driverutils.DriverManager;
import ru.training.at.hw4.utils.AttachmentUtils;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("EEE: onTestFailure.enter " + result.getName());
        WebDriver webDriver = DriverManager.driver;

        if (webDriver != null) {
            AttachmentUtils.attachPngImage(webDriver);
        }
        System.out.println("EEE: onTestFailure.exit");
    }

}
