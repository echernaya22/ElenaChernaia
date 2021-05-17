package ru.training.at.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw3.data.ConfigReader;


import java.util.List;

public class MainPage {
    private WebDriver webDriver;


    @FindBy(css = "ul.navbar-right")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(css = ".uui-navigation.nav.navbar-nav > li > a")
    private List<WebElement> headerMenuList;
    @FindBy(css = "span.icons-benefit")
    private List<WebElement> imagesCounterList;
    @FindBy(css = "span.benefit-txt")
    private List<WebElement> imagesTextList;
    @FindBy(id = "frame")
    private WebElement frameButton;
    @FindBy(id = "frame-button")
    private WebElement frameButtonInsideFrame;
    @FindBy(css = ".sidebar-menu.left > li > a > span")
    private List<WebElement> leftSectionMenuList;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openMainPage() {
        webDriver.navigate().to(ConfigReader.getPropertyValue("path"));
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void loginUser(String name, String password) {
        userIcon.click();
        nameField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String checkLoggedUser() {
        return userName.getText();
    }

    public String getHeaderMenuText(int index) {
        return headerMenuList.get(index).getText();
    }

    public int getCountOfImagesList() {
        return imagesCounterList.size();
    }

    public String getImagesText(int index) {
        return imagesTextList.get(index).getText();
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public void switchToFrame() {
        WebElement frame = getFrameButton();
        webDriver.switchTo().frame(frame);
    }

    public void switchToDefaultContent() {
        webDriver.switchTo().defaultContent();
    }

    public WebElement getFrameButtonInsideFrame() {
        return frameButtonInsideFrame;
    }

    public String getLeftSectionMenuText(int index) {
        return leftSectionMenuList.get(index).getText();
    }

}
