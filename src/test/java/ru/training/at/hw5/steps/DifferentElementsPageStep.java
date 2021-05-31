package ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ru.training.at.hw5.DifferentElementsPage;
import ru.training.at.hw5.context.TestContext;

import java.util.List;

public class DifferentElementsPageStep {

    DifferentElementsPage differentElementsPage = new DifferentElementsPage(TestContext
            .getInstance()
            .getTestObject(TestContext.WEB_DRIVER));

    @Given("I select checkbox Water with index {int}")
    public void selectWaterCheckbox(int index) {
        differentElementsPage.setListCheckboxes(index);
    }

    @Given("I select checkbox Wind with index {int}")
    public void selectWindCheckbox(int index) {
        differentElementsPage.setListCheckboxes(index);
    }

    @Given("I select radio Selen with index {int}")
    public void selectRadio(int index) {
        differentElementsPage.setListRadio(index);
    }

    @Given("I select {string} in dropdown")
    public void selectDropdown(String color) {
        differentElementsPage.setDropDownColor(color);
    }

    @Then("Log rows should contain following values:")
    public void logRowsShouldContainCorrectValues(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);

        for (List<String> columns : rows) {
            Assert.assertTrue(differentElementsPage.searchLogList(columns.get(0),
                    columns.get(1)).isDisplayed());
        }

    }


}
