package org.skypro.skyshop.product;

public final class FixPriceProduct extends Product {
    private static final Integer FIX_PRICE = 350;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public Integer getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return String.format("%s: Фиксированная цена %s", name, FIX_PRICE);
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }
}
