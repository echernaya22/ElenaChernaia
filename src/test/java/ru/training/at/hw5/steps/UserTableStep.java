package ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import ru.training.at.hw5.UserTablePage;
import ru.training.at.hw5.context.TestContext;
import org.assertj.core.api.ListAssert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserTableStep {

    UserTablePage userTablePage = new UserTablePage(TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER));

    @Then("{string} page should be opened")
    public void assertUserPageIsOpened(String title) {
        Assert.assertEquals(userTablePage.getTitle(), title);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertNumberDropdownsAreDisplayed(int number) {
        Assert.assertEquals(userTablePage.getNumberTypeListDropdown().size(), number);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertNumberUsernamesList(int number) {
        Assert.assertEquals(userTablePage.getUsernameList().size(), number);
    }

    @Then("{int} Description texts under images should be displayed on Users Table "
            + "on User Table Page")
    public void assertTextsUnderImages(int number) {
        Assert.assertEquals(userTablePage.getDescriptionTextList().size(), number);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxesAreDisplayed(int number) {
        Assert.assertEquals(userTablePage.getCheckboxList().size(), number);
    }

    @Then("User table should contain following values:")
    public void assertUserTableContainsCorrectValues(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < table.size(); i++) {

            Assert.assertEquals(userTablePage.getNumberList(i),
                    table.get(i).get("Number"));

            Assert.assertEquals(userTablePage.getUsernameList().get(i).getText(),
                    table.get(i).get("User"));

            Assert.assertEquals(userTablePage
                            .getDescriptionTextList().get(i).getText().replace("\n", " "),
                    table.get(i).get("Description"));
        }
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void assertDropdownListContainsCorrectValues(String name, DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        userTablePage.getDropdownListByUsername(name);
        for (int i = 0; i < rows.size(); i++) {
            Assert.assertEquals(userTablePage.getDropdownListByUsername(name).get(i),
                    rows.get(i).get("Dropdown Values"));
        }

    }

    @When("I select 'vip' checkbox for {string}")
    public void selectUserCheckbox(String name) {
        userTablePage.setCheckboxByName(name);
    }

    @Then("{int} log row has {string} text in log section")
    public void assertLogRowAfterSelectingCheckbox(int index, String logRow) {
        Assertions.assertThat(logRow).contains(userTablePage.getLogByNumber(index).getText());
    }
}
