package com.chaffinch.lab4.classes.functions;

import com.chaffinch.lab4.interfaces.Function;

public class FractionalFunction implements Function {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double rangeStart;
    private final double rangeEnd;

    public FractionalFunction(double a, double b, double c, double d, double rangeStart, double rangeEnd) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public double getSolution(double argument) {
        if (!(argument >= rangeStart && argument <= rangeEnd)) {
            throw new IllegalArgumentException(
                    String.format("The argument value is outside the specified range [%f:%f]", rangeStart, rangeEnd)
            );
        }

        return (a * argument + b) / (c * argument + d);
    }

    @Override
    public double getRangeStart() {
        return rangeStart;
    }

    @Override
    public double getRangeEnd() {
        return rangeEnd;
    }
}