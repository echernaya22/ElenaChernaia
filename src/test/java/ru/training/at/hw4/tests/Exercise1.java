package ru.training.at.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw4.steps.CommonSteps;
import ru.training.at.hw4.steps.MainPageSteps;

public class Exercise1 extends BaseTest {

    @Feature(value = "Testing jdi page")
    @Story(value = "Main page functionality")
    @Parameters({"pageTitle", "fullNameUser", "headerMenuFirstTab", "headerMenuSecondTab",
        "headerMenuThirdTab", "headerMenuForthTab", "imagesTextFirst", "imagesTextSecond",
        "imagesTextThird", "imagesTextForth", "leftMenuFirstTab", "leftMenuSecondTab",
        "leftMenuThirdTab", "leftMenuForthTab", "leftMenuFifthTab"})
    @Test
    public void exercise1(String pageTitle, String fullNameUser, String headerMenuFirstTab,
                          String headerMenuSecondTab, String headerMenuThirdTab,
                          String headerMenuForthTab, String imagesTextFirst,
                          String imagesTextSecond, String imagesTextThird, String imagesTextForth,
                          String leftMenuFirstTab, String leftMenuSecondTab,
                          String leftMenuThirdTab, String leftMenuForthTab,
                          String leftMenuFifthTab) {

        CommonSteps commSteps = new CommonSteps(getWebDriver());

        // 1.Open test site by URL
        commSteps.openPage();

        // 2. Assert Browser title
        commSteps.assertTitle(pageTitle);

        // 3. Perform login
        commSteps.performLogin();

        // 4. Assert Username is loggined
        commSteps.assertUserLoggined(fullNameUser);

        MainPageSteps mpSteps = new MainPageSteps(getWebDriver());

        // 5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        mpSteps.assertItemsNumber(4);
        mpSteps.assertItemsHaveProperText(headerMenuFirstTab, headerMenuSecondTab,
                headerMenuThirdTab, headerMenuForthTab);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        mpSteps.assertDisplayedImages(4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        mpSteps.assertNumberTextsUnderIcons(4);
        mpSteps.assertProperTextUnderIcons(imagesTextFirst, imagesTextSecond, imagesTextThird,
                imagesTextForth);

        // 8. Assert that there is the iframe with “Frame Button” exist
        mpSteps.assertFrameExists();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        mpSteps.switchToFrame();
        mpSteps.assertFrameButtonExists();

        // 10. Switch to original window back
        mpSteps.switchToDefaultWindow();

        // 11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        mpSteps.assertItemsInLeftSectionHaveProperText(leftMenuFirstTab, leftMenuSecondTab,
                leftMenuThirdTab, leftMenuForthTab, leftMenuFifthTab);

        // 12. Close browser
        //close();
    }
}
