package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.data.ConfigReader;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.MainPage;



public class CommonSteps {
    MainPage mainPage;
    DifferentElementsPage differentElementsPage;
    SoftAssert softAssert;

    public CommonSteps(WebDriver webDriver) {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        softAssert = new SoftAssert();
    }

    @Step("Open main page")
    public void openPage() {
        mainPage.openMainPage();
    }

    @Step("Assert browser title")
    public void assertTitle(String pageTitle) {
        softAssert.assertEquals(mainPage.getTitle(), pageTitle);
    }

    @Step("Perform login")
    public void performLogin() {
        mainPage.loginUser(ConfigReader.getPropertyValue("name"),
                ConfigReader.getPropertyValue("password"));
    }

    @Step("Assert user is loggined")
    public void assertUserLoggined(String fullNameUser) {
        softAssert.assertEquals(mainPage.checkLoggedUser(), fullNameUser);
    }
}
