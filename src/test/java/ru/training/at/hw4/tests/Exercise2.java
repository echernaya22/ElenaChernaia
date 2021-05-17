package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw4.steps.CommonSteps;
import ru.training.at.hw4.steps.DiffElementsPageSteps;

public class Exercise2 extends BaseTest {

    @Feature(value = "Testing jdi page")
    @Story(value = "Different elements page functionality")
    @Parameters({"color", "colorLog", "waterCheckbox", "windCheckbox", "metalRadio",
        "selenValueRadio", "pageTitle", "fullNameUser"})
    @Test
    public void exercise2(String color, String colorLog, String waterCheckbox,
                          String windCheckbox, String metalRadio, String selenValueRadio,
                          String pageTitle, String fullNameUser) {

        CommonSteps commSteps = new CommonSteps(getWebDriver());

        // 1.Open test site by URL
        commSteps.openPage();

        // 2. Assert Browser title
        commSteps.assertTitle(pageTitle);

        // 3. Perform login
        commSteps.performLogin();

        // 4. Assert Username is loggined
        commSteps.assertUserLoggined(fullNameUser);

        DiffElementsPageSteps deSteps = new DiffElementsPageSteps(getWebDriver());

        // 5. Open through the header menu Service -> Different Elements Page
        deSteps.openPage();

        // 6. Select checkboxes
        deSteps.setListCheckboxes(0);
        deSteps.setListCheckboxes(2);

        // 7. Select radio
        deSteps.setListRadio(3);

        // 8. Select in dropdown
        deSteps.setDropDownColor(color);

        // 9. Assert that:
        // for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        deSteps.assertSearchLogList(waterCheckbox, "true");
        deSteps.assertSearchLogList(windCheckbox, "true");

        // for radio button there is a log row and value
        // is corresponded to the status of radio button
        deSteps.assertSearchLogList(metalRadio, selenValueRadio);

        // for dropdown there is a log row and value
        // is corresponded to the selected value
        deSteps.assertSearchLogList(colorLog, color);

        // 12. Close Browser
        //close();
    }
}
