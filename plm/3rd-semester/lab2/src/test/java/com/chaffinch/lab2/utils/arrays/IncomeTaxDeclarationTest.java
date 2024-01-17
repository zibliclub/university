package com.chaffinch.lab2.utils.arrays;

import com.chaffinch.lab2.utils.arrays.IncomeCertificate;
import com.chaffinch.lab2.utils.arrays.IncomeTaxDeclaration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomeTaxDeclarationTest {
    private static IncomeCertificate[] getIncomeCertificates() {
        IncomeCertificate certificate1 = new IncomeCertificate(
                2023,
                "Zablotsky Danil Andreevich",
                "FDTC",
                new double[]{
                        1000, 2000, 3000, 4000,
                        50000, 40000, 30000, 20000,
                        10000, 20000, 30000, 40000
                }
        );
        IncomeCertificate certificate2 = new IncomeCertificate(
                2023,
                "Zablotsky Danil Andreevich",
                "OmSU",
                new double[]{
                        5000, 4000, 3000, 4000,
                        10000, 20000, 30000, 40000,
                        90000, 80000, 70000, 60000
                }
        );

        return new IncomeCertificate[]{certificate1, certificate2};
    }

    @Test
    @DisplayName("13. Checking correctness of IncomeTaxDeclaration class operation")
    void testIncomeTaxDeclaration() {
        IncomeTaxDeclaration declaration = new IncomeTaxDeclaration(
                2023,
                "Zablotsky Danil Andreevich",
                getIncomeCertificates()
        );

        double[] correctTaxes = {
                0, 0, 0, 2000 * 0.13,
                60000 * 0.13, 60000 * 0.13, 60000 * 0.13, 34000 * 0.13 + 26000 * 0.2,
                100000 * 0.2, 100000 * 0.2, 100000 * 0.2, 100000 * 0.2

        };

        assertArrayEquals(
                correctTaxes,
                declaration.getTaxes(),
                "Arrays with taxes must match"
        );
        assertEquals(
                Arrays.stream(correctTaxes).sum(),
                declaration.getTotalTax(),
                "The final tax must be the same as the sum of all taxes"
        );
    }
}