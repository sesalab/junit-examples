package it.unisa.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorParameterizedTest {

    private static Stream<Arguments> testAddProvider() {
        return Stream.of(
                Arguments.of(-10, -4, -14, "Test the sum using two negative integers: should return negative integer"),
                Arguments.of(0, 0, 0, "Test the sum using two zeros: should return zero"),
                Arguments.of(1, 2, 3, "Test the sum using two positive integers: should return positive integer")
        );
    }

    @ParameterizedTest(name = "{index} - {3} ({0} + {1} = {2})")
    @MethodSource("testAddProvider")
    public void testAdd(int left, int right, int expected, String displayName) {
        Calculator calculator = new Calculator();
        int actual = calculator.add(left, right);
        Assertions.assertEquals(expected, actual);
    }

}
