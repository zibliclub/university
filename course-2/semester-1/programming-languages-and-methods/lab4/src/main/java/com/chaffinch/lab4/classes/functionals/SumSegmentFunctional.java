package com.chaffinch.lab4.classes.functionals;

import com.chaffinch.lab4.interfaces.Function;
import com.chaffinch.lab4.interfaces.Functional;

public class SumSegmentFunctional<T extends Function> implements Functional<T> {
    @Override
    public double getSolution(T function) {
        return function.getSolution(function.getRangeStart()) +
                function.getSolution(function.getRangeEnd()) +
                function.getSolution((function.getRangeStart() + function.getRangeEnd()) / 2);
    }
}
