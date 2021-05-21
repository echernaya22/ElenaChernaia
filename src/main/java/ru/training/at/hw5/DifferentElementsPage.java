package ru.training.at.hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.training.at.hw5.component.DriverManager;

import java.util.List;

public class DifferentElementsPage extends DriverManager {

    private String templateLogAssertion = "//li[contains(text(), '%s')][contains(text(), '%s')]";

    @FindBy(css = ".label-checkbox")
    private List<WebElement> listCheckboxes;
    @FindBy(css = ".label-radio")
    private List<WebElement> listRadio;
    @FindBy(css = "select.uui-form-element")
    private WebElement dropDown;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);;
    }

    public List<WebElement> getListCheckboxes() {
        return listCheckboxes;
    }

    public void setListCheckboxes(int index) {
        getListCheckboxes().get(index).click();
    }

    public List<WebElement> getListRadio() {
        return listRadio;
    }

    public void setListRadio(int index) {
        getListRadio().get(index).click();
    }

    public WebElement getDropDown() {
        return dropDown;
    }

    public void setDropDownColor(String color) {
        Select setDropDownColor = new Select(getDropDown());
        setDropDownColor.selectByVisibleText(color);
    }

    public WebElement searchLogList(String firstWord, String secondWord) {
        return driver
                .findElement(By
                        .xpath(String
                                .format(templateLogAssertion, firstWord, secondWord)));
    }
}
