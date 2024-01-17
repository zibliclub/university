package com.chaffinch.lab4.classes.trinomial;

import com.chaffinch.lab4.classes.trinomial.QuadraticTrinomial;
import com.chaffinch.lab4.classes.trinomial.QuadraticTrinomialService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuadraticTrinomialServiceTest {
    private static final QuadraticTrinomial TRINOMINAL_1 = new QuadraticTrinomial(2, 1, -1);
    private static final QuadraticTrinomial TRINOMINAL_2 = new QuadraticTrinomial(4, 1, 0);
    private static final QuadraticTrinomial TRINOMINAL_3 = new QuadraticTrinomial(7, 5, 7);
    private static final QuadraticTrinomial TRINOMINAL_4 = new QuadraticTrinomial(0, 1, 4);

    @Test
    @DisplayName("1.2. Checking the functionality of the QuadraticTrinomialService class")
    public void testGetLargestRoot() {
        assertEquals(
                0.5,
                QuadraticTrinomialService.getLargestRoot(TRINOMINAL_1),
                "Must find the largest root of a given trinomial"
        );
        assertEquals(
                0,
                QuadraticTrinomialService.getLargestRoot(TRINOMINAL_2),
                "Must find the largest root of a given trinomial"
        );
        assertThrows(
                IllegalStateException.class,
                () -> QuadraticTrinomialService.getLargestRoot(TRINOMINAL_3),
                "Should handle an error if there are no roots of a given trinomial"
        );
        assertEquals(
                -4D,
                QuadraticTrinomialService.getLargestRoot(TRINOMINAL_4),
                "Must find the largest root of a given trinomial"
        );
    }
}