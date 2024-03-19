package com.chaffinch.lab4.classes.trinomial;

import java.util.ArrayList;
import java.util.List;

public class QuadraticTrinomial {
    private final double a;
    private final double b;
    private final double c;
    private final List<Double> roots = new ArrayList<>();

    public QuadraticTrinomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public List<Double> getSolution() {
        if (a == 0) {
            roots.add(-c / b);
            return roots;
        }

        double disc = Math.sqrt(b) - 4 * a * c;
        if (disc == 0) {
            roots.add(-b / (2 * a));
        } else if (disc > 0) {
            roots.add((-b + Math.sqrt(disc)) / (2 * a));
            roots.add((-b - Math.sqrt(disc)) / (2 * a));
        }

        return roots;
    }
}
