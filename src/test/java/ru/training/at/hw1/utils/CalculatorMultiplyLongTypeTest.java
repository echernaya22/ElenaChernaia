package ru.training.at.hw1.utils;

import static org.testng.Assert.*;
import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyLongTypeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "smallNumbers")
    public static Object[][] createSmallNumbers() {
        return new Object[][] {
                {10L, 20L},
                {1L, 200L}
        };
    }

    @DataProvider(name = "bigPositiveAndNegativeNumbers")
    public static Object[][] createBigPositiveAndNegativeNumbers() {
        return new Object[][] {
                {4_000_000_000L, 2_000_000_000L},
                {-4_000_000_000L, -2_000_000_000L}
        };
    }

    @Test(groups = {"multiplyOperation"}, dataProvider = "smallNumbers")
    public void checkMultiplyLongTypeWithSmallNumbers(long l1, long l2) {
        long expected = calculator.mult(l1, l2);
        long actual = 200L;
        assertEquals(actual, expected);
    }

    @Test(groups = {"multiplyOperation"}, dataProvider = "bigPositiveAndNegativeNumbers")
    public void checkMultiplyLongTypeWithBigPositiveAndNegativeNumbers(long l1, long l2) {
        long expected = calculator.mult(l1, l2);
        long actual = 8_000_000_000_000_000_000L;
        assertEquals(actual, expected);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
