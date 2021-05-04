package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CalculatorIsNegativeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "positiveNumbersAndZero")
    public static Object[][] createPositiveNumbersAndZero() {
        return new Object[][] {
                {1},
                {100000},
                {0}
        };
    }

    @DataProvider(name = "negativeNumbers")
    public static Object[][] createNegativeNumbers() {
        return new Object[][] {
                {-1},
                {-90000000}
        };
    }


    @Test(groups = {"isNegativeOperation"}, dataProvider = "positiveNumbersAndZero")
    public void checkIsPositiveOperationWithPositiveNumbersAndZero(long l) {
        assertFalse(calculator.isNegative(l));
    }


    @Test(groups = {"isNegativeOperation"}, dataProvider = "negativeNumbers")
    public void checkIsPositiveOperationPositiveNumbers(long l) {
        assertTrue(calculator.isNegative(l));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
