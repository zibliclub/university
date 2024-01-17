package com.chaffinch.lab2.utils.arrays;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor {
    public static FinanceReport getPaymentsFromPeopleWithLetter(FinanceReport fr, char letter) {
        ArrayList<Payment> list = new ArrayList<>();
        int count = 0;
        for (Payment payment : fr.getPayments()) {
            if (payment.getFullName().charAt(0) == letter) {
                list.add(payment);
                count++;
            }
        }

        return new FinanceReport(
                list.toArray(new Payment[count]),
                fr.getFullName(),
                fr.getDay(),
                fr.getMonth(),
                fr.getYear()
        );
    }

    public static FinanceReport getPaymentsAmountsLess(FinanceReport fr, int amount) {
        ArrayList<Payment> list = new ArrayList<>();
        int count = 0;
        for (Payment payment : fr.getPayments()) {
            if (payment.getAmount() < amount) {
                list.add(payment);
                count++;
            }
        }

        return new FinanceReport(
                list.toArray(new Payment[count]),
                fr.getFullName(),
                fr.getDay(),
                fr.getMonth(),
                fr.getYear()
        );
    }

    public static int getTotalAmountPerDay(FinanceReport fr, String date) {
        int totalAmount = 0;
        for (Payment payment : fr.getPayments()) {
            if (String.format("%02d.%02d.%d", payment.getDay(), payment.getMonth(), payment.getYear()).equals(date)) {
                totalAmount += payment.getAmount();
            }
        }

        return totalAmount;
    }

    public static List getMonthsWithoutPaymentsAYear(FinanceReport fr, int year) {
        List<String> list = new ArrayList<>(
                List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")
        );

        for (Payment payment : fr.getPayments()) {
            if (payment.getYear() == year) {
                list.remove(Integer.toString(payment.getMonth()));
            }
        }

        list.replaceAll(s -> Month.of(Integer.parseInt(s)).toString());

        return list;
    }
}
