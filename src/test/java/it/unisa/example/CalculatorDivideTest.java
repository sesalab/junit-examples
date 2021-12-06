package it.unisa.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorDivideTest {

    @Test
    public void testDivideWhenTwoNegativesThenPositive() {
        Calculator calculator = new Calculator();
        int expected = 4;
        int actual = calculator.divide(-20, -5);
        Assertions.assertEquals(expected, actual, "The division of two negative integers did not result in a positive integer");
    }

    @Test
    public void testDivideWhenTwoZerosThenError() {
        Calculator calculator = new Calculator();
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(0, 0), "The division two 0s did not result in an error");
    }

    @Test
    public void testDivideWhenTwoPositivesThenPositive() {
        Calculator calculator = new Calculator();
        int expected = 4;
        int actual = calculator.divide(8, 2);
        Assertions.assertEquals(expected, actual, "The division of two positive integers did not result in a positive integer");
    }

    @Test
    public void testDivideWhenDiscordantThenNegative() {
        Calculator calculator = new Calculator();
        int expected = -3;
        int actual = calculator.divide(-7, 2);
        Assertions.assertEquals(expected, actual, "The division of two discordant integers did not result in a negative integer");
    }
}
