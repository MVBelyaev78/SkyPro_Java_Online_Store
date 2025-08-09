package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
    private final String name;
    private final Integer cost;

    public Product(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Product that = (Product) object;
        return Objects.equals(this.name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, cost);
    }
}
