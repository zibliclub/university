package com.chaffinch.lab4.interfaces;

import com.chaffinch.lab4.classes.functionals.DefiniteIntegralFunctional;
import com.chaffinch.lab4.classes.functionals.SumSegmentFunctional;
import com.chaffinch.lab4.classes.functions.LinearFunction;
import com.chaffinch.lab4.classes.functions.SineFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FunctionalTest {
    private static final Function LINEAR_FUNCTION_1 = new LinearFunction(
            1, 0,
            0, 10
    );
    private static final Function LINEAR_FUNCTION_2 = new LinearFunction(
            2, -1,
            -3, 3
    );
    private static final Function LINEAR_FUNCTION_3 = new LinearFunction(
            -3.5, 5,
            -4, -2
    );
    private static final Function LINEAR_FUNCTION_4 = new LinearFunction(
            1, 0,
            1, 20
    );
    private static final Function LINEAR_FUNCTION_5 = new LinearFunction(
            1, 0,
            -1, 1
    );
    private static final Function LINEAR_FUNCTION_6 = new LinearFunction(
            1, 0,
            1, 18
    );
    private static final Function SINE_FUNCTION = new SineFunction(
            1, 1,
            0, Math.PI
    );

    private final Functional<Function> sumSegmentFunctional = new SumSegmentFunctional<>();
    private final Functional<Function> definiteIntegralFunctional1 = new DefiniteIntegralFunctional<>(
            10,
            1, 20
    );
    private final Functional<Function> definiteIntegralFunctional2 = new DefiniteIntegralFunctional<>(
            1000,
            1, 20
    );
    private final Functional<Function> definiteIntegralFunctional3 = new DefiniteIntegralFunctional<>(
            10,
            0, Math.PI
    );
    private final Functional<Function> definiteIntegralFunctional4 = new DefiniteIntegralFunctional<>(
            1000,
            0, Math.PI
    );

    @Test
    @DisplayName("2.4.1. Test of the SegmentFunctional class")
    public void testSegmentFunctional() {
        assertEquals(
                15,
                sumSegmentFunctional.getSolution(LINEAR_FUNCTION_1)
        );
        assertEquals(
                -3,
                sumSegmentFunctional.getSolution(LINEAR_FUNCTION_2)
        );
        assertEquals(
                46.5,
                sumSegmentFunctional.getSolution(LINEAR_FUNCTION_3)
        );
    }

    @Test
    @DisplayName("2.4.2. Test of the DefiniteIntegralFunctional class")
    public void testDefiniteIntegralFunctional() {
        assertEquals(
                199.5,
                definiteIntegralFunctional2.getSolution(LINEAR_FUNCTION_4),
                0.000001
        );
        assertEquals(
                199.5,
                definiteIntegralFunctional2.getSolution(LINEAR_FUNCTION_4)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> definiteIntegralFunctional1.getSolution(LINEAR_FUNCTION_5)
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> definiteIntegralFunctional1.getSolution(LINEAR_FUNCTION_6)
        );
        assertEquals(
                2,
                definiteIntegralFunctional3.getSolution(SINE_FUNCTION),
                0.01
        );
        assertEquals(
                2,
                definiteIntegralFunctional4.getSolution(SINE_FUNCTION),
                0.01
        );
    }
}