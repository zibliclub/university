package com.chaffinch.lab2.utils.arrays;

import java.util.Arrays;
import java.util.Objects;

public class FinanceReport {
    private Payment[] payments;
    private String fullName;

    private int day;
    private int month;
    private int year;

    public FinanceReport(Payment[] payments, String fullName, int day, int month, int year) {
        this.payments = payments;
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public FinanceReport(FinanceReport financeReport) {
        this.payments = new Payment[financeReport.payments.length];
        for (int i = 0; i < financeReport.payments.length; i++) {
            this.payments[i] = new Payment(financeReport.payments[i]);
        }

        this.fullName = financeReport.fullName;
        this.day = financeReport.day;
        this.month = financeReport.month;
        this.year = financeReport.year;
    }

    public int getCountPayments() {
        return payments.length;
    }

    public Payment getPayment(int i) {
        return payments[i];
    }

    public void setPayment(int i, Payment payment) {
        this.payments[i] = payment;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceReport that = (FinanceReport) o;
        return day == that.day && month == that.month && year == that.year && Arrays.equals(payments, that.payments) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fullName, day, month, year);
        result = 31 * result + Arrays.hashCode(payments);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("[Author: %s, date: %02d.%02d.%d, Payments: [\n",
                fullName, day, month, year)
        );

        if (getCountPayments() != 0) {
            for (Payment i : payments) {
                sb.append("\t").append(i.toString());
            }
            sb.replace(sb.length() - 2, sb.length(), "").append("]]");
        } else {
            sb.replace(sb.length() - 2, sb.length(), "").append("None]");
        }

        return sb.toString();
    }
}
