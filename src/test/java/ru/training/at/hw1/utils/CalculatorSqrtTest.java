package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSqrtTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "numbers")
    public static Object[][] createNumbers() {
        return new Object[][] {
                {85.6}
        };
    }

    @DataProvider(name = "zeroNumber")
    public static Object[][] createZeroNumber() {
        return new Object[][] {
                {0.0}
        };
    }

    @Test(groups = {"sqrtOperation"}, dataProvider = "numbers")
    public void checkSqrtOperation(double d1) {
        double expected = calculator.sqrt(d1);
        double actual = 9.252;
        assertEquals(actual, expected, 0.001);
    }

    @Test(groups = {"sqrtOperation"}, dataProvider = "zeroNumber")
    public void checkSqrtOperationWithZero(double d1) {
        double expected = calculator.sqrt(d1);
        double actual = 0;
        assertEquals(actual, expected);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
