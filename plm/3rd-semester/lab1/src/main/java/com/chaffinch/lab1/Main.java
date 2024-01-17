package com.chaffinch.lab1;

import com.chaffinch.lab1.utils.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the task number: ");
        int number = scanner.nextInt();

        switch (number) {
            case 1 -> task1();
            case 2 -> task2();
            case 3 -> task3();
            case 4 -> task4();
            case 5 -> task5();
            case 6 -> task6();
            case 7 -> task7();
            case 8 -> task8();
            case 9 -> task9();
            case 10 -> task10();
            case 11 -> task11();
            case 12 -> task12();
            case 13 -> task13();
            case 14 -> task14();
            case 15 -> task15();
            case 16 -> task16();
            case 17 -> task17();
            case 18 -> task18();
            default -> System.out.println("An invalid value has been entered.");
        }
    }

    private static void task1() {
        System.out.println("Hello, World!");
    }

    private static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter three real numbers: ");

        double[] doubles = new double[3];
        for (int i = 0; i < 3; i++) {
            doubles[i] = scanner.nextDouble();
        }

        System.out.println("The product of the numbers entered: " + doubles[0] * doubles[1] * doubles[2]);

        System.out.println("The arithmetic mean of numbers: " + (doubles[0] + doubles[1] + doubles[2]) / 3);

        System.out.print("Numbers in ascending order: ");
        Arrays.sort(doubles);
        System.out.print(doubles[0] + ", " + doubles[1] + ", " + doubles[2]);
    }

    private static void task3() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter three integer: ");

        int[] ints = new int[3];
        for (int i = 0; i < 3; i++) {
            ints[i] = scanner.nextInt();
        }

        System.out.println("The product of the numbers entered: " + ints[0] * ints[1] * ints[2]);

        System.out.println("The arithmetic mean of numbers: " + (ints[0] + ints[1] + ints[2]) / 3F);

        System.out.print("Numbers in ascending order: ");
        Arrays.sort(ints);
        System.out.print(ints[0] + ", " + ints[1] + ", " + ints[2]);
    }

    private static void task4() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coefficients of the quadratic equation: ");

        double[] coefficients = new double[3];
        for (int i = 0; i < 3; i++) {
            coefficients[i] = scanner.nextDouble();
        }

        if (coefficients[0] == 0) {
            System.out.println("A quadratic equation with given coefficients has 1 root: "
                    + -coefficients[2] / coefficients[1]);
        } else {
            double discriminant = Math.pow(coefficients[1], 2) - 4 * coefficients[0] * coefficients[2];
            if (discriminant < 0) {
                System.out.println("A quadratic equation with these coefficients has no existing roots.");
            } else if (discriminant == 0) {
                System.out.println("A quadratic equation with the given coefficients has one root: "
                        + -coefficients[1] / (2 * coefficients[0]));
            } else {
                System.out.println("A quadratic equation with the given coefficients has two roots: "
                        + (-coefficients[1] - Math.sqrt(discriminant)) / (2 * coefficients[0]) + ", "
                        + (-coefficients[1] + Math.sqrt(discriminant)) / (2 * coefficients[0]));
            }
        }
    }

    private static void task5() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the range of values to tabulate the sin(x) function: ");
        double rangeStart = scanner.nextDouble();
        double rangeEnd = scanner.nextDouble();

        System.out.print("Enter a step to tabulate the function: ");
        double step = scanner.nextDouble();

        System.out.println("Tabulate the function sin(x), where x is from ["
                + rangeStart + ";" + rangeEnd + "] in steps of " + step +":");
        for (double i = rangeStart; i <= rangeEnd; i += step) {
            System.out.println("sin(" + i + ") = " + Math.sin(i));
        }
    }

    private static void task6() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coefficients of a system of linear equations with two unknowns (6 values):");
        double[][] coefficients = new double[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                coefficients[i][j] = scanner.nextDouble();
            }
        }

        double delta = Determinant.secondOrder(
                coefficients[0][0], coefficients[0][1],
                coefficients[1][0], coefficients[1][1]
        );

        double delta1 = Determinant.secondOrder(
                coefficients[0][2], coefficients[0][1],
                coefficients[1][2], coefficients[1][1]
        );

        double delta2 = Determinant.secondOrder(
                coefficients[0][0], coefficients[0][2],
                coefficients[1][0], coefficients[1][2]
        );

        System.out.println(
                "The value of the first variable: " + delta1 / delta +
                        ", value of the second: " + delta2 / delta
        );
    }

    private static void task7() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x for the exp(x) function, as well as the precision: ");
        double degree = scanner.nextDouble();
        double precision = scanner.nextDouble();

        double amount = 1, currentValue = 1, counter = 1;
        while (Math.abs(currentValue) >= precision) {
            currentValue = currentValue * degree / counter;
            amount += currentValue;
            counter++;
        }

        System.out.println("By Math.E: " + Math.E);
        System.out.println("By Taylor's formula with degree" + degree + "and precision " + precision + ": " + amount);
    }

    private static void task8() {
        System.out.println("An example of outputting an array to the console: ");

        int[] array = {1, -23, 0, 8, 10, -7};
        IntArrayUtils.print(array);
    }

    private static void task9() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int count = scanner.nextInt();
        int[] array = IntArrayUtils.fill(count);

        System.out.print("An array with the entered values: ");
        IntArrayUtils.print(array);
    }

    private static void task10() {
        System.out.print("Array: ");
        int[] array = {1, -23, 0, 8, 10, -7};
        IntArrayUtils.print(array);

        System.out.print("The sum of the elements: " + IntArrayUtils.sum(array));
    }

    private static void task11() {
        System.out.print("Array: ");
        int[] array = {1, -23, 0, 8, 10, -7};
        IntArrayUtils.print(array);

        System.out.print("Number of even-numbered elements: " + IntArrayUtils.countEvenNumbers(array));
    }

    private static void task12() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Array: ");
        int[] array = {1, -23, 0, 8, 10, -7};
        IntArrayUtils.print(array);

        System.out.print("Enter the start of the range and the end of the range (2 values): ");
        int rangeStart = scanner.nextInt();
        int rangeEnd = scanner.nextInt();

        System.out.print("The number of array elements in the range from "+ rangeStart + " to " + rangeEnd + ": " +
                IntArrayUtils.countNumbersInRange(array, rangeStart, rangeEnd));
    }

    private static void task13() {
        System.out.print("Array: ");
        int[] array = {1, -23, 0, 8, 10, -7};
        IntArrayUtils.print(array);

        if (IntArrayUtils.checkPositive(array)) {
            System.out.println("All elements in the array are positive");
        } else {
            System.out.println("There are non-positive elements in the array");
        }
    }

    private static void task14() {
        System.out.print("Array: ");
        int[] array = {1, -23, 0, 8, 10, -7};
        IntArrayUtils.print(array);

        IntArrayUtils.reverseOrder(array);

        System.out.print("An array with elements in reverse order: ");
        IntArrayUtils.print(array);
    }

    private static void task15() {
        Scanner scanner = new Scanner(System.in);

        Point3D point1 = new Point3D(3, -12, 124);
        Point3D point2 = new Point3D();

        System.out.print("First point coordinates: ");
        System.out.println(point1);

        System.out.print("Second point coordinates: ");
        System.out.println(point2);

        if (point1.equals(point2)) {
            System.out.println("The points are equal in coordinates");
        } else {
            System.out.println("The points are not equal in coordinates");
        }

        System.out.print("Enter the coordinates for the second point (in X, Y, Z order): ");
        point2.setXCoordinate(scanner.nextDouble());
        point2.setYCoordinate(scanner.nextDouble());
        point2.setZCoordinate(scanner.nextDouble());

        System.out.println("Now, the second point has coordinates " +
                "X: " + point2.getXCoordinate() +
                ", Y: " + point2.getYCoordinate() +
                ", Z: " + point2.getZCoordinate()
        );

        if (point1.equals(point2)) {
            System.out.println("The points are equal in coordinates");
        } else {
            System.out.println("The points are not equal in coordinates");
        }

        if (point1.equals(point1)) {
            System.out.println("The point is equal to itself");
        } else {
            System.out.println("The point is not equal to itself (this will not happen)");
        }
    }

    private static void task16() {
        Point3D point1 = new Point3D(3, -12, 124);
        Point3D point2 = new Point3D();

        Vector3D vector1 = new Vector3D(12, -23, 2);
        Vector3D vector2 = new Vector3D();
        Vector3D vector3 = new Vector3D(point1, point2);

        System.out.print(
                "VECTOR LENGTH \n" +
                        "First vector: " + vector1.length() + "\n" +
                        "Second vector: " + vector2.length() + "\n" +
                        "Third vector: " + vector3.length() + "\n"
        );

        if(vector1.equals(vector2)) {
            System.out.println("The first vector is equal to the second vector");
        } else {
            System.out.println("The first vector is not equal to the second vector");
        }

        if(vector1.equals(vector3)) {
            System.out.println("The first vector is equal to the third vector");
        } else {
            System.out.println("The first vector is not equal to the third vector");
        }

        if(vector2.equals(vector3)) {
            System.out.println("The second vector is equal to the third vector");
        } else {
            System.out.println("The second vector is not equal to the third vector");
        }
    }

    private static void task17() {
        Vector3D vector1 = new Vector3D(12, -23, 2);
        Vector3D vector2 = new Vector3D(-12, 23, -2);

        Vector3D vectorSum = Vector3DProcessor.sum(vector1, vector2);
        System.out.println("Sum of vectors: " + vectorSum);

        Vector3D vectorDifference = Vector3DProcessor.difference(vector1, vector2);
        System.out.println("Difference vectors: " + vectorDifference);

        System.out.println("Scalar product of vectors: " + Vector3DProcessor.scalar(vector1, vector2));

        Vector3D vector3 = Vector3DProcessor.vector(vector1, vector2);
        System.out.println("Vector product of vectors: " + vector3);

        if (Vector3DProcessor.collinear(vector1, vector2)) {
            System.out.println("The vectors are collinear");
        } else {
            System.out.println("Vectors are not collinear");
        }
    }

    private static void task18() {
        Vector3DArray array = new Vector3DArray(5);
        System.out.println(array);

        System.out.println("Array length: " + array.length());

        Vector3D vector1 = new Vector3D(10, -12, 5);
        array.elementChange(0, vector1);
        System.out.println(array);

        System.out.println("Maximum length of the vector in the array: " + array.maxLength());

        if (array.search(vector1) >= 0) {
            System.out.println("This vector stands at the index " + array.search(vector1));
        } else if (array.search(vector1) == -1) {
            System.out.println("There is no such vector in the array");
        } else {
            System.out.println("Error. Invalid value");
        }

        Vector3D vector2 = new Vector3D(0, -12, 5);
        if (array.search(vector2) >= 0) {
            System.out.println("This vector stands at the index " + array.search(vector1));
        } else if (array.search(vector2) == -1) {
            System.out.println("There is no such vector in the array");
        } else {
            System.out.println("Error. Invalid value");
        }

        array.elementChange(1, vector2);
        System.out.println(array);
        System.out.println("The sum of all vectors in the array: " + array.sum());

        double[] coefficients1 = new double[5];
        for (int i = 0; i < 5; i++) {
            coefficients1[i] = i + 10;
        }
        Vector3D vector3 = array.linearCombination(coefficients1);
        System.out.println("Linear Combination: " + vector3);

        double[] coefficients2 = new double[10];
        for (int i = 0; i < 10; i++) {
            coefficients2[i] = i + 10;
        }
        Vector3D vector4 = array.linearCombination(coefficients2);
        System.out.println("Linear Combination: " + vector4);

        Point3D point = new Point3D(5, 5, 5);
        Point3D[] shiftPoints = array.shift(point);
        for (Point3D i : shiftPoints) {
            System.out.println(i);
        }
    }
}