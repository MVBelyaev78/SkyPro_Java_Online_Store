package org.skypro.skyshop.product;

public final class SimpleProduct extends Product {
    private Integer price;

    public SimpleProduct(String name, Integer price) {
        super(name);
        setPrice(price);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Invalid input: price cannot be equal or less than zero");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, price);
    }

    public Boolean isSpecial() {
        return false;
    }
}
