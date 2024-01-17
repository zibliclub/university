package com.chaffinch.lab3.utils.classes.products;

import com.chaffinch.lab3.utils.interfaces.PackedProduct;

import java.util.Arrays;
import java.util.Objects;

public class ProductsBatch {
    private final String description;
    private final PackedProduct[] products;

    public ProductsBatch(String description, PackedProduct[] products) {
        this.description = description;
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public PackedProduct[] getProducts() {
        return products;
    }

    public int getWeight() {
        int weight = 0;
        for (PackedProduct product : products) {
            weight += product.getBrutto();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Products Batch description: " + description +
                ", weight: " + getWeight() +
                ".\n\tProducts: " + Arrays.toString(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsBatch that = (ProductsBatch) o;
        return Objects.equals(description, that.description) && Arrays.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(description);
        result = 31 * result + Arrays.hashCode(products);
        return result;
    }
}
