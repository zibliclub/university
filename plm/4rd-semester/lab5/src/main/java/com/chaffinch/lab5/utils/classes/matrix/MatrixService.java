package com.chaffinch.lab5.utils.classes.matrix;

import com.chaffinch.lab5.utils.interfaces.IMatrix;

import java.util.Arrays;

public class MatrixService {
    public static void arrangeMatrix(IMatrix[] array) {
        Arrays.sort(array, new MatrixDeterminantComparator());
    }
}