package com.chaffinch.lab3.utils.classes.products.itemized;

import com.chaffinch.lab3.utils.classes.products.foundation.Pack;
import com.chaffinch.lab3.utils.interfaces.PackedProduct;

import java.util.Objects;

public class PackedItemizedProduct extends ItemizedProduct implements PackedProduct {
    private final int quantity;
    private final Pack pack;

    public PackedItemizedProduct(ItemizedProduct itemizedProduct, int quantity, Pack pack) {
        super(itemizedProduct.getName(), itemizedProduct.getDescription(), itemizedProduct.getUnitWeight());
        this.quantity = quantity;
        this.pack = pack;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getNetto() {
        return getUnitWeight() * quantity;
    }

    @Override
    public int getBrutto() {
        return getNetto() + pack.getWeight();
    }

    @Override
    public String toString() {
        return "\n\n\t\tPacked Itemized Product: " + this.getName() +
                "\n\t\tQuantity: " + quantity +
                "\n\t\tNetto: " + getNetto() +
                "\n\t\tBrutto: " + getBrutto() +
                "\n\t\t" + pack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackedItemizedProduct that = (PackedItemizedProduct) o;
        return quantity == that.quantity && Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, pack);
    }
}
