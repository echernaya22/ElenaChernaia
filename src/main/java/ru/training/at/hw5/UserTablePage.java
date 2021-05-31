package ru.training.at.hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.component.DriverManager;

import java.util.Arrays;
import java.util.List;

public class UserTablePage extends DriverManager {

    @FindBy(css = "tbody select")
    private List<WebElement> numberTypeListDropdown;
    @FindBy(css = "td > a")
    private List<WebElement> usernameList;
    @FindBy(css = ".user-descr > span")
    private List<WebElement> descriptionTextList;
    @FindBy(css = ".user-descr > input")
    private List<WebElement> checkboxList;
    @FindBy(css = "tr > td:first-child")
    private List<WebElement> numberList;
    @FindBy(css = ".panel-body-list.logs")
    private List<WebElement> logList;
    @FindBy(css = "tbody select")
    private List<WebElement> dropdownList;


    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getNumberTypeListDropdown() {
        return numberTypeListDropdown;
    }

    public List<WebElement> getUsernameList() {
        return usernameList;
    }

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }

    public List<WebElement> getDescriptionTextList() {
        return descriptionTextList;
    }

    public String getNumberList(int index) {
        return numberList.get(index).getText();
    }

    public List<WebElement> getDropdownList() {
        return dropdownList;
    }

    public List<String> getDropdownListByUsername(String name) {
        int indexOfUser = -1;

        List<WebElement> usersList = getUsernameList();

        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getText().equalsIgnoreCase(name)) {
                indexOfUser = i;
                break;
            }
        }

        return Arrays.asList(getDropdownList().get(indexOfUser).getText()
                .replace(" ", "").split("\n"));
    }

    public void setCheckboxByName(String name) {
        int indexOfCheckbox = -1;
        List<WebElement> usersList = getUsernameList();

        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getText().equalsIgnoreCase(name)) {
                indexOfCheckbox = i;
                break;
            }
        }

        getDescriptionTextList().get(indexOfCheckbox).click();
    }

    public List<WebElement> getLogList() {
        return logList;
    }

    public WebElement getLogByNumber(int index) {
        return getLogList().get(index - 1);
    }

}
