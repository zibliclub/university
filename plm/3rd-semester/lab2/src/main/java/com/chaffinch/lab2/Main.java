package com.chaffinch.lab2;

import com.chaffinch.lab2.utils.StringProcessor;

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
            default -> System.err.println("An invalid value has been entered.");
        }
    }

    private static void task1() {
        System.out.println(StringProcessor.repeat("1mama2papa3ded", -10));
    }

    private static void task2() {

    }

    private static void task3() {

    }

    private static void task4() {

    }

    private static void task5() {

    }

    private static void task6() {

    }

    private static void task7() {

    }

    private static void task8() {

    }

    private static void task9() {

    }

    private static void task10() {

    }

    private static void task11() {

    }

    private static void task12() {

    }

    private static void task13() {

    }
}