package com.chaffinch.lab4.classes.comparator;

import com.chaffinch.lab3.utils.classes.products.foundation.Product;
import com.chaffinch.lab4.classes.comparator.ProductComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductComparatorTest {
    private final ProductComparator comparator = new ProductComparator();

    @Test
    @DisplayName("3.1. Checking the functionality of the ProductComparator class")
    public void testCompare() {
        assertEquals(
                0,
                comparator.compare(
                        new Product("Product 1", "Description"),
                        new Product("Product 1", "Description")
                ),
                "Should return 0 if titles and descriptions match"
        );
        assertEquals(
                -1, comparator.compare(
                        new Product("Product 1", "Description 1"),
                        new Product("Product 1", "Description 2")
                ),
                "Should return -1 if the names or descriptions do not match" +
                        " and the second product has something more"
        );
        assertEquals(
                1, comparator.compare(
                        new Product("Product 2", "Description"),
                        new Product("Product 1", "Description")
                ),
                "Should return 1 if the names or descriptions don't match" +
                        " and the first product has something more"
        );
    }
}