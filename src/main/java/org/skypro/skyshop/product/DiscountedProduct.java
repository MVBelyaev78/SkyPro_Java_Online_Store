package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.IllegalPercentException;

public class DiscountedProduct extends Product {
    private Integer basePrice;
    private Integer discountPercent;

    public DiscountedProduct(String name, Integer basePrice, Integer discountPercent) {
        super(name);
        this.basePrice = basePrice;
        checkDiscountPercent(discountPercent);
        this.discountPercent = discountPercent;
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        checkDiscountPercent(discountPercent);
        this.discountPercent = discountPercent;
    }

    public Integer getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }

    @Override
    public String toString() {
        return String.format("%s: %s, %s%%", name, basePrice, discountPercent);
    }

    private void checkDiscountPercent(Integer discountPercent) {
        if (discountPercent < 0 || discountPercent >= 100) {
            throw new IllegalPercentException();
        }
    }
}
