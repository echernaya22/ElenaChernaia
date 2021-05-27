package ru.training.at.hw6.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw6.pages.JdiHomePage;
import ru.training.at.hw6.pages.JdiMetalsColorsPage;
import ru.training.at.hw6.pages.JdiSite;
import ru.training.at.hw6.entities.MetalsColorsInfo;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.utils.Provider;
import ru.training.at.hw6.utils.ResultList;


public class JdiSiteTest extends BaseTest {

    @Test(dataProviderClass = Provider.class, dataProvider = "jsonMetalsColorsData")
    public void test(MetalsColorsInfo info) {

        JdiHomePage homePage = new JdiHomePage();

        JdiSite.open();

        homePage.login(User.ROMAN);
        String actual = homePage.getUserName();

        Assert.assertEquals(actual, User.ROMAN.getFullName());

        homePage.openMetalsColorsPage();

        JdiMetalsColorsPage metalsColorsPage = new JdiMetalsColorsPage();
        ResultList resultList = new ResultList();

        metalsColorsPage.fillAndSubmitForm(info);

        Assert.assertEquals(resultList.getResultsFromJson(info),
                metalsColorsPage.getResultsList());

        homePage.logout();
    }

}
