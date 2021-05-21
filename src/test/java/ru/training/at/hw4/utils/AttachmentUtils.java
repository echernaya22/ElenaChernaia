package ru.training.at.hw4.utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@UtilityClass
public class AttachmentUtils {

    @Attachment(type = "image/png", value = "screenshot")
    public byte[] attachPngImage(WebDriver webDriver) {
        return  ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}