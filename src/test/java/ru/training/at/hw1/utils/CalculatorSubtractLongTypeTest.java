package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtractLongTypeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "smallNumbers")
    public static Object[][] createSmallNumbers() {
        return new Object[][] {
                {15L, 3L},
                {12L, 0L}
        };
    }

    @DataProvider(name = "bigPositiveNumbers")
    public static Object[][] createBigPositiveNumbers() {
        return new Object[][] {
                {7_000_000_000L, 3_000_000_000L},
                {8_000_000_000L, 4_000_000_000L}
        };
    }

    @DataProvider(name = "bigNegativeNumbers")
    public static Object[][] createBigNegativeNumbers() {
        return new Object[][] {
                {-1_000_000_000L, -3_000_000_000L},
                {0L, -2_000_000_000L}
        };
    }

    @Test(groups = {"subtractOperation"}, dataProvider = "smallNumbers")
    public void checkSubtractLongTypeWithSmallNumbers(long l1, long l2) {
        long expected = calculator.sub(l1, l2);
        long actual = 12L;
        assertEquals(actual, expected);
    }

    @Test(groups = {"subtractOperation"}, dataProvider = "bigPositiveNumbers")
    public void checkSubtractLongTypeWithBigPositiveNumbers(long l1, long l2) {
        long expected = calculator.sub(l1, l2);
        long actual = 4_000_000_000L;
        assertEquals(actual, expected);
    }

    @Test(groups = {"subtractOperation"}, dataProvider = "bigNegativeNumbers")
    public void checkSubtractLongTypeWithBigNegativeNumbers(long l1, long l2) {
        long expected = calculator.sub(l1, l2);
        long actual = 2_000_000_000L;
        assertEquals(actual, expected);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
