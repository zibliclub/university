package com.chaffinch.lab5.utils.classes.matrix;

import com.chaffinch.lab5.utils.interfaces.IMatrix;

import java.util.Comparator;

public class MatrixDeterminantComparator implements Comparator<IMatrix> {
    @Override
    public int compare(IMatrix o1, IMatrix o2) {
        return Double.compare(o1.getDeterminant(), o2.getDeterminant());
    }
}