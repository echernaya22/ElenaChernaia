package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.LoginForm;

public class JdiHomePage extends WebPage {

    @FindBy(id = "user-icon")
    private Button userIcon;
    @FindBy(id = "user-name")
    private Label userName;
    @FindBy(css = ".uui-navigation.nav a[href*='metals']")
    private Button metalsColorsButton;
    @FindBy(css = ".fa.fa-sign-out")
    private Button logoutButton;

    private LoginForm loginForm;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void openMetalsColorsPage() {
        metalsColorsButton.click();
    }

    public void logout() {
        userIcon.click();
        logoutButton.click();
    }

}
