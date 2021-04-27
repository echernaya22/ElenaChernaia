package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorDivisionDoubleTypeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "numbers")
    public static Object[][] createNumbers() {
        return new Object[][] {
                {4.5, 5.0},
                {5.4, 6.0}
        };
    }

    @DataProvider(name = "exceptionNumbers")
    public static Object[][] createExceptionNumbers() throws NullPointerException {
        return new Object[][] {
                {45.7, 0.0}
        };
    }

    @Test(groups = {"divisionOperation"}, dataProvider = "numbers")
    public void checkDivisionDoubleTypeWithSmallNumbers(double d1, double d2) {
        double expected = calculator.div(d1, d2);
        double actual = 0.9;
        assertEquals(actual, expected, 0.1);
    }

    @Test(groups = {"divisionOperation"}, dataProvider = "exceptionNumbers")
    public void checkDivisionDoubleTypeWithExceptionNumbers(double d1, double d2) {
        calculator.div(d1, d2);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
