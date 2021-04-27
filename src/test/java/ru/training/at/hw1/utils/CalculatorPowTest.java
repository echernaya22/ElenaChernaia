package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "numbers")
    public static Object[][] createNumbers() {
        return new Object[][] {
                {17.8, 5.1},
                {17.8, 5.98}
        };
    }

    @DataProvider(name = "zeroDegreeNumbers")
    public static Object[][] createNumbersWithZeroDegree() {
        return new Object[][] {
                {0.0, 0.0},
                {17.8, 0.0}
        };
    }

    @Test(groups = {"powOperation"}, dataProvider = "numbers")
    public void checkPowOperation(double d1, double d2) {
        double expected = calculator.pow(d1, d2);
        double actual = 1786899.02;
        assertEquals(actual, expected, 0.01);
    }

    @Test(groups = {"powOperation"}, dataProvider = "zeroDegreeNumbers")
    public void checkPowOperationWithZeroDegree(double d1, double d2) {
        double expected = calculator.pow(d1, d2);
        double actual = 1;
        assertEquals(actual, expected);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
