package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumDoubleTypeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "positiveNumbers")
    public static Object[][] createPositiveNumbers() {
        return new Object[][] {
                {0.7, 1.1},
                {1.78, 0.02}
        };
    }

    @DataProvider(name = "negativeNumbers")
    public static Object[][] createNegativeNumbers() {
        return new Object[][] {
                {-6500.5, -400.4},
                {-6900.0, -0.9}
        };
    }

    @Test(groups = {"sumOperation"}, dataProvider = "positiveNumbers")
    public void checkSumDoubleTypeWithPositiveNumbers(double d1, double d2) {
        double expected = calculator.sum(d1, d2);
        double actual = 1.8;
        assertEquals(actual, expected, 0.1);
    }

    @Test(groups = {"sumOperation"}, dataProvider = "negativeNumbers")
    public void checkSumDoubleTypeNegativeNumbers(double d1, double d2) {
        double expected = calculator.sum(d1, d2);
        double actual = -6900.9;
        assertEquals(actual, expected, 0.1);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
