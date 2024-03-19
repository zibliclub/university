package com.chaffinch.lab3.utils.classes.products.foundation;

import java.util.Objects;

public class Pack {
    private final String name;
    private final int weight;

    public Pack(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pack aPack = (Pack) o;
        return Double.compare(weight, aPack.weight) == 0 && Objects.equals(name, aPack.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "Pack name: " + name +
                ", weight: " + weight + ";";
    }
}