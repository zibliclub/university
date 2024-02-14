package com.chaffinch.lab5.utils.classes.matrix.variations;

import com.chaffinch.lab5.utils.interfaces.IMatrix;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    private int dimension;
    private double[] values;
    private double determinant;
    private boolean validDeterminant = false;

    public Matrix(int dimension) {
        this.dimension = dimension;
        this.values = new double[dimension * dimension];
    }

    public double getValue(int row, int col) {
        return values[row * dimension + col];
    }

    public void setValue(int row, int col, double value) {
        if (values[row * dimension + col] != value && validDeterminant)
            validDeterminant = false;
        values[row * dimension + col] = value;
    }

    public double getDeterminant() {
        if (validDeterminant)
            return determinant;

        double determinant = 1;
        double[] bufferMatrix = Arrays.copyOf(values, values.length);

        for (int col = 0; col < dimension; col++) {
            if (bufferMatrix[col * dimension + col] == 0) {
                if (switchRows(bufferMatrix, col))
                    determinant *= -1;
                else
                    return 0;
            }

            zeroingColumn(bufferMatrix, col);
        }

        for (int diagonalValue = 0; diagonalValue < dimension; diagonalValue++) {
            determinant *= bufferMatrix[diagonalValue * dimension + diagonalValue];
        }

        this.determinant = determinant;
        validDeterminant = true;

        return determinant;
    }

    private boolean switchRows(double[] matrix, int coordinate) {
        for (int nextCoordinate = coordinate + 1; nextCoordinate < dimension; nextCoordinate++) {
            if (matrix[nextCoordinate * dimension + coordinate] != 0) {
                double[] temp = new double[dimension];

                for (int x = coordinate; x < dimension; x++) {
                    temp[x] = matrix[x * dimension + coordinate];
                    matrix[x * dimension + coordinate] = matrix[x * dimension + nextCoordinate];
                    matrix[x * dimension + nextCoordinate] = temp[x];
                }

                return true;
            }
        }

        return false;
    }

    private void zeroingColumn(double[] matrix, int col) {
        double coefficient;

        for (int nextCol = col + 1; nextCol < dimension; nextCol++) {
            coefficient = matrix[nextCol * dimension + col] / matrix[col * dimension + col];

            for (int x = col; x < dimension; x++) {
                matrix[nextCol * dimension + x] -= coefficient * matrix[col * dimension + x];
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return dimension == matrix.dimension && Arrays.equals(values, matrix.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dimension);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }
}
