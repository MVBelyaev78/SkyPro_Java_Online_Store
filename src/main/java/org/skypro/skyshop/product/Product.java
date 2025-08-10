package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    protected final String name;

    protected Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Integer getPrice();

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
    public abstract String toString();

    public abstract Boolean isSpecial();
}
