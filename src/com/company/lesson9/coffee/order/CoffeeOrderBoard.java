package com.company.lesson9.coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private final Queue<Order> orders = new LinkedList<>();
    private int queueNumber;

    public void add(String name) {
        queueNumber++;
        orders.offer(new Order(name, queueNumber));
    }

    public Order deliver() {
        return orders.poll();
    }

    public Order deliver(int number) {
        for (Order order : orders) {
            if (order.getNumber() == number) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("=============\nNum|Name");
        for (Order order : orders) {
            System.out.println(order.getNumber() + "|" + order.getCustomerName());
        }
    }
}
