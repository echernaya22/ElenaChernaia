package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import ru.training.at.hw5.MainPage;
import ru.training.at.hw5.component.HeaderComponent;
import ru.training.at.hw5.context.TestContext;

public class CommonStep {

    MainPage mainPage = new MainPage(TestContext
            .getInstance()
            .getTestObject(TestContext.WEB_DRIVER));

    HeaderComponent headerComponent = new HeaderComponent(TestContext
            .getInstance()
            .getTestObject(TestContext.WEB_DRIVER));

    @Given("I open JDI GitHub site")
    public void openMainPage() {
        mainPage.openMainPage();
    }

    @Given("I login as user Roman Iovlev")
    public void login() {
        mainPage.loginUser();
    }

    @When("I click on {string} button in Header")
    public void clickOnServiceButton(String value) {
        headerComponent.clickHeaderMenuButtonByValue(value);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnUserTableButton(String value) {
        headerComponent.clickDropdownHeaderMenuByValue(value);
    }

}
