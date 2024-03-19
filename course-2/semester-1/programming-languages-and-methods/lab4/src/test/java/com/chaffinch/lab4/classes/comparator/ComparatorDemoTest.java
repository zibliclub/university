package com.chaffinch.lab4.classes.comparator;

import com.chaffinch.lab3.utils.classes.products.foundation.Product;
import com.chaffinch.lab3.utils.classes.products.itemized.ItemizedProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ComparatorDemoTest {
    private final Product[] input1 = new Product[]{
            new Product(
                    "Product 1",
                    "Description 2"
            ),
            new Product(
                    "Product 3",
                    "Description 1"
            ),
            new Product(
                    "Product 2",
                    "Description 1"
            ),
            new Product(
                    "Product 1",
                    "Description 1"
            ),
            new Product(
                    "Product 2",
                    "Description 2"
            ),
            new Product(
                    "Product 3",
                    "Description 2"
            )
    };
    private final Product[] input2 = new ItemizedProduct[]{
            new ItemizedProduct(
                    "Product 1",
                    "Description 2",
                    10
            ),
            new ItemizedProduct(
                    "Product 3",
                    "Description 1",
                    9
            ),
            new ItemizedProduct(
                    "Product 2",
                    "Description 1",
                    14
            ),
            new ItemizedProduct(
                    "Product 1",
                    "Description 1",
                    5
            ),
            new ItemizedProduct(
                    "Product 2",
                    "Description 2",
                    10
            ),
            new ItemizedProduct(
                    "Product 3",
                    "Description 2",
                    20
            )
    };
    private static final Product[] OUTPUT_1 = new Product[]{
            new Product(
                    "Product 1",
                    "Description 1"
            ),
            new Product(
                    "Product 1",
                    "Description 2"
            ),
            new Product(
                    "Product 2",
                    "Description 1"
            ),
            new Product(
                    "Product 2",
                    "Description 2"
            ),
            new Product(
                    "Product 3",
                    "Description 1"
            ),
            new Product(
                    "Product 3",
                    "Description 2"
            )
    };
    private static final Product[] OUTPUT_2 = new Product[]{
            new ItemizedProduct(
                    "Product 1",
                    "Description 1",
                    5
            ),
            new ItemizedProduct(
                    "Product 1",
                    "Description 2",
                    10
            ),
            new ItemizedProduct(
                    "Product 2",
                    "Description 1",
                    14
            ),
            new ItemizedProduct(
                    "Product 2",
                    "Description 2",
                    10
            ),
            new ItemizedProduct(
                    "Product 3",
                    "Description 1",
                    9
            ),
            new ItemizedProduct(
                    "Product 3",
                    "Description 2",
                    20
            )
    };

    @Test
    @DisplayName("3.3. Checking the functionality of the sortGoods method")
    public void testSortGoods() {
        ComparatorDemo.sortGoods(input1, new ProductComparator());
        ComparatorDemo.sortGoods(input2, new ProductComparator());

        assertArrayEquals(
                OUTPUT_1,
                input1,
                "Should sort the list in ascending order via a comparator"
        );
        assertArrayEquals(
                OUTPUT_2,
                input2,
                "Must sort the list in ascending order through a comparator," +
                        " even if the objects in it are not of the Product class, but its descendants"
        );
    }
}