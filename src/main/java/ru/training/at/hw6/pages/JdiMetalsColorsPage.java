package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw6.entities.MetalsColorsInfo;
import ru.training.at.hw6.forms.MetalsColorsSubmitForm;


import java.util.LinkedList;
import java.util.List;

public class JdiMetalsColorsPage extends WebPage {

    private MetalsColorsSubmitForm metalsColorsSubmitForm;

    @UI(".panel-body-list.results > li")
    private WebList resultsList;

    public List<String> getResultsList() {
        List<String> result = new LinkedList<>();
        for (UIElement res : resultsList) {
            result.add(res.getValue());
        }
        return result;
    }

    public void fillAndSubmitForm(MetalsColorsInfo info) {
        metalsColorsSubmitForm.fill(info);
        metalsColorsSubmitForm.submit();
    }


}
