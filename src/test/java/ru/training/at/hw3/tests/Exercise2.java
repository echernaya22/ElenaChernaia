package ru.training.at.hw3.tests;

import com.google.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw3.data.ConfigReader;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.MainPage;

public class Exercise2 extends BaseTest {

    @Parameters({"color", "colorLog", "waterCheckbox", "windCheckbox", "metalRadio",
        "selenValueRadio", "pageTitle", "fullNameUser"})
    @Test
    public void exercise2(String color, String colorLog, String waterCheckbox,
                          String windCheckbox, String metalRadio, String selenValueRadio,
                          String pageTitle, String fullNameUser) {

        MainPage mainPage = new MainPage(getWebDriver());

        // 1.Open test site by URL
        mainPage.openMainPage();

        // 2. Assert Browser title
        Assert.assertEquals(mainPage.getTitle(), pageTitle);

        // 3. Perform login
        mainPage.loginUser(ConfigReader.getPropertyValue("name"),
                ConfigReader.getPropertyValue("password"));

        // 4. Assert Username is loggined
        Assert.assertEquals(mainPage.checkLoggedUser(), fullNameUser);

        DifferentElementsPage differentElementsPage = new DifferentElementsPage(getWebDriver());

        // 5. Open through the header menu Service -> Different Elements Page
        differentElementsPage.openPage();

        // 6. Select checkboxes
        differentElementsPage.setListCheckboxes(0);
        differentElementsPage.setListCheckboxes(2);

        // 7. Select radio
        differentElementsPage.setListRadio(3);

        // 8. Select in dropdown
        differentElementsPage.setDropDownColor(color);

        // 9. Assert that:
        // for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        Assert.assertTrue(differentElementsPage.searchLogList(waterCheckbox, "true")
                .isDisplayed());
        Assert.assertTrue(differentElementsPage.searchLogList(windCheckbox, "true")
                .isDisplayed());

        // for radio button there is a log row and value
        // is corresponded to the status of radio button
        Assert.assertTrue(differentElementsPage
                .searchLogList(metalRadio, selenValueRadio).isDisplayed());

        // for dropdown there is a log row and value
        // is corresponded to the selected value
        Assert.assertTrue(differentElementsPage.searchLogList(colorLog, color).isDisplayed());

        // 12. Close Browser
        //close();
    }
}
