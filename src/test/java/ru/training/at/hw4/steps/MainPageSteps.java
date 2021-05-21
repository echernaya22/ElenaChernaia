package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.data.ConfigReader;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.MainPage;

import java.util.List;

public class MainPageSteps {
    MainPage mainPage;
    SoftAssert softAssert;

    public MainPageSteps(WebDriver webDriver) {
        mainPage = new MainPage(webDriver);
        softAssert = new SoftAssert();
    }


    @Step("Assert 4 items are displayed")
    public void assertItemsNumber(int number) {
        softAssert.assertEquals(mainPage.getHeaderMenuItemsCount(), number);
    }

    @Step("Assert items have proper text")
    public void assertItemsHaveProperText(String headerMenuFirstTab, String headerMenuSecondTab,
                                          String headerMenuThirdTab, String headerMenuForthTab) {
        softAssert.assertEquals(mainPage.getHeaderMenuText(0), headerMenuFirstTab);
        softAssert.assertEquals(mainPage.getHeaderMenuText(1), headerMenuSecondTab);
        softAssert.assertEquals(mainPage.getHeaderMenuText(2), headerMenuThirdTab);
        softAssert.assertEquals(mainPage.getHeaderMenuText(3), headerMenuForthTab);

    }

    @Step("Assert 4 images are displayed")
    public void assertDisplayedImages(int number) {
        softAssert.assertEquals(mainPage.getImagesListCount(), number);
    }

    @Step("Assert 4 texts under icons")
    public void assertNumberTextsUnderIcons(int number) {
        softAssert.assertEquals(mainPage.getTextUnderImagesCount(), number);
    }

    @Step("Assert proper texts under icons")
    public void assertProperTextUnderIcons(String imagesTextFirst, String imagesTextSecond,
                                           String imagesTextThird, String imagesTextForth) {
        softAssert.assertEquals(mainPage.getImagesText(0), imagesTextFirst);
        softAssert.assertEquals(mainPage.getImagesText(1), imagesTextSecond);
        softAssert.assertEquals(mainPage.getImagesText(2), imagesTextThird);
        softAssert.assertEquals(mainPage.getImagesText(3), imagesTextForth);
    }

    @Step("Assert frame exists")
    public void assertFrameExists() {
        softAssert.assertNotNull(mainPage.getFrameButton());
    }

    @Step("Switch to frame")
    public void switchToFrame() {
        mainPage.switchToFrame();
    }

    @Step("Assert frame button exists")
    public void assertFrameButtonExists() {
        softAssert.assertNotNull(mainPage.getFrameButtonInsideFrame());
    }

    @Step("Switch to default window")
    public void switchToDefaultWindow() {
        mainPage.switchToDefaultContent();
    }

    @Step("Assert 5 items in the left section have proper text")
    public void assertItemsInLeftSectionHaveProperText(String leftMenuFirstTab,
                               String leftMenuSecondTab, String leftMenuThirdTab,
                               String leftMenuForthTab, String leftMenuFifthTab) {
        softAssert.assertEquals(mainPage.getLeftSectionMenuText(0), leftMenuFirstTab);
        softAssert.assertEquals(mainPage.getLeftSectionMenuText(1), leftMenuSecondTab);
        softAssert.assertEquals(mainPage.getLeftSectionMenuText(2), leftMenuThirdTab);
        softAssert.assertEquals(mainPage.getLeftSectionMenuText(3), leftMenuForthTab);
        softAssert.assertEquals(mainPage.getLeftSectionMenuText(4), leftMenuFifthTab);
    }
}
