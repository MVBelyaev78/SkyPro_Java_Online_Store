package org.skypro.skyshop.test;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private final ProductBasket productBasket = new ProductBasket("Mikhail");
    private final Product[] testCaseBasket = {
            new SimpleProduct("Pear", 150),
            new DiscountedProduct("Pear", 150, 25),
            new SimpleProduct("Mango", 1100)
    };
    private final List<Article> articles = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final SearchEngine searchEngine = new SearchEngine();
    private final String[] testCaseSearchEngine = {
            "singing",
            "apple",
            "yesterday",
            "lately thinking",
            "I don't know she wouldn't say",
            "Grape",
            "unknown qwerty",
            "unknown asdfgh"
    };

    public Test() {
    }

    public void runAllTestSuites() {
        runTestSuite1();
        runTestSuite2();
        runTestSuite3();
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

    private void runTestSuite3() {
        System.out.println("------------------------------");
        System.out.println("        Поисковый движок      ");
        System.out.println("------------------------------");
        fillArticlesList();
        fillProductsList();
        fillSearchEngine();
        useSearchEngine();
    }

    private void runAllCases() {
        printBasket();
        System.out.println();
        printBasketCost();
        System.out.println();
        printFindProducts();
        printFindProductsByName();
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

    private void printFindProducts() {
        for (Product product : testCaseBasket) {
            System.out.printf("%s: %s%n",
                    product.getName(),
                    productBasket.checkProductInBasket(product));
        }
    }

    private void printFindProductsByName() {
        for (Product product : testCaseBasket) {
            System.out.printf("%s: %s%n",
                    product.getName(),
                    productBasket.checkProductByNameInBasket(product.getName()));
        }
    }

    private void useSearchEngine() {
        for (String str : testCaseSearchEngine) {
            searchEngine.search(str).forEach(System.out::println);
        }
    }

    private void fillSearchEngine() {
        articles.forEach(searchEngine::add);
        products.forEach(searchEngine::add);
    }

    private void fillArticlesList() {
        articles.add(new Article("Yesterday", 
                "Why she had to go I don't know she wouldn't say"));
        articles.add(new Article("Thank You for the Music", 
                "I began singing before I could talk"));
        articles.add(new Article("Poems, Prayers and Promises", 
                "I've been lately thinking about my life's time"));
    }

    private void fillProductsList() {
        products.add(new SimpleProduct("Grape", 450));
        products.add(new DiscountedProduct("Apple", 250, 35));
        products.add(new FixPriceProduct("Cucumber"));
    }
}
