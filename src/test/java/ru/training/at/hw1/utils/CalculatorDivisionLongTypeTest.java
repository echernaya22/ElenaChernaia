package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorDivisionLongTypeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "smallNumbers")
    public static Object[][] createSmallNumbers() {
        return new Object[][] {
                {10L, 2L},
                {5L, 1L}
        };
    }

    @DataProvider(name = "bigPositiveAndNegativeNumbers")
    public static Object[][] createBigPositiveAndNegativeNumbers() {
        return new Object[][] {
                {4_000_000_000_000_000_000L, 2_000_000_000L},
                {-4_000_000_000_000_000_000L, -2_000_000_000L}
        };
    }

    @DataProvider(name = "exceptionNumbers")
    public static Object[][] createExceptionNumbers() {
        return new Object[][] {
                {4_000_000_000_000_000_000L, 0L}
        };
    }

    @Test(groups = {"divisionOperation"}, dataProvider = "smallNumbers")
    public void checkDivisionLongTypeWithSmallNumbers(long l1, long l2) {
        long expected = calculator.div(l1, l2);
        long actual = 5L;
        assertEquals(actual, expected);
    }

    @Test(groups = {"divisionOperation"}, dataProvider = "bigPositiveAndNegativeNumbers")
    public void checkDivisionLongTypeWithBigPositiveAndNegativeNumbers(long l1, long l2) {
        long expected = calculator.div(l1, l2);
        long actual = 2_000_000_000L;
        assertEquals(actual, expected);
    }

    @Test(groups = {"divisionOperation"}, dataProvider = "exceptionNumbers",
            expectedExceptions = java.lang.NumberFormatException.class)
    public void checkDivisionLongTypeWithExceptionNumbers(long l1, long l2) {
        calculator.div(l1, l2);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
