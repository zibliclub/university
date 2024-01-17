package com.chaffinch.lab1.utils;

import java.util.Arrays;
import java.util.Scanner;

public class IntArrayUtils {
    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static int[] fill(int count) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter " + count + " elements of the array: ");
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i : array) sum += i;

        return sum;
    }

    public static int countEvenNumbers(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i % 2 == 0) count++;
        }

        return count;
    }

    public static int countNumbersInRange(int[] array, int rangeStart, int rangeEnd) {
        int count = 0;
        for (int i : array) {
            if (i >= rangeStart && i <= rangeEnd) count++;
        }

        return count;
    }

    public static boolean checkPositive(int[] array) {
        boolean check = true;
        for (int i : array) {
            if (i < 0) check = false;
        }

        return check;
    }

    public static void reverseOrder(int[] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }
}
