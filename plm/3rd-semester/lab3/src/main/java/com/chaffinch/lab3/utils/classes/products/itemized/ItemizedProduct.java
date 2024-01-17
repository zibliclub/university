package com.chaffinch.lab3.utils.classes.products.itemized;

import com.chaffinch.lab3.utils.classes.products.foundation.Product;

import java.util.Objects;

public class ItemizedProduct extends Product {
    private final int unitWeight;
    public ItemizedProduct(String name, String description, int unitWeight) {
        super(name, description);
        this.unitWeight = unitWeight;
    }

    public int getUnitWeight() {
        return unitWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemizedProduct that = (ItemizedProduct) o;
        return Double.compare(unitWeight, that.unitWeight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unitWeight);
    }

    @Override
    public String toString() {
        return "ItemizedProduct{" +
                "unitWeight=" + unitWeight +
                '}';
    }
}
