package ru.training.at.hw1.utils;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyDoubleTypeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        calculator = new Calculator();
    }

    @DataProvider(name = "smallNumbers")
    public static Object[][] createSmallNumbers() {
        return new Object[][] {
                {6.7, 0.5},
                {-5.0, -0.67}
        };
    }

    @DataProvider(name = "bigPositiveAndNegativeNumbers")
    public static Object[][] createBigPositiveAndNegativeNumbers() {
        return new Object[][] {
                {1000.3, -100000.6}
        };
    }

    @Test(groups = {"multiplyOperation"}, dataProvider = "smallNumbers")
    public void checkMultiplyDoubleTypeWithSmallNumbers(double d1, double d2) {
        double expected = calculator.mult(d1, d2);
        double actual = 3.35;
        assertEquals(actual, expected, 1);
    }

    @Test(groups = {"multiplyOperation"}, dataProvider = "bigPositiveAndNegativeNumbers")
    public void checkMultiplyDoubleTypeWithBigPositiveAndNegativeNumbers(double d1, double d2) {
        double expected = calculator.mult(d1, d2);
        double actual = -100030600.18;
        assertEquals(actual, expected, 1);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }
}
