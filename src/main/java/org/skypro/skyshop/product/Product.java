package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
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

    public String getSearchTerm() {
        return name;
    }

    public String getContentName() {
        return name;
    }

    public String getContentType() {
        return "PRODUCT";
    }
}
