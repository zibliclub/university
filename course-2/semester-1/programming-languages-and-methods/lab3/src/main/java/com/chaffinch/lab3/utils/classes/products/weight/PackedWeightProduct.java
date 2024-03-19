package com.chaffinch.lab3.utils.classes.products.weight;

import com.chaffinch.lab3.utils.classes.products.foundation.Pack;
import com.chaffinch.lab3.utils.interfaces.PackedProduct;

import java.util.Objects;

public class PackedWeightProduct extends WeightProduct implements PackedProduct {
    private final Pack pack;
    private final int weight;

    public PackedWeightProduct(WeightProduct weightProduct, int weight, Pack pack) {
        super(weightProduct.getName(), weightProduct.getDescription());
        this.pack = pack;
        this.weight = weight;
    }

    @Override
    public int getNetto() {
        return weight;
    }

    @Override
    public int getBrutto() {
        return weight + pack.getWeight();
    }

    public Pack getPack() {
        return pack;
    }

    @Override
    public String toString() {
        return "\n\n\t\tPacked Weight Product: " + this.getName() +
                "\n\t\tNetto: " + getNetto() +
                "\n\t\tBrutto: " + getBrutto() +
                "\n\t\t" + pack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackedWeightProduct that = (PackedWeightProduct) o;
        return weight == that.weight && Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pack, weight);
    }
}
