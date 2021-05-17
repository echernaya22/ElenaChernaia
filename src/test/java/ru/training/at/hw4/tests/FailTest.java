package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw4.listeners.ScreenshotListener;
import ru.training.at.hw4.steps.CommonSteps;
import ru.training.at.hw4.steps.DiffElementsPageSteps;
import ru.training.at.hw4.utils.AttachmentUtils;

public class FailTest extends BaseTest {

    @Feature(value = "Testing jdi page")
    @Story(value = "Fail main page functionality")
    @Parameters({"color", "colorLog", "wrongColor"})
    @Test
    public void failTest(String color, String colorLog, String wrongColor) {

        CommonSteps commSteps = new CommonSteps(getWebDriver());
        AttachmentUtils.attachPngImage(getWebDriver());

        // 1.Open test site by URL
        commSteps.openPage();

        // 3. Perform login
        commSteps.performLogin();

        DiffElementsPageSteps deSteps = new DiffElementsPageSteps(getWebDriver());

        // 5. Open through the header menu Service -> Different Elements Page
        deSteps.openPage();

        // 6. Select in dropdown
        deSteps.setDropDownColor(color);

        deSteps.assertSearchLogList(colorLog, wrongColor);

    }
}
