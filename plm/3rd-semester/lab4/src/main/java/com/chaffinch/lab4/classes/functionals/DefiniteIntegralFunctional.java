package com.chaffinch.lab4.classes.functionals;

import com.chaffinch.lab4.interfaces.Function;
import com.chaffinch.lab4.interfaces.Functional;

public class DefiniteIntegralFunctional<T extends Function> implements Functional<T> {
    private final int numberOfSplits;
    private final double rangeStart;
    private final double rangeEnd;

    public DefiniteIntegralFunctional(int numberOfSplits, double rangeStart, double rangeEnd) {
        if (numberOfSplits <= 0) {
            throw new IllegalArgumentException("The number of splits must be greater than zero");
        }
        this.numberOfSplits = numberOfSplits;

        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public double getSolution(T function) {
        if (rangeStart > function.getRangeStart() || rangeEnd > function.getRangeEnd()) {
            throw new IllegalArgumentException("The domain of the function is not contained in the given segment");
        }

        final double deltaX = Math.abs(rangeEnd - rangeStart) / numberOfSplits;
        double argument, sum = 0;

        for (int i = 0; i < numberOfSplits; i++) {
            argument = rangeStart + (i + 0.5) * deltaX;
            sum += function.getSolution(argument);
        }

        return sum * deltaX;
    }
}
