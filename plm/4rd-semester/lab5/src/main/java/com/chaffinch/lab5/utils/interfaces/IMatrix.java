package com.chaffinch.lab5.utils.interfaces;

public interface IMatrix {
    double getValue(int row, int col);
    void setValue(int row, int col, double value);
    double getDeterminant();
    int getDimension();
}
