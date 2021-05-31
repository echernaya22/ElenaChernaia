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

    @JDropdown(root = "#vegetables",
            value = "#salad-dropdown > button.dropdown-toggle",
            list = "li",
            expand = ".caret")
    private Dropdown vegetableDropdown;

    @FindBy(css = "#salad-dropdown .caret")
    private WebElement vegetableExpand;

    @FindBy(xpath = "//input[@checked='checked']/parent::a")
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
        getVegetableDropdown().select(info.getVegetables());
        //selectVegetable(info.getVegetables());
        getRadioEven().select(info.getSummary()[1]);
        getRadioOdd().select(info.getSummary()[0]);
        getChecklist().select(info.getElements());
    }

    @Override
    public void submit() {
        getSubmitButton().click();
    }

    private Dropdown getVegetableDropdown() {
        getVegetableExpand().click();
        getVegetableDefault().click();
        return vegetableDropdown;
    }
}
