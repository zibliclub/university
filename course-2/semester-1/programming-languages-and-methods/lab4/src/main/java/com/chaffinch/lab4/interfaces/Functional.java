package com.chaffinch.lab4.interfaces;

public interface Functional<T extends Function> {
    double getSolution(T function);
}
