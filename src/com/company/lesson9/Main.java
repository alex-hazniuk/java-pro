package com.company.lesson9;

import com.company.lesson9.coffee.order.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.add("Alex");
        orderBoard.add("Bohdan");
        orderBoard.add("Svetlana");
        orderBoard.add("Kate");
        System.out.println(orderBoard.deliver(3));
        orderBoard.draw();
        System.out.println(orderBoard.deliver());
        orderBoard.add("Lucia");
        orderBoard.draw();
    }
}
