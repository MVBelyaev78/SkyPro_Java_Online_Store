package org.skypro.skyshop.product;

public final class DiscountedProduct extends Product {
    private Integer basePrice;
    private Integer discountPercent;

    public DiscountedProduct(String name, Integer basePrice, Integer discountPercent) {
        super(name);
        setBasePrice(basePrice);
        setDiscountPercent(discountPercent);
    }

    public Integer getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Integer basePrice) {
        if (basePrice == null || basePrice <= 0) {
            throw new IllegalArgumentException("Invalid input: base price cannot be equal or less than zero");
        }
        this.basePrice = basePrice;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        if (discountPercent == null || discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Invalid input: discount percent must be between 0 and 100");
        }
        this.discountPercent = discountPercent;
    }

    public Integer getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s%%)", name, basePrice, discountPercent);
    }

    public Boolean isSpecial() {
        return true;
    }
}
