package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractDoubleTypeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "positiveNumbers")
    public static Object[][] createPositiveNumbers() {
        return new Object[][] {
                {0.7, 0.1},
                {1.78, 1.18}
        };
    }

    @DataProvider(name = "negativeNumbers")
    public static Object[][] createNegativeNumbers() {
        return new Object[][] {
                {-7.68, -2.18},
                {-5.5, 0.0}
        };
    }

    @Test(groups = {"subtractOperation"}, dataProvider = "positiveNumbers")
    public void checkSubtractDoubleTypeWithPositiveNumbers(double d1, double d2) {
        double expected = calculator.sub(d1, d2);
        double actual = 0.6;
        assertEquals(actual, expected, 0.1);
    }


    @Test(groups = {"subtractOperation"}, dataProvider = "negativeNumbers")
    public void checkSubtractDoubleTypeWithNegativeNumbers(double d1, double d2) {
        double expected = calculator.sub(d1, d2);
        double actual = -5.5;
        assertEquals(actual, expected, 0.1);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
