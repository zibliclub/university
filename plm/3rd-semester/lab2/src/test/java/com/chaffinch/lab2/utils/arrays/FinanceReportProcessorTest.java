package com.chaffinch.lab2.utils.arrays;

import com.chaffinch.lab2.utils.arrays.FinanceReport;
import com.chaffinch.lab2.utils.arrays.FinanceReportProcessor;
import com.chaffinch.lab2.utils.arrays.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinanceReportProcessorTest {
    @Test
    @DisplayName("11-12. Checking methods of FinanceReportProcessor class")
    void testFinanceReportProcessor() {
        Payment payment1 = new Payment(
                "Zablotsky Danil Andreevich",
                19, 7, 2023,
                10000
        );
        Payment payment2 = new Payment(
                "Noname Noname Noname",
                19, 8, 2023,
                20000
        );
        Payment payment3 = new Payment(
                "Zablotsky Ivan Andreevich",
                19, 7, 2023,
                30000
        );

        FinanceReport fr = new FinanceReport(
                new Payment[]{payment1, payment2, payment3},
                "Zablotsky Ilya Andreevich",
                20, 11, 2023
        );

        assertEquals(
                new FinanceReport(
                        new Payment[]{payment1, payment3},
                        "Zablotsky Ilya Andreevich",
                        20, 11, 2023
                ),
                FinanceReportProcessor.getPaymentsFromPeopleWithLetter(fr, 'Z'),
                "The getPaymentsFromPeopleWithLetter method should return payments whose username begins " +
                        "with the specified character"
        );

        assertEquals(
                new FinanceReport(
                        new Payment[]{payment1, payment2},
                        "Zablotsky Ilya Andreevich",
                        20, 11, 2023
                ),
                FinanceReportProcessor.getPaymentsAmountsLess(fr, 25000),
                "The getPaymentsAmountsLess method should return payments whose amount is less than the " +
                        "specified amount"
        );

        assertEquals(
                40000,
                FinanceReportProcessor.getTotalAmountPerDay(fr, "19.07.2023"),
                "The getTotalAmountPerDay method should return the total amount of payments for the given date"
        );

        assertEquals(
                new ArrayList<>(
                        List.of("JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY",
                                "JUNE", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER")
                ),
                FinanceReportProcessor.getMonthsWithoutPaymentsAYear(fr, 2023),
                "The getMonthsWithoutPaymentsAYear method should output a list of months in which no " +
                        "payments occurred in a given year"
        );
    }
}