package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final Integer price;

    public SimpleProduct(String name, Integer price) {
        super(name);
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, price);
    }
}
