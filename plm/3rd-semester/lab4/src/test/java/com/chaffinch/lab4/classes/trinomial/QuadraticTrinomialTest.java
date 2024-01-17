package com.chaffinch.lab4.classes.trinomial;

import com.chaffinch.lab4.classes.trinomial.QuadraticTrinomial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticTrinomialTest {
    private static final QuadraticTrinomial TRINOMINAL_1 = new QuadraticTrinomial(2, 1, -1);
    private static final QuadraticTrinomial TRINOMINAL_2 = new QuadraticTrinomial(4, 1, 0);
    private static final QuadraticTrinomial TRINOMINAL_3 = new QuadraticTrinomial(7, 5, 7);
    private static final QuadraticTrinomial TRINOMINAL_4 = new QuadraticTrinomial(0, 1, 4);

    @Test
    @DisplayName("1.1. Checking the functionality of the QuadraticTrinomial class")
    void testQuadraticTrinominal() {
        assertEquals(
                List.of(0.5, -1D),
                TRINOMINAL_1.getSolution(),
                "Must find roots with three coefficients"
        );
        assertEquals(
                List.of(0D, -0.25),
                TRINOMINAL_2.getSolution(),
                "Must find roots without a third coefficient"
        );
        assertEquals(
                Collections.emptyList(),
                TRINOMINAL_3.getSolution(),
                "Should output an empty list if there are no roots"
        );
        assertEquals(
                List.of(-4D),
                TRINOMINAL_4.getSolution(),
                "Should output roots even if there is no first coefficient"
        );
    }
}