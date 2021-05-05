package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Exercise2 {
    WebDriver webDriver;

    private WebElement webElement;
    private final String page = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void exercise2Test() {

        // 1.Open test site by URL
        webDriver.navigate().to(page);

        // 2. Assert Browser title
        Assert.assertEquals(webDriver.getTitle(), "Home Page");

        // 3. Perform login
        webElement = webDriver.findElement(By.cssSelector("ul.navbar-right"));
        webElement.click();

        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        webElement = webDriver.findElement(By.id("user-name"));
        Assert.assertEquals(webElement.getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.cssSelector(".uui-navigation.nav.navbar-nav  .dropdown-toggle"))
                .click();
        webDriver.findElement(By.cssSelector("[href='different-elements.html']")).click();

        // 6. Select checkboxes
        webDriver.findElement(By.xpath("//input[contains(..,'Water')]")).click();
        webDriver.findElement(By.xpath("//input[contains(..,'Wind')]")).click();

        // 7. Select radio
        webDriver.findElement(By.xpath("//input[contains(..,'Selen')]")).click();

        // 8. Select in dropdown
        webDriver.findElement(By.cssSelector("select.uui-form-element")).click();
        webDriver.findElement(By.xpath("//option[text()='Yellow']")).click();

        // 9. Assert that:
        // for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox
        String templateLogAssertion = "//li[contains(text(), '%s')][contains(text(), '%s')]";

        Assert.assertNotNull(webDriver
                .findElement(By.xpath(String.format(templateLogAssertion, "Water", "true"))));
        Assert.assertNotNull(webDriver
                .findElement(By.xpath(String.format(templateLogAssertion, "Wind", "true"))));

        // for radio button there is a log row and value
        // is corresponded to the status of radio button
        Assert.assertNotNull(webDriver
                .findElement(By.xpath(String.format(templateLogAssertion, "metal", "Selen"))));

        // for dropdown there is a log row and value
        // is corresponded to the selected value
        Assert.assertNotNull(webDriver
                .findElement(By.xpath(String.format(templateLogAssertion, "Colors", "Yellow"))));
    }

    @AfterMethod
    public void tearDown() {
        // 12. Close Browser
        webDriver.close();
    }
}
