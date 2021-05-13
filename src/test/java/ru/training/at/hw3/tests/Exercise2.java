package ru.training.at.hw3.tests;

import com.google.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.data.ConfigReader;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.MainPage;

public class Exercise2 extends BaseTest {

    @Inject
    private MainPage mainPage;

    @Inject
    private DifferentElementsPage differentElementsPage;

    @Test
    public void exercise2() {

        MainPage mainPage = new MainPage(getWebDriver());

        // 1.Open test site by URL
        mainPage.openMainPage();

        // 2. Assert Browser title
        Assert.assertEquals(mainPage.getTitle(), ConfigReader.getPropertyValue("pageTitle"));

        // 3. Perform login
        mainPage.loginUser(ConfigReader.getPropertyValue("name"),
                ConfigReader.getPropertyValue("password"));

        // 4. Assert Username is loggined
        Assert.assertEquals(mainPage.checkLoggedUser(),
                ConfigReader.getPropertyValue("fullNameUser"));

        DifferentElementsPage differentElementsPage = new DifferentElementsPage(getWebDriver());

        // 5. Open through the header menu Service -> Different Elements Page
        differentElementsPage.openPage();

        // 6. Select checkboxes
        differentElementsPage.setListCheckboxes(0);
        differentElementsPage.setListCheckboxes(2);

        // 7. Select radio
        differentElementsPage.setListRadio(3);

        // 8. Select in dropdown
        differentElementsPage.setDropDownColor(ConfigReader.getPropertyValue("color"));

        // 9. Assert that:
        // for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        Assert.assertNotNull(differentElementsPage
                .searchLogList(ConfigReader.getPropertyValue("waterCheckbox"), "true"));
        Assert.assertNotNull(differentElementsPage
                .searchLogList(ConfigReader.getPropertyValue("windCheckbox"), "true"));

        // for radio button there is a log row and value
        // is corresponded to the status of radio button
        Assert.assertNotNull(differentElementsPage
                .searchLogList(ConfigReader.getPropertyValue("metalRadio"),
                        ConfigReader.getPropertyValue("selenValueRadio")));

        // for dropdown there is a log row and value
        // is corresponded to the selected value
        Assert.assertNotNull(differentElementsPage
                .searchLogList(ConfigReader.getPropertyValue("colorLog"),
                        ConfigReader.getPropertyValue("color")));

        // 12. Close Browser
        //close();
    }
}
