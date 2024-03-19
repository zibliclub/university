package com.chaffinch.lab4.classes.trinomial;

import java.util.Collections;
import java.util.List;

public class QuadraticTrinomialService {
    public static double getLargestRoot(QuadraticTrinomial trinomial) {
        final List<Double> roots = trinomial.getSolution();
        if (roots.isEmpty()) {
            throw new IllegalStateException("There are no solutions for this trinomial");
        }

        roots.sort(Collections.reverseOrder());

        return roots.get(0);
    }
}
