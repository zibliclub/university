package com.chaffinch.lab2.utils;

import java.util.Objects;

public class StringProcessor {
    public static String repeat(String s, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of repetitions cannot be negative");
        }

        return s.repeat(n);
    }

    public static int countOccurrence(String str, String substr) {
        if (Objects.equals(substr, "")) {
            throw new ArithmeticException("A substring cannot be empty");
        }
        if (substr == null) {
            throw new NullPointerException("A substring cannot equal null");
        }

        int tmp = 0, count = 0;
        while (tmp != -1) {
            tmp = str.indexOf(substr, tmp);
            if (tmp != -1) {
                count++;
                tmp++;
            }
        }

        return count;
    }

    public static String numberSubstitution(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                sb.append("one");
            } else if (str.charAt(i) == '2') {
                sb.append("two");
            } else if (str.charAt(i) == '3') {
                sb.append("three");
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();

//        Or you can use str.replace
    }
}