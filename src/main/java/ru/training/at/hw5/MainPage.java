package ru.training.at.hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.component.DriverManager;
import ru.training.at.hw5.data.ConfigReader;

public class MainPage extends DriverManager {

    @FindBy(css = "ul.navbar-right")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage() {
        driver.navigate().to(ConfigReader.getPropertyValue("path"));
    }

    public void loginUser() {
        getUserIcon().click();
        getNameField().sendKeys(ConfigReader.getPropertyValue("name"));
        getPasswordField().sendKeys(ConfigReader.getPropertyValue("password"));
        getLoginButton().click();
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getUserIcon() {
        return userIcon;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
