package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductBasket {
    private String owner;
    private final List<Product> products = new ArrayList<>();

    public ProductBasket(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        String result = products
                .stream()
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
        if (!products.isEmpty()) {
            result += String.format("\nИтого: %s", getProductsCost());
        } else {
            result = "в корзине пусто";
        }
        return result;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Integer getProductsCost() {
        return products
                .stream()
                .map(Product::getPrice)
                .reduce(0, Integer::sum);
    }

    public boolean checkProductInBasket(Product product) {
        return products
                .stream()
                .anyMatch(p -> p.equals(product));
    }

    public boolean checkProductByNameInBasket(String productName) {
        return products
                .stream()
                .map(Product::getName)
                .anyMatch(name -> name.equals(productName));
    }

    public void clear() {
        products.clear();
    }
}
