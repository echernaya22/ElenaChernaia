package ru.training.at.hw1.utils;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.epam.tat.module4.*;

public class CalculatorSumLongTypeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "smallNumbers")
    public static Object[][] createSmallNumbers() {
        return new Object[][] {
                {10L, 20L},
                {0L, 30L},
                {-10L, 40L}
        };
    }

    @DataProvider(name = "bigPositiveNumbers")
    public static Object[][] createBigPositiveNumbers() {
        return new Object[][] {
                {1_000_000_000L, 3_000_000_000L},
                {0L, 4_000_000_000L}
        };
    }

    @DataProvider(name = "bigNegativeNumbers")
    public static Object[][] createBigNegativeNumbers() {
        return new Object[][] {
                {-1_000_000_000L, -3_000_000_000L},
                {0L, -4_000_000_000L}
        };
    }

    @Test(groups = {"sumOperation"}, dataProvider = "smallNumbers")
    public void checkSumLongTypeWithSmallNumbers(long l1, long l2) {
        long expected = calculator.sum(l1, l2);
        long actual = 30;
        assertEquals(actual, expected);
    }

    @Test(groups = {"sumOperation"}, dataProvider = "bigPositiveNumbers")
    public void checkSumLongTypeWithBigPositiveNumbers(long l1, long l2) {
        long expected = calculator.sum(l1, l2);
        long actual = 4_000_000_000L;
        assertEquals(actual, expected);
    }

    @Test(groups = {"sumOperation"}, dataProvider = "bigNegativeNumbers")
    public void checkSumLongTypeWithBigNegativeNumbers(long l1, long l2) {
        long expected = calculator.sum(l1, l2);
        long actual = -4_000_000_000L;
        assertEquals(actual, expected);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
