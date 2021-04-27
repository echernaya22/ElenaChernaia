package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorIsPositiveTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "positiveNumbers")
    public static Object[][] createPositiveNumbers() {
        return new Object[][] {
                {1},
                {100000}
        };
    }

    @DataProvider(name = "negativeNumbers")
    public static Object[][] createNegativeNumbers() {
        return new Object[][] {
                {-1},
                {-90000000}
        };
    }

    @DataProvider(name = "zeroNumber")
    public static Object[][] createZeroNumber() {
        return new Object[][] {
                {0}
        };
    }

    @Test(groups = {"isPositiveOperation"}, dataProvider = "positiveNumbers")
    public void checkIsPositiveOperationWithPositiveNumbers(long l) {
        assertTrue(calculator.isPositive(l));
    }

    @Test(groups = {"isPositiveOperation"}, dataProvider = "zeroNumber")
    public void checkIsPositiveOperationWithZero(long l) {
        assertFalse(calculator.isPositive(l));
    }

    @Test(groups = {"isPositiveOperation"}, dataProvider = "negativeNumbers")
    public void checkIsPositiveOperationPositiveNumbers(long l) {
        assertFalse(calculator.isPositive(l));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
