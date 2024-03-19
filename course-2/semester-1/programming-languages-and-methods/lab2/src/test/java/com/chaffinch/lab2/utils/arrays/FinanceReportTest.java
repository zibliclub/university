package com.chaffinch.lab2.utils.arrays;

import com.chaffinch.lab2.utils.arrays.FinanceReport;
import com.chaffinch.lab2.utils.arrays.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class FinanceReportTest {
    @Test
    @DisplayName("9. Checking output via toString in a specific format")
    void testToString() {
        Payment payment1 = new Payment(
                "Zablotsky Danil Andreevich",
                19, 11, 2023,
                99999
        );
        Payment payment2 = new Payment(
                "Zablotsky Ivan Andreevich",
                18, 7, 2023,
                199999
        );

        FinanceReport fr = new FinanceReport(
                new Payment[]{payment1, payment2},
                "Zablotsky Ilya Andreevich",
                20, 11, 2023
        );

        System.out.println(fr);

        fr.setPayments(new Payment[0]);

        System.out.println("\n" + fr);
    }

    @Test
    @DisplayName("10. Copy constructor")
    void testFinanceReport() {
        Payment payment1 = new Payment(
                "Zablotsky Danil Andreevich",
                19, 11, 2023,
                99999
        );
        Payment payment2 = new Payment(
                "Zablotsky Ivan Andreevich",
                18, 7, 2023,
                199999
        );

        FinanceReport fr1 = new FinanceReport(
                new Payment[]{payment1, payment2},
                "Zablotsky Ilya Andreevich",
                20, 11, 2023
        );

        FinanceReport fr2 = new FinanceReport(fr1);

        fr1.setPayment(0, new Payment("Noname Noname Noname", 1, 1, 1999, 100));

        System.out.println(fr1 + "\n\n" + fr2);

        assertNotEquals(fr1, fr2);
    }
}