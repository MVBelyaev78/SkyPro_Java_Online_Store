package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.IllegalPercentException;

public class DiscountedProduct extends Product {
    private final Integer basePrice;
    private final Integer discountPercent;

    public DiscountedProduct(String name, Integer basePrice, Integer discountPercent) {
        super(name);
        this.basePrice = basePrice;
        if (discountPercent < 0 || discountPercent >= 100) {
            throw new IllegalPercentException();
        }
        this.discountPercent = discountPercent;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public Integer getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }

    @Override
    public String toString() {
        return String.format("%s: %s, %s%%", name, basePrice, discountPercent);
    }
}
