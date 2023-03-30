package com.company.lesson9.coffee.order;

public class Order {
    private String customerName;
    private int number;

    public Order(String customerName, int number) {
        this.customerName = customerName;
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", number=" + number +
                '}';
    }
}
