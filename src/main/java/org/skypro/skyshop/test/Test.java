package org.skypro.skyshop.test;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Test {
    private final ProductBasket productBasket = new ProductBasket("Mikhail");
    private final Product[] testCase = {
            new Product("Pier", 150),
            new Product("Mango", 1100)
    };

    public Test() {
    }

    public void runAllTestSuites() {
        runTestSuite1();
        runTestSuite2();
    }

    private void runTestSuite1() {
        System.out.println("------------------------------");
        System.out.println("        Пустая корзина        ");
        System.out.println("------------------------------");
        clearBasket();
        runAllCases();
    }

    private void runTestSuite2() {
        System.out.println("------------------------------");
        System.out.println("     Заполненная корзина      ");
        System.out.println("------------------------------");
        fillBasket();
        runAllCases();
    }

    private void runAllCases() {
        printBasket();
        System.out.println();
        printBasketCost();
        System.out.println();
        printSearchProducts();
        printSearchProductsByName();
        System.out.println();
    }

    private void fillBasket() {
        productBasket.addProduct(new Product("Grape", 450));
        productBasket.addProduct(new Product("Sweet cherry", 900));
        productBasket.addProduct(new Product("Peach", 500));
        productBasket.addProduct(new Product("Apple", 250));
        productBasket.addProduct(new Product("Pier", 550));
        productBasket.addProduct(new Product("Tomato", 300));
        productBasket.addProduct(new Product("Cucumber", 200));
        productBasket.addProduct(new Product("Potato", 100));
        productBasket.addProduct(new Product("Sweet potato", 500));
    }

    private void clearBasket() {
        productBasket.clear();
    }

    private void printBasket() {
        System.out.println(productBasket);
    }

    private void printBasketCost() {
        System.out.println(productBasket.getProductsCost());
    }

    private void printSearchProducts() {
        for (Product product : testCase) {
            System.out.printf("%s: %s%n",
                    product.getName(),
                    productBasket.checkProductInBasket(product));
        }
    }

    private void printSearchProductsByName() {
        for (Product product : testCase) {
            System.out.printf("%s: %s%n",
                    product.getName(),
                    productBasket.checkProductByNameInBasket(product.getName()));
        }
    }
}
