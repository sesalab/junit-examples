package it.unisa.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorStatefulTest {

    private CalculatorStateful calculator;

    @BeforeEach
    private void setUp() {
        calculator = new CalculatorStateful();
    }

    // Test the state transitions of "esito" variable

    @Test
    @DisplayName("Test the following transitions path: EMPTY -> EMPTY")
    public void testEmptyEmpty() {
        CalculatorStateful.Esito expected = CalculatorStateful.Esito.EMPTY;
        calculator.clear();
        CalculatorStateful.Esito actual = calculator.getEsito();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the following transitions path: EMPTY -> OK")
    public void testEmptyOk() {
        CalculatorStateful.Esito expected = CalculatorStateful.Esito.OK;
        calculator.put(1);
        CalculatorStateful.Esito actual = calculator.getEsito();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the following transitions path: EMPTY -> OK -> OK")
    public void testEmptyOkOk() {
        CalculatorStateful.Esito expected = CalculatorStateful.Esito.ERROR;
        calculator.put(1);
        calculator.div(1);
        CalculatorStateful.Esito actual = calculator.getEsito();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the following transitions path: EMPTY -> OK -> EMPTY")
    public void testEmptyOkEmpty() {
        CalculatorStateful.Esito expected = CalculatorStateful.Esito.EMPTY;
        calculator.put(-1);
        calculator.clear();
        CalculatorStateful.Esito actual = calculator.getEsito();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the following transitions path: EMPTY -> OK -> ERROR")
    public void testEmptyOkError() {
        CalculatorStateful.Esito expected = CalculatorStateful.Esito.ERROR;
        calculator.put(150);
        calculator.div(0);
        CalculatorStateful.Esito actual = calculator.getEsito();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the following transitions path: EMPTY -> OK -> ERROR -> EMPTY")
    public void testEmptyOkErrorEmpty() {
        CalculatorStateful.Esito expected = CalculatorStateful.Esito.ERROR;
        calculator.put(-144);
        calculator.div(0);
        calculator.clear();
        CalculatorStateful.Esito actual = calculator.getEsito();
        assertEquals(expected, actual);
    }

    // Test the behavior of each operation

    @Test
    @DisplayName("Test the addition: 0 + 10")
    public void testAdd() {
        double expected = 10;
        calculator.put(0);
        calculator.add(10);
        double actual = calculator.getValore();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the subtraction: 0 - 2")
    public void testSub() {
        double expected = -2;
        calculator.put(0);
        calculator.sub(2);
        double actual = calculator.getValore();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the multiplication: 1 * -2")
    public void testMul() {
        double expected = -2;
        calculator.put(1);
        calculator.mul(-2);
        double actual = calculator.getValore();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test the division: 0 / 5")
    public void testDiv() {
        double expected = 0;
        calculator.put(0);
        calculator.mul(5);
        double actual = calculator.getValore();
        assertEquals(expected, actual);
    }
}
