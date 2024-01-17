package com.chaffinch.lab2.utils.strings;

import com.chaffinch.lab2.utils.strings.StringProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.MethodName.class)
class StringProcessorTest {
    @Test
    @DisplayName("1. String repetition check")
    void testRepeat() {
        assertEquals(
                "Test",
                StringProcessor.repeat("Test", 1),
                "Should leave a line if 1 repetition is entered"
        );

        assertEquals(
                "TestTestTest",
                StringProcessor.repeat("Test", 3),
                "Should repeat the string"
        );

        assertEquals(
                "",
                StringProcessor.repeat("Test", 0),
                "Should output an empty string when 0 is entered"
        );

        assertThrows(IllegalArgumentException.class, () -> StringProcessor.repeat("Test", -10));
    }

    @Test
    @DisplayName("2. Counting the number of occurrences")
    void testCountOccurrence() {
        assertEquals(
                5,
                StringProcessor.countOccurrence("TestTestTestTestTest", "Test"),
                "Must count the number of occurrences"
        );

        assertEquals(
                100,
                StringProcessor.countOccurrence(StringProcessor.repeat("Test", 100), "Test"),
                "Must count the number of occurrences"
        );
        assertEquals(2, StringProcessor.countOccurrence("aaa", "aa"));
        assertEquals(
                2,
                StringProcessor.countOccurrence("aaa", "aa"),
                "Must count the number of occurrences"
        );

        assertThrows(ArithmeticException.class, () -> StringProcessor.countOccurrence("Test", ""));

        assertThrows(NullPointerException.class, () -> StringProcessor.countOccurrence("Test", null));
    }

    @Test
    @DisplayName("3. Replacing the numbers 1, 2, 3 with the words 'one', 'two', 'three'")
    void testReplacingWithWords() {
        assertEquals(
                "I have one friend, two parents and three dogs",
                StringProcessor.numberSubstitution("I have 1 friend, 2 parents and 3 dogs"),
                "Must replace numbers with words"
        );
        assertEquals(
                "threeonetwo",
                StringProcessor.numberSubstitution("312"),
                "Must replace numbers with words"
        );
    }

    @Test
    @DisplayName("4. Deleting every second character in StringBuilder")
    void testDeletionEven() {
        StringBuilder sb = new StringBuilder("10203040506070809");
        StringProcessor.deletionEven(sb);
        assertEquals(
                "123456789",
                sb.toString(),
                "Must delete characters in even-numbered places"
        );
    }

    @Test
    @DisplayName("5. Swaps words around, leaving gaps")
    void testReverseOrderWords() {
        assertEquals(
                "   Wonderful       weather today   !  ",
                StringProcessor.reverseOrderWords("   !       today weather   Wonderful  "),
                "Must swap words around, leaving the same number of spaces"
        );

        assertEquals(
                "   aaa       bb aaa   ccccc  ",
                StringProcessor.reverseOrderWords("   ccccc       aaa bb   aaa  "),
                "Should work with the same words"
        );
    }

    @Test
    @DisplayName("6. Replacing hexadecimal numbers like 0xNNNNNNNN with decimal numbers")
    void testHexToDec() {
        assertEquals(
                "10 watermelons, 2452 airplanes and 123 cars",
                StringProcessor.hexToDec("0x0000000A watermelons, 0x00000994 airplanes and 0x0000007B cars"),
                "Must replace hexadecimal with decimal"
        );

        assertEquals(
                "10 0xLKDSFNOD 0x 16",
                StringProcessor.hexToDec("0x0000000A 0xLKDSFNOD 0x 0x00000010"),
                "Must not replace non-hexadecimal "
        );
    }
}