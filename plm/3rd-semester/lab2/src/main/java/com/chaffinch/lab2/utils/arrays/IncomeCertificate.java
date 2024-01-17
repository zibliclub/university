package com.chaffinch.lab2.utils.arrays;

import java.util.Arrays;

public record IncomeCertificate(int year, String fullName, String organization, double[] amounts) {
    public IncomeCertificate(int year, String fullName, String organization, double[] amounts) {
        this.year = year;
        this.fullName = fullName;
        this.organization = organization;
        this.amounts = Arrays.copyOf(amounts, 12);
    }
}