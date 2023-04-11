package com.company.lesson12;

import java.time.LocalDate;

public class Product {
    private int id;
    private String category;
    private double price;
    private boolean discount;
    private LocalDate date;

    private Product(int id, String category, double price, boolean discount, LocalDate date) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", date=" + date +
                '}';
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private int id;
        private String category;
        private double price;
        private boolean discount;
        private LocalDate date;

        public ProductBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder category(String category) {
            this.category = category;
            return this;
        }

        public ProductBuilder price(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder discount(boolean discount) {
            this.discount = discount;
            return this;
        }

        public ProductBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Product build() {
            return new Product(id, category, price, discount, date);
        }
    }
}
