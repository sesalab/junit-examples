package it.unisa.slide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreeterTest {

    @Test
    @DisplayName("Testing whether greet() works with an empty string")
    public void testGreetEmpty() {
        Greeter g = new Greeter();
        String actual = g.greet("");
        assertEquals("Hello ", actual, String.format("The expected value was \"%s\", but the method returned \"%s\", instead", "Hello ", actual));
    }

    @Test
    @DisplayName("Testing whether greet() works with a 1 char long string")
    public void testGreetLength1() {
        Greeter g = new Greeter();
        String actual = g.greet("a");
        assertEquals("Hello a", actual);
    }

    @Test
    @DisplayName("Testing whether greet() works with a string longer than 1")
    public void testGreetLengthGreater1() {
        Greeter g = new Greeter();
        String actual = g.greet("fff12");
        assertEquals("Hello fff12", actual);
    }


}
