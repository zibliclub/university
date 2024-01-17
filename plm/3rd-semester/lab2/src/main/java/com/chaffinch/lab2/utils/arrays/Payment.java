package com.chaffinch.lab2.utils.arrays;

import java.util.Objects;

public class Payment {
    private String fullName;

    private int day;
    private int month;
    private int year;

    private int amount;

    public Payment(String fullName, int day, int month, int year, int amount) {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public Payment(Payment payment) {
        this(
                payment.fullName,
                payment.day,
                payment.month,
                payment.year,
                payment.amount
        );
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day && month == payment.month && year == payment.year && amount == payment.amount && Objects.equals(fullName, payment.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, amount);
    }

    @Override
    public String toString() {
        return String.format(
                "Compiler: %s, date: %02d.%02d.%d amount: %d rub. %d kop.,\n",
                getFullName(),
                getDay(), getMonth(), getYear(),
                getAmount() / 100, getAmount() % 100
        );
    }
}
