package com.chaffinch.lab3.utils.classes.products;

import com.chaffinch.lab3.utils.classes.products.foundation.Pack;
import com.chaffinch.lab3.utils.interfaces.PackedProduct;

import java.util.Arrays;
import java.util.Objects;

public class PackedSetProducts implements PackedProduct {
    private final String name;
    private final PackedProduct[] products;
    private final Pack pack;

    public PackedSetProducts(String name, PackedProduct[] products, Pack pack) {
        this.name = name;
        this.products = products;
        this.pack = pack;
    }

    public String getName() {
        return name;
    }

    public PackedProduct[] getProducts() {
        return products;
    }

    @Override
    public int getNetto() {
        int weight = 0;
        for (PackedProduct product : products) {
            weight += product.getBrutto();
        }
        return weight;
    }

    @Override
    public int getBrutto() {
        return getNetto() + pack.getWeight();
    }

    @Override
    public String toString() {
        return "\n\n\t\tPacked Set of Products: " + this.getName() +
                "\n\t\tNetto: " + getNetto() +
                "\n\t\tBrutto: " + getBrutto() +
                "\n\t\t" + pack +
                "\n\t\tProducts: " + Arrays.toString(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackedSetProducts that = (PackedSetProducts) o;
        return Objects.equals(name, that.name) && Arrays.equals(products, that.products) && Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, pack);
        result = 31 * result + Arrays.hashCode(products);
        return result;
    }
}