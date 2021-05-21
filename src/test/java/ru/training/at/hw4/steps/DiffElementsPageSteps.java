package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw4.pages.DifferentElementsPage;

public class DiffElementsPageSteps {
    DifferentElementsPage differentElementsPage;

    public DiffElementsPageSteps(WebDriver webDriver) {
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openPage() {
        differentElementsPage.openPage();
    }

    @Step("Select checkboxes")
    public void setListCheckboxes(int index) {
        differentElementsPage.setListCheckboxes(index);
    }

    @Step("Select radio")
    public void setListRadio(int index) {
        differentElementsPage.setListRadio(index);
    }

    @Step("Select in dropdown")
    public void setDropDownColor(String color) {
        differentElementsPage.setDropDownColor(color);
    }

    @Step("Assert that for each checkbox, radio, dropdown there is an individual log row"
            + " and value is corresponded to the status of checkbox")
    public void assertSearchLogList(String buttonType, String value) {
        Assert.assertTrue(differentElementsPage.searchLogList(buttonType, value).isDisplayed());
    }
}
