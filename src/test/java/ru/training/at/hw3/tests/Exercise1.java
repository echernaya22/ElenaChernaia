package ru.training.at.hw3.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw3.data.ConfigReader;
import ru.training.at.hw3.pages.MainPage;

public class Exercise1 extends BaseTest {

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

        MainPage mainPage = new MainPage(getWebDriver());

        // 1.Open test site by URL
        mainPage.openMainPage();

        // 2. Assert Browser title
        getSoftAssert().assertEquals(mainPage.getTitle(), pageTitle);

        // 3. Perform login
        mainPage.loginUser(ConfigReader.getPropertyValue("name"),
                ConfigReader.getPropertyValue("password"));

        // 4. Assert Username is loggined
        getSoftAssert().assertEquals(mainPage.checkLoggedUser(), fullNameUser);

        // 5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        getSoftAssert().assertEquals(mainPage.getHeaderMenuText(0), headerMenuFirstTab);
        getSoftAssert().assertEquals(mainPage.getHeaderMenuText(1), headerMenuSecondTab);
        getSoftAssert().assertEquals(mainPage.getHeaderMenuText(2), headerMenuThirdTab);
        getSoftAssert().assertEquals(mainPage.getHeaderMenuText(3), headerMenuForthTab);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        getSoftAssert().assertEquals(mainPage.getCountOfImagesList(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        getSoftAssert().assertEquals(mainPage.getImagesText(0), imagesTextFirst);
        getSoftAssert().assertEquals(mainPage.getImagesText(1), imagesTextSecond);
        getSoftAssert().assertEquals(mainPage.getImagesText(2), imagesTextThird);
        getSoftAssert().assertEquals(mainPage.getImagesText(3), imagesTextForth);

        // 8. Assert that there is the iframe with “Frame Button” exist
        getSoftAssert().assertNotNull(mainPage.getFrameButton());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        mainPage.switchToFrame();
        getSoftAssert().assertNotNull(mainPage.getFrameButtonInsideFrame());

        // 10. Switch to original window back
        mainPage.switchToDefaultContent();

        // 11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        getSoftAssert().assertEquals(mainPage.getLeftSectionMenuText(0), leftMenuFirstTab);
        getSoftAssert().assertEquals(mainPage.getLeftSectionMenuText(1), leftMenuSecondTab);
        getSoftAssert().assertEquals(mainPage.getLeftSectionMenuText(2), leftMenuThirdTab);
        getSoftAssert().assertEquals(mainPage.getLeftSectionMenuText(3), leftMenuForthTab);
        getSoftAssert().assertEquals(mainPage.getLeftSectionMenuText(4), leftMenuFifthTab);

        // 12. Close browser
        //close();
    }
}
