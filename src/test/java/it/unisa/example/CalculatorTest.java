package it.unisa.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test the sum using two negative integers")
    public void testAddWhenTwoNegativesThenNegative() {
        int expected = -14;
        int actual = calculator.add(-10, -4);
        Assertions.assertEquals(expected, actual, "The sum of two negative integers did not result in a negative integer");
    }

    @Test
    public void testAddWhenTwoZerosThenZero() {
        int expected = 0;
        int actual = calculator.add(0, 0);
        Assertions.assertEquals(expected, actual, "The sum of two 0s did not result in 0");
    }

    @Test
    public void testAddWhenTwoPositivesThenPositive() {
        int expected = 3;
        int actual = calculator.add(1, 2);
        Assertions.assertEquals(expected, actual, "The sum of two positive integers did not result in a positive integer");
    }

}
