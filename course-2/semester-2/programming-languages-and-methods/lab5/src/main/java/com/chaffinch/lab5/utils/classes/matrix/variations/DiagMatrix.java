package com.chaffinch.lab5.utils.classes.matrix.variations;

public class DiagMatrix extends UpTriangleMatrix {
    public DiagMatrix(int dimension) {
        super(dimension);
    }

    public DiagMatrix(double[] values) {
        super(values.length);

        for (int index = 0; index < getDimension(); index++) {
            setValue(index, index, values[index]);
        }
    }

    @Override
    public void setValue(int x, int y, double value) {
        if (x != y && value != 0)
            throw new IllegalStateException("This value is not valid for these coordinates");
        super.setValue(x, y, value);
    }
}
