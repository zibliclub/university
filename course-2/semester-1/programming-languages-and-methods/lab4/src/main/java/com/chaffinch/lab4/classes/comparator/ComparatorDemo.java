package com.chaffinch.lab4.classes.comparator;

import com.chaffinch.lab3.utils.classes.products.foundation.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void sortGoods(Product[] products, Comparator<Product> comparator) {
        Arrays.sort(products, comparator);
    }
}