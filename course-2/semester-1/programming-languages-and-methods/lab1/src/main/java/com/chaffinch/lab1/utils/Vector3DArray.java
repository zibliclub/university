package com.chaffinch.lab1.utils;

import java.util.Arrays;

public class Vector3DArray {
    private final int size;
    private final Vector3D[] array;

    public Vector3DArray(int size) {
        this.size = size;
        this.array = new Vector3D[size];

        for (int i = 0; i < size; i++) {
            array[i] = new Vector3D();
        }
    }

    public int length() {
        return size;
    }

    public void elementChange(int number, Vector3D vector) {
        array[number] = vector;
    }

    public double maxLength() {
        double maxLength = 0;

        for (Vector3D i : array) {
            if (i.length() > maxLength) {
                maxLength = i.length();
            }
        }

        return maxLength;
    }

    public int search(Vector3D vector) {
        int number = 0;
        for (Vector3D i : array) {
            if (i.equals(vector)) {
                return number;
            } else {
                number++;
            }
        }

        return -1;
    }

    public Vector3D sum() {
        Vector3D vectorSum = new Vector3D();
        for (Vector3D i : array) {
            vectorSum = Vector3DProcessor.sum(vectorSum, i);
        }

        return vectorSum;
    }

    public Vector3D linearCombination(double[] coefficients) {
        Vector3D linearCombination = new Vector3D();
        Vector3D temp = new Vector3D();

        if (size == coefficients.length) {
            int index = 0;
            for (Vector3D i : array) {
                temp.setXCoordinate(i.getXCoordinate() * coefficients[index]);
                temp.setYCoordinate(i.getYCoordinate() * coefficients[index]);
                temp.setZCoordinate(i.getZCoordinate() * coefficients[index]);

                linearCombination = Vector3DProcessor.sum(linearCombination, temp);
                index++;
            }
        }

        return linearCombination;
    }

    public Point3D[] shift(Point3D point) {
        Point3D[] shiftPoints = new Point3D[size];

        int index = 0;
        for (Vector3D i : array) {
            shiftPoints[index] = new Point3D(
                    point.getXCoordinate() + i.getXCoordinate(),
                    point.getYCoordinate() + i.getYCoordinate(),
                    point.getZCoordinate() + i.getZCoordinate()
                    );
            index++;
        }

        return shiftPoints;
    }

    @Override
    public String toString() {
        return "Vector3DArray{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
