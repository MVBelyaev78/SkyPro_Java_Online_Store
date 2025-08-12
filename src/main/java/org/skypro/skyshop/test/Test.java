package org.skypro.skyshop.test;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestSuitedNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private final ProductBasket productBasket = new ProductBasket("Mikhail");
    private final List<Product> testCaseBasket =  List.of(
            new SimpleProduct("Pear", 150),
            new DiscountedProduct("Pear", 150, 25),
            new SimpleProduct("Mango", 1100)
    );
    private final List<String> testCaseDeleteProducts = List.of("apple", "Grape", "unknown qwerty");
    private final List<Article> articles = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final SearchEngine searchEngine = new SearchEngine();
    private final List<String> testCaseSearchEngine = List.of(
            "singing",
            "apple",
            "yesterday",
            "thinking",
            "I don't know she wouldn't say",
            "Grape",
            "unknown qwerty",
            "unknown asdfgh"
    );

    public Test() {
    }

    public void runAllTestSuites() {
        runTestSuite1();
        runTestSuite2();
        runTestSuite3();
    }

    private void runTestSuite1() {
        System.out.println("------------------------------");
        System.out.println("         Empty basket         ");
        System.out.println("------------------------------");
        clearBasket();
        runAllCases();
    }

    private void runTestSuite2() {
        System.out.println("------------------------------");
        System.out.println("        Filled basket         ");
        System.out.println("------------------------------");
        fillBasket();
        runAllCases();
    }

    private void runTestSuite3() {
        System.out.println("------------------------------");
        System.out.println("        Search Engine         ");
        System.out.println("------------------------------");
        fillArticlesList();
        fillProductsList();
        fillSearchEngine();
        useSearchEngine();
        System.out.println("------------------------------");
        useSearchEngineBestSuited();

    }

    private void runAllCases() {
        printBasket();
        System.out.println();
        printBasketCost();
        System.out.println();
        printFindProducts();
        printFindProductsByName();
        System.out.println();
        printResultsOfDeleteProducts();
    }

    private void clearBasket() {
        productBasket.clear();
    }

    private void fillBasket() {
        addSimpleProduct("Grape", 450);
        addSimpleProduct("Sweet cherry", 900);
        addSimpleProduct("Peach", 500);
        addSimpleProduct("   ", 200);
        addSimpleProduct("test", -100);
        addDiscountedProduct("Apple", 250, 35);
        addDiscountedProduct("Pear", 550, 0);
        addDiscountedProduct("Tomato", 300, 70);
        addDiscountedProduct("", 30, 30);
        addDiscountedProduct("test", 0, 30);
        addDiscountedProduct("test", 30, -30);
        addFixPriceProduct("Cucumber");
        addFixPriceProduct("Potato");
        addFixPriceProduct("Sweet potato");
        addFixPriceProduct("  ");
    }

    private void addSimpleProduct(String name, Integer price) {
        try {
            productBasket.addProduct(new SimpleProduct(name, price));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addDiscountedProduct(String name, Integer basePrice, Integer discountPercent) {
        try {
            productBasket.addProduct(new DiscountedProduct(name, basePrice, discountPercent));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addFixPriceProduct(String name) {
        try {
            productBasket.addProduct(new FixPriceProduct(name));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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

    private void printResultsOfDeleteProducts() {
        System.out.println("---- deleted products ----");
        productBasket.deleteProducts(testCaseDeleteProducts).forEach(System.out::println);
        System.out.println("---- result in basket ----");
        System.out.println(productBasket);
    }

    private void fillArticlesList() {
        articles.add(new Article("Yesterday",
                "Why she had to go I don't know she wouldn't say"));
        articles.add(new Article("My own ideas",
                "Yesterday was yesterday and today is today. Thinking a lot means thinking the best"));
        articles.add(new Article("Thank You for the Music",
                "I began singing before I could talk"));
        articles.add(new Article("Sign singing",
                "Sign singing or Karaoke signing is singing using sign language"));
        articles.add(new Article("Poems, Prayers and Promises",
                "I've been lately thinking about my life's time"));
    }

    private void fillProductsList() {
        products.add(new SimpleProduct("Grape", 450));
        products.add(new DiscountedProduct("Apple", 250, 35));
        products.add(new FixPriceProduct("Cucumber"));
    }

    private void fillSearchEngine() {
        articles.forEach(searchEngine::add);
        products.forEach(searchEngine::add);
    }

    private void useSearchEngine() {
        for (String str : testCaseSearchEngine) {
            searchEngine
                    .search(str)
                    .stream()
                    .map(Searchable::getStringRepresentation)
                    .forEach(stringRepresentation -> System.out.printf("\"%s\" : %s%n", str, stringRepresentation));
        }
    }

    private void useSearchEngineBestSuited() {
        for (String str : testCaseSearchEngine) {
            try {
                System.out.printf("\"%s\" : %s%n", str, searchEngine.searchBestSuited(str).getStringRepresentation());
            } catch (BestSuitedNotFound e) {
                System.out.printf("\"%s\" : %s%n", str, e.getMessage());
            }
        }
    }
}
