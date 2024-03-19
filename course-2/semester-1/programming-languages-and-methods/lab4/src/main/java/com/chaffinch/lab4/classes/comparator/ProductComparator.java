package com.chaffinch.lab4.classes.comparator;

import com.chaffinch.lab3.utils.classes.products.foundation.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        final int nameComparison = product1.getName().compareTo(product2.getName());

        return nameComparison == 0 ?
                product1.getDescription().compareTo(product2.getDescription()) : nameComparison;
    }
}