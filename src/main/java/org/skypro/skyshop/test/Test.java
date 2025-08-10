package org.skypro.skyshop.test;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class Test {
    private final ProductBasket productBasket = new ProductBasket("Mikhail");
    private final Product[] testCase = {
            new SimpleProduct("Pear", 150),
            new DiscountedProduct("Pear", 150, 25),
            new SimpleProduct("Mango", 1100)
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
        productBasket.addProduct(new SimpleProduct("Grape", 450));
        productBasket.addProduct(new SimpleProduct("Sweet cherry", 900));
        productBasket.addProduct(new SimpleProduct("Peach", 500));
        productBasket.addProduct(new DiscountedProduct("Apple", 250, 35));
        productBasket.addProduct(new DiscountedProduct("Pear", 550, 0));
        productBasket.addProduct(new DiscountedProduct("Tomato", 300, 70));
        productBasket.addProduct(new FixPriceProduct("Cucumber"));
        productBasket.addProduct(new FixPriceProduct("Potato"));
        productBasket.addProduct(new FixPriceProduct("Sweet potato"));
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
