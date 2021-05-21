package ru.training.at.hw5.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    protected final WebDriver driver;
    protected WebDriverWait wait;

    protected DriverManager(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(this.driver, this);
    }
}
