package org.skypro.skyshop.product;

public final class SimpleProduct extends Product {
    private Integer price;

    public SimpleProduct(String name, Integer price) {
        super(name);
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, price);
    }

    @Override
    public Boolean isSpecial() {
        return false;
    }
}
