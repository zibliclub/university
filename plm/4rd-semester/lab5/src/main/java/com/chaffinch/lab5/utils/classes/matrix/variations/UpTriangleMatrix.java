package com.chaffinch.lab5.utils.classes.matrix.variations;

public class UpTriangleMatrix extends Matrix {
    public UpTriangleMatrix(int dimension) {
        super(dimension);
    }

    @Override
    public void setValue(int row, int col, double value) {
        if (col < row && value != 0)
            throw new IllegalStateException("This value is not valid for these coordinates");
        super.setValue(row, col, value);
    }

    @Override
    public double getDeterminant() {
        double determinant = 1;

        for (int index = 0; index < getDimension(); index++) {
            determinant *= super.getValue(index, index);
        }

        return determinant;
    }
}
