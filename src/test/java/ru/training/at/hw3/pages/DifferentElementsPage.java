package ru.training.at.hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage {
    WebDriver webDriver;
    String templateLogAssertion = "//li[contains(text(), '%s')][contains(text(), '%s')]";

    @FindBy(css = ".uui-navigation.nav.navbar-nav  .dropdown-toggle")
    private WebElement serviceButton;
    @FindBy(css = "[href='different-elements.html']")
    private WebElement differentElementsButton;
    @FindBy(css = ".label-checkbox")
    private List<WebElement> listCheckboxes;
    @FindBy(css = ".label-radio")
    private List<WebElement> listRadio;
    @FindBy(css = "select.uui-form-element")
    private WebElement dropDown;
    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowOption;
    @FindBy(css = ".panel-body-list.logs")
    private List<WebElement> logList;

    public DifferentElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void openPage() {
        serviceButton.click();
        differentElementsButton.click();
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
        Select setDropDownColor = new Select(dropDown);
        setDropDownColor.selectByVisibleText(color);
    }

    public List<WebElement> getLogList() {
        return logList;
    }

    public WebElement searchLogList(String firstWord, String secondWord) {
        return webDriver
                .findElement(By
                        .xpath(String
                                .format(templateLogAssertion, firstWord, secondWord)));
    }
}
