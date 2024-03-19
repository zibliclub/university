package com.chaffinch.lab2.utils.strings;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("0x([A-Fa-f0-9]+)");

    public static String repeat(String s, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of repetitions cannot be negative");
        }

        return s.repeat(n);
    }

    public static int countOccurrence(String str, String substring) {
        if (Objects.equals(substring, "")) {
            throw new ArithmeticException("A substring cannot be empty");
        }
        if (substring == null) {
            throw new NullPointerException("A substring cannot equal null");
        }

        int tmp = 0, count = 0;
        while (tmp != -1) {
            tmp = str.indexOf(substring, tmp);
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

    public static void deletionEven(StringBuilder sb) {
        for (int i = 1; i < sb.length(); i++) {
            sb.deleteCharAt(i);
        }
    }

    public static String reverseOrderWords(String str) {
        String[] words = str.trim().split("\\s+");
        int wordNumber = words.length - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append(str.charAt(i));
            } else {
                sb.append(words[wordNumber]);
                wordNumber--;
                i = str.indexOf(' ', i) - 1;
            }
        }

        return sb.toString();

//        You can do it with replace
    }

    public static String hexToDec(String str) {
        Matcher matcher = HEXADECIMAL_PATTERN.matcher(str);

        StringBuilder sb = new StringBuilder(str);
        String hexNum;
        while (matcher.find()) {
            hexNum = matcher.group(1);
            sb.replace(
                    sb.indexOf(hexNum) - 2,
                    sb.indexOf(hexNum) + hexNum.length(),
                    String.valueOf(Long.parseLong(hexNum, 16))
            );
        }

        return sb.toString();
    }
}