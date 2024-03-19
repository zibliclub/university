package com.chaffinch.lab4.interfaces;

import com.chaffinch.lab4.classes.functions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FunctionTest {
    private static final Function LINEAR_FUNCTION = new LinearFunction(
            2, 3,
            -1, 5
    );
    private static final Function SINE_FUNCTION = new SineFunction(
            2, 1,
            -10, 10
    );
    private static final Function FRACTIONAL_FUNCTION = new FractionalFunction(
            2, 1, 1, 2,
            -5, 5
    );
    private static final Function EXPONENTIAL_FUNCTION = new ExponentialFunction(
            1, 1,
            -100, 10
    );

    @Test
    @DisplayName("2.2.1. Testing linear functions")
    public void testLinearFunction() {
        assertEquals(
                9,
                LINEAR_FUNCTION.getSolution(3)
        );
        assertEquals(
                1,
                LINEAR_FUNCTION.getSolution(-1)
        );
        assertEquals(
                5,
                LINEAR_FUNCTION.getSolution(1)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> LINEAR_FUNCTION.getSolution(6)
        );
    }

    @Test
    @DisplayName("2.2.2. Testing functions with sine")
    public void testSineFunction() {
        assertEquals(
                0,
                SINE_FUNCTION.getSolution(0)
        );
        assertEquals(
                2 * Math.sin(Math.PI / 6),
                SINE_FUNCTION.getSolution(Math.PI / 6)
        );
        assertEquals(
                Math.sqrt(2),
                SINE_FUNCTION.getSolution(3 * Math.PI / 4)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> SINE_FUNCTION.getSolution(100)
        );
    }

    @Test
    @DisplayName("2.2.3. Testing fractional functions")
    public void testFractionalFunction() {
        assertEquals(
                -1,
                FRACTIONAL_FUNCTION.getSolution(-1)
        );
        assertEquals(
                0.5,
                FRACTIONAL_FUNCTION.getSolution(0)
        );
        assertEquals(
                1.25,
                FRACTIONAL_FUNCTION.getSolution(2)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> FRACTIONAL_FUNCTION.getSolution(-10)
        );
    }

    @Test
    @DisplayName("2.2.4. Testing exponential functions")
    public void testExponentialFunction() {
        assertEquals(
                2,
                EXPONENTIAL_FUNCTION.getSolution(0)
        );
        assertEquals(
                Math.exp(3) + 1,
                EXPONENTIAL_FUNCTION.getSolution(3)
        );
        assertEquals(
                Math.exp(-100) + 1,
                EXPONENTIAL_FUNCTION.getSolution(-100)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> EXPONENTIAL_FUNCTION.getSolution(100)
        );
    }
}