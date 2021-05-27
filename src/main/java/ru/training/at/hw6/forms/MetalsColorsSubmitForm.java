package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import ru.training.at.hw6.entities.MetalsColorsInfo;

import java.util.List;

@Getter
public class MetalsColorsSubmitForm extends Form<MetalsColorsInfo> {

    @JDropdown(root = "div[ui=combobox]",
            value = ".filter-option",
            list = "a",
            expand = ".caret")
    private Dropdown metalsDropdown;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown colorsDropdown;

    @FindBy(css = "#salad-dropdown .caret")
    private WebElement vegetableExpand;
    @FindBy(css = "#salad-dropdown label")
    private List<WebElement> vegetableList;
    @FindBy(css = "#salad-dropdown button")
    private WebElement vegetableValue;
    @FindBy(css = "#salad-dropdown ul")
    private WebElement vegetableIsExpanded;
    @FindBy(xpath = "//input[@id='g7']/parent::a")
    private WebElement vegetableDefault;

    @UI("[name=custom_radio_odd]")
    private RadioButtons radioOdd;

    @UI("[name=custom_radio_even]")
    private RadioButtons radioEven;

    @FindBy(css = "section[id=elements-checklist] input[type=checkbox]")
    private Checklist checklist;

    @FindBy(id = "submit-button")
    private Button submitButton;


    @Override
    public void fill(MetalsColorsInfo info) {
        getColorsDropdown().select(info.getColor());
        getMetalsDropdown().select(info.getMetal());
        selectVegetable(info.getVegetables());
        getRadioEven().select(info.getSummary()[1]);
        getRadioOdd().select(info.getSummary()[0]);
        getChecklist().select(info.getElements());
    }

    @Override
    public void submit() {
        getSubmitButton().click();
    }

    private boolean vegetableIsExpanded() {
        return getVegetableIsExpanded().getAttribute("style").equals("display: block;");
    }

    private void selectVegetable(String[] value) {
        if (!vegetableIsExpanded()) {
            getVegetableExpand().click();
            getVegetableDefault().click();
        }
        for (String val : value) {
            for (WebElement listOption : vegetableList) {
                if (listOption.getText().trim().equals(val)) {
                    listOption.click();
                }
            }
        }
    }
}
