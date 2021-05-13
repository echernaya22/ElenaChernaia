package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise1 {

    WebDriver webDriver;
    SoftAssert softAssert;

    private WebElement webElement;
    private final String page = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssert();
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void exercise1Test() {

        // 1.Open test site by URL
        webDriver.navigate().to(page);

        // 2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        // 3. Perform login
        webElement = webDriver.findElement(By.cssSelector("ul.navbar-right"));
        webElement.click();

        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        webElement = webDriver.findElement(By.id("user-name"));
        softAssert.assertEquals(webElement.getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        List<WebElement> headerMenuList = webDriver
                .findElements(By.cssSelector(".uui-navigation.nav.navbar-nav > li > a"));
        softAssert.assertEquals(headerMenuList.get(0).getText(), "HOME");
        softAssert.assertEquals(headerMenuList.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(headerMenuList.get(2).getText(), "SERVICE");
        softAssert.assertEquals(headerMenuList.get(3).getText(), "METALS & COLORS");

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imagesList = webDriver
                .findElements(By.cssSelector("span.icons-benefit"));
        softAssert.assertEquals(imagesList.size(), 4);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textBelowImagesList = webDriver
                .findElements(By.cssSelector("span.benefit-txt"));
        softAssert.assertEquals(textBelowImagesList.get(0).getText(), "To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        softAssert.assertEquals(textBelowImagesList.get(1).getText(), "To be flexible and\n"
                + "customizable");
        softAssert.assertEquals(textBelowImagesList.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(textBelowImagesList.get(3).getText(), "Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");

        // 8. Assert that there is the iframe with “Frame Button” exist
        webElement = webDriver.findElement(By.id("frame"));
        softAssert.assertNotNull(webElement);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        webElement = webDriver.findElement(By.id("frame-button"));
        softAssert.assertNotNull(webElement);

        // 10. Switch to original window back
        webDriver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        List<WebElement> leftSectionMenuList = webDriver
                .findElements(By.cssSelector(".sidebar-menu.left > li > a > span"));

        softAssert.assertEquals(leftSectionMenuList.get(0).getText(), "Home");
        softAssert.assertEquals(leftSectionMenuList.get(1).getText(), "Contact form");
        softAssert.assertEquals(leftSectionMenuList.get(2).getText(), "Service");
        softAssert.assertEquals(leftSectionMenuList.get(3).getText(), "Metals & Colors");
        softAssert.assertEquals(leftSectionMenuList.get(4).getText(), "Elements packs");

    }

    @AfterMethod
    public void clear() {
        // 12. Close browser
        webDriver.close();
    }

}
