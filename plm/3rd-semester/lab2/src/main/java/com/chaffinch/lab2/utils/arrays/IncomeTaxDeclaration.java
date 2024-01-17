package com.chaffinch.lab2.utils.arrays;

import java.util.Arrays;

public class IncomeTaxDeclaration {
    private static final int MONTHS_PER_YEAR = 12;
    private static final double MEDIAN_INCOME = 24000;
    private static final double HIGH_INCOME = 240000;
    private static final double MEDIAN_TAX = 0.13;
    private static final double HIGH_TAX = 0.20;
    private final int year;
    private final String fullName;
    private final double[] income = new double[MONTHS_PER_YEAR];
    private final double[] totalIncome = new double[MONTHS_PER_YEAR];
    private final double[] taxes = new double[MONTHS_PER_YEAR];
    private final double totalTax;

    public IncomeTaxDeclaration(int year, String fullName, IncomeCertificate[] certificates) {
        this.year = year;
        this.fullName = fullName;

        for (int month = 0; month < MONTHS_PER_YEAR; month++) {
            for (IncomeCertificate certificate : certificates) income[month] += certificate.amounts()[month];

            totalIncome[month] = month == 0 ? income[0] : income[month] + totalIncome[month - 1];

            taxes[month] = month == 0 ?
                    calculateTax(0, income[month], income[month]) :
                    calculateTax(totalIncome[month - 1], totalIncome[month], income[month]);
        }


        this.totalTax = Arrays.stream(this.taxes).sum();
    }

    private static double calculateTax(double previousTotalIncome, double currentTotalIncome, double lastIncome) {
        if (currentTotalIncome <= MEDIAN_INCOME) return 0;

        if (currentTotalIncome <= HIGH_INCOME) return (previousTotalIncome <= MEDIAN_INCOME) ?
                (currentTotalIncome - MEDIAN_INCOME) * MEDIAN_TAX : lastIncome * MEDIAN_TAX;

        return (previousTotalIncome <= HIGH_INCOME) ?
                (HIGH_INCOME - previousTotalIncome) * MEDIAN_TAX + (currentTotalIncome - HIGH_INCOME) * HIGH_TAX :
                lastIncome * HIGH_TAX;
    }

    public int getYear() {
        return year;
    }

    public String getFullName() {
        return fullName;
    }

    public double[] getIncome() {
        return income;
    }

    public double[] getTotalIncome() {
        return totalIncome;
    }

    public double[] getTaxes() {
        return taxes;
    }

    public double getTotalTax() {
        return totalTax;
    }
}
