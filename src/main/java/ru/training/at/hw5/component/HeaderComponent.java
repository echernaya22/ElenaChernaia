package ru.training.at.hw5.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.component.DriverManager;

import java.util.List;

public class HeaderComponent extends DriverManager {

    @FindBy(css = ".uui-navigation.nav > li")
    private List<WebElement> headerMenuButtonsList;
    @FindBy(css = ".dropdown-menu > li")
    private List<WebElement> dropdownHeaderMenu;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void clickHeaderMenuButtonByValue(String value) {
        for (WebElement webElement : headerMenuButtonsList) {
            if (webElement.getText().equalsIgnoreCase(value)) {
                webElement.click();
                break;
            }
        }
    }

    public void clickDropdownHeaderMenuByValue(String value) {
        for (WebElement webElement : dropdownHeaderMenu) {
            if (webElement.getText().equalsIgnoreCase(value)) {
                webElement.click();
                break;
            }
        }
    }
}
