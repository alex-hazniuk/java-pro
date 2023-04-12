package com.company.lesson12;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final int DISCOUNT_LEVEL = 10;

    public static void main(String[] args) {
        List<Product> productsByCategoryPrice = List.of(
                Product.builder().category("Book").price(255).build(),
                Product.builder().category("Book").price(300).build(),
                Product.builder().category("Toy").price(255).build(),
                Product.builder().category("Book").price(230).build(),
                Product.builder().category("Desk").price(800).build()
        );
        System.out.println(getByCategoryPrice(productsByCategoryPrice, "Book", 250));

        List<Product> productsByCategoryDiscount = List.of(
                Product.builder().category("Book").price(250).discount(true).build(),
                Product.builder().category("Book").price(300).build(),
                Product.builder().category("Toy").price(255).build(),
                Product.builder().category("Book").price(230).discount(true).build(),
                Product.builder().category("Desk").price(800).discount(true).build()
        );
        System.out.println(getByCategoryDiscount(productsByCategoryDiscount, "Book"));
        System.out.println(getCheapest(productsByCategoryDiscount, "Book"));

        List<Product> productsByDate = List.of(
                Product.builder().category("Book").price(250)
                        .date(LocalDate.parse("2010-02-22")).discount(true).build(),
                Product.builder().category("Book").price(300)
                        .date(LocalDate.parse("2016-11-28")).build(),
                Product.builder().category("Toy").price(255)
                        .date(LocalDate.parse("2020-02-24")).build(),
                Product.builder().category("Book").price(75)
                        .date(LocalDate.parse("2020-02-24")).build(),
                Product.builder().category("Book").price(60)
                        .date(LocalDate.parse("2020-08-24")).build(),
                Product.builder().category("Book").price(230)
                        .date(LocalDate.parse("2019-08-22")).discount(true).build(),
                Product.builder().category("Desk").price(800)
                        .date(LocalDate.parse("2019-07-12")).discount(true).build()
        );
        System.out.println(getThreeLast(productsByDate));
        System.out.println(calculate(productsByDate, 2020, "Book", 75));

        List<Product> products = List.of(
                Product.builder().id(1).category("Book").price(250)
                        .date(LocalDate.parse("2010-02-22")).discount(true).build(),
                Product.builder().id(2).category("Book").price(300)
                        .date(LocalDate.parse("2016-11-28")).build(),
                Product.builder().id(3).category("Toy").price(255)
                        .date(LocalDate.parse("2020-02-24")).build(),
                Product.builder().id(4).category("Book").price(75)
                        .date(LocalDate.parse("2020-02-24")).build(),
                Product.builder().id(5).category("Book").price(60)
                        .date(LocalDate.parse("2020-08-24")).build(),
                Product.builder().id(6).category("Book").price(230)
                        .date(LocalDate.parse("2019-08-22")).discount(true).build(),
                Product.builder().id(7).category("Desk").price(800)
                        .date(LocalDate.parse("2019-07-12")).discount(true).build()
        );
        System.out.println(groupByCategory(products));
    }

    /**
     * Given class Product with fields:
     * category
     * price
     * Return list of the products where category equals "Book" and price higher than 250
     */
    private static List<Product> getByCategoryPrice(
            List<Product> products, String category, double price) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category)
                        && product.getPrice() > price)
                .collect(Collectors.toList());
    }

    /**
     * Given class Product with fields:
     * category
     * price
     * possibility having discount
     * Return list of the products where category equals "Book" and possibility having discount exists
     * Final list must contains products with discount 10%
     * For example:
     * Price - 1.0 USD, final price - 0.9 USD
     */
    private static List<Product> getByCategoryDiscount(List<Product> products, String category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category)
                        && product.isDiscount())
                .peek(product -> product.setPrice(product.getPrice() - (
                        product.getPrice() / DISCOUNT_LEVEL)))
                .collect(Collectors.toList());
    }

    /**
     * Given class Product with fields:
     * category
     * price
     * possibility having discount
     * Return the cheapest product where category equals "Book"
     * In case product not found, throw exception with the comment
     * "Product [category: category_name] not found"
     */
    private static Product getCheapest(List<Product> products, String category) {
        return products.stream()
                .filter(product -> product.getCategory().equals(category))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Product [category: "
                        + category + "] not found"));
    }

    /**
     * Given class Product with fields:
     * category
     * price
     * possibility having discount
     * date addition (use  java.time.LocalDate, java.time.LocalDateTime or java.util.Date)
     * Return list of the last tree products
     */
    private static List<Product> getThreeLast(List<Product> products) {
        return products.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Product::getDate)))
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Given class Product with fields:
     * category
     * price
     * possibility having discount
     * date addition (use  java.time.LocalDate, java.time.LocalDateTime or java.util.Date)
     * return the sum of product's prices where:
     * proper date addition
     * category equals "Book"
     * price not higher 75
     */
    private static double calculate(
            List<Product> products, int year, String category, double price) {
        return products.stream()
                .filter(product -> product.getDate().getYear() == year
                        && product.getCategory().equals(category)
                        && product.getPrice() <= price)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    /**
     * Given class Product with fields:
     * id number
     * category
     * price
     * possibility having discount
     * date addition (use  java.time.LocalDate, java.time.LocalDateTime or java.util.Date)
     * return Map, grouped by category: (category: products_list)
     */
    private static Map<String, List<Product>> groupByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }
}
