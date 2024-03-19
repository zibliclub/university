package com.chaffinch.lab3.utils;

import com.chaffinch.lab3.utils.classes.filters.BeginStringFilter;
import com.chaffinch.lab3.utils.classes.filters.ContainsFilter;
import com.chaffinch.lab3.utils.classes.filters.UpperCaseFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FilterTest {
    @Test
    @DisplayName("2.1 Checking the functionality of the BeginStringFilter class")
    void testBeginStringFilter() {
        String str = "Lorem Ipsum";
        BeginStringFilter filter1 = new BeginStringFilter("Lorem");
        BeginStringFilter filter2 = new BeginStringFilter("IPSUM");

        System.out.println(
                str + "\n" +
                        "Pattern 1: " + filter1.getPattern() + "\n" +
                        "Pattern 2: " + filter2.getPattern()
        );

        assertTrue(
                filter1.apply(str),
                "Should return true if the string begins with the substring PATTERN"
        );
        assertFalse(
                filter2.apply(str),
                "Should not return true unless the string begins with the substring PATTERN"
        );
    }

    @Test
    @DisplayName("2.2 Checking the functionality of the UpperCaseFilter class")
    void testUpperCaseFilter() {
        String str1 = "Lorem Ipsum";
        String str2 = "LOREM IPSUM";
        UpperCaseFilter filter = new UpperCaseFilter();

        System.out.println(
                str1 + "\n" +
                        str2
        );

        assertFalse(
                filter.apply(str1),
                "Should return false if the string is not uppercase characters"
        );
        assertTrue(
                filter.apply(str2),
                "Should return true if the string consists of uppercase characters"
        );
    }

    @Test
    @DisplayName("2.3 Checking the functionality of the ContainsFilter class")
    void testContainsFilter() {
        String str = "Lorem Ipsum";
        ContainsFilter filter1 = new ContainsFilter("ipsum");
        ContainsFilter filter2 = new ContainsFilter("Ipsum");

        System.out.println(
                str + "\n" +
                        "Sequence 1: " + filter1.getSequence() + "\n" +
                        "Sequence 2: " + filter2.getSequence()
        );

        assertFalse(
                filter1.apply(str),
                "Should return false if there is no SEQUENCE substring in the string"
        );
        assertTrue(
                filter2.apply(str),
                "Should return true if the string contains the substring SEQUENCE"
        );
    }
}