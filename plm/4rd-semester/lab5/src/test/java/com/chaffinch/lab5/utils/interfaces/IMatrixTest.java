package com.chaffinch.lab5.utils.interfaces;

import com.chaffinch.lab5.utils.classes.matrix.variations.DiagMatrix;
import com.chaffinch.lab5.utils.classes.matrix.variations.Matrix;
import com.chaffinch.lab5.utils.classes.matrix.variations.UpTriangleMatrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.chaffinch.lab5.utils.classes.matrix.MatrixService.arrangeMatrix;
import static org.junit.jupiter.api.Assertions.*;

class IMatrixTest {
    @Test
    @DisplayName("1. Test of Matrix class methods")
    void testMatrix() {
        IMatrix matrix = getMatrix(4);

        printMatrix(matrix, 4);

        assertEquals(
                4,
                matrix.getValue(3, 2),
                "The getValue method must return a value in the passed coordinates"
        );

        matrix.setValue(3, 2, 6);
        assertEquals(
                6,
                matrix.getValue(3, 2),
                "The setValue method must set a new value in the passed coordinates"
        );
        matrix.setValue(3, 2, 9);

        assertEquals(
                -4000,
                matrix.getDeterminant(),
                "The getDeterminant method must return the value of the determinant of the matrix"
        );
    }

    @Test
    @DisplayName("2. Test of UpTriangleMatrix class methods")
    void testUpTriangleMatrix() {
        IMatrix matrix = getUpTriangleMatrix(5);

        printMatrix(matrix, 5);

        assertEquals(
                4,
                matrix.getValue(3, 3),
                "The getValue method must return a value in the passed coordinates"
        );

        assertThrows(IllegalStateException.class, () -> matrix.setValue(4, 3, 6));

        assertEquals(
                120,
                matrix.getDeterminant(),
                "The getDeterminant method must return the value of the determinant of the matrix"
        );
    }

    @Test
    @DisplayName("3. Test of DiagMatrix class methods")
    void testDiagMatrix() {
        IMatrix matrix = getDiagMatrix(3);

        printMatrix(matrix, 3);

        assertThrows(IllegalStateException.class, () -> matrix.setValue(0, 1, 123));

        assertEquals(
                6,
                matrix.getDeterminant(),
                "The getDeterminant method must return the value of the determinant of the matrix"
        );
    }

    @Test
    @DisplayName("4. Test of MatrixService class")
    void testMatrixDeterminantComparator() {
        IMatrix matrix1 = getMatrix(4);
        IMatrix matrix2 = getUpTriangleMatrix(5);
        IMatrix matrix3 = getDiagMatrix(3);

        IMatrix[] arrayOfMatrix = new IMatrix[]{matrix1, matrix2, matrix3};
        for (IMatrix matrix: arrayOfMatrix) {
            printMatrix(matrix, matrix.getDimension());
        }

        arrangeMatrix(arrayOfMatrix);
        for (IMatrix matrix: arrayOfMatrix) {
            printMatrix(matrix, matrix.getDimension());
        }

        assertTrue(
                arrayOfMatrix[0].getDeterminant() < arrayOfMatrix[1].getDeterminant() &&
                        arrayOfMatrix[1].getDeterminant() < arrayOfMatrix[2].getDeterminant(),
                "Matrices must be sorted in ascending order of the values of their determinants"
        );
    }

    /**
     * Matrix for the test, the determinant of which is: -4000
     *
     * @return <p>0 10 11 13</p>
     * <p>0  0  5  5 </p>
     * <p>0 20  1  9 </p>
     * <p>20 1  4  1 </p>
     */

    private Matrix getMatrix(int dimension) {
        Matrix matrix = new Matrix(dimension);

        matrix.setValue(0, 0, 0);
        matrix.setValue(0, 1, 10);
        matrix.setValue(0, 2, 11);
        matrix.setValue(0, 3, 13);
        matrix.setValue(1, 0, 0);
        matrix.setValue(1, 1, 0);
        matrix.setValue(1, 2, 5);
        matrix.setValue(1, 3, 5);
        matrix.setValue(2, 0, 0);
        matrix.setValue(2, 1, 20);
        matrix.setValue(2, 2, 1);
        matrix.setValue(2, 3, 9);
        matrix.setValue(3, 0, 20);
        matrix.setValue(3, 1, 1);
        matrix.setValue(3, 2, 4);
        matrix.setValue(3, 3, 1);

        return matrix;
    }

    /**
     * Matrix for the test, the determinant of which is: 120
     *
     * @return <p>1 1 1 1 1</p>
     * <p>0 2 1 1 1 </p>
     * <p>0 0 3 1 1 </p>
     * <p>0 0 0 4 1 </p>
     * <p>0 0 0 0 5 </p>
     */

    private UpTriangleMatrix getUpTriangleMatrix(int dimension) {
        UpTriangleMatrix matrix = new UpTriangleMatrix(dimension);

        matrix.setValue(0, 0, 1);
        matrix.setValue(0, 1, 1);
        matrix.setValue(0, 2, 1);
        matrix.setValue(0, 3, 1);
        matrix.setValue(0, 4, 1);
        matrix.setValue(1, 0, 0);
        matrix.setValue(1, 1, 2);
        matrix.setValue(1, 2, 1);
        matrix.setValue(1, 3, 1);
        matrix.setValue(1, 4, 1);
        matrix.setValue(2, 0, 0);
        matrix.setValue(2, 1, 0);
        matrix.setValue(2, 2, 3);
        matrix.setValue(2, 3, 1);
        matrix.setValue(2, 4, 1);
        matrix.setValue(3, 0, 0);
        matrix.setValue(3, 1, 0);
        matrix.setValue(3, 2, 0);
        matrix.setValue(3, 3, 4);
        matrix.setValue(3, 4, 1);
        matrix.setValue(4, 0, 0);
        matrix.setValue(4, 1, 0);
        matrix.setValue(4, 2, 0);
        matrix.setValue(4, 3, 0);
        matrix.setValue(4, 4, 5);

        return matrix;
    }

    /**
     * Matrix for the test, the determinant of which is: 6
     *
     * @return <p>1 0 0</p>
     * <p>0 2 0 </p>
     * <p>0 0 3 </p>
     */

    private DiagMatrix getDiagMatrix(int dimension) {
        DiagMatrix matrix = new DiagMatrix(dimension);

        matrix.setValue(0, 0, 1);
        matrix.setValue(1, 0, 0);
        matrix.setValue(2, 0, 0);
        matrix.setValue(0, 1, 0);
        matrix.setValue(1, 1, 2);
        matrix.setValue(2, 1, 0);
        matrix.setValue(0, 2, 0);
        matrix.setValue(1, 2, 0);
        matrix.setValue(2, 2, 3);

        return matrix;
    }

    private void printMatrix(IMatrix matrix, int dimension) {
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                System.out.print(matrix.getValue(row, col) + " ");
            }

            System.out.println();
        }

        System.out.println();
    }
}