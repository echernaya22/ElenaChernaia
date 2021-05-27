package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.at.hw6.entities.User;

public class LoginForm extends Form<User> {

    @FindBy(id = "name")
    private TextField name;
    @FindBy(id = "password")
    private TextField password;
    @FindBy(id = "login-button")
    private TextField submit;

}
