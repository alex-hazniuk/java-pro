package com.company.lesson15;

public class Main {
    public static void main(String[] args) {
        String[][] numbers = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        ArrayValueCalculator calculator = new ArrayValueCalculator(numbers);
        try {
            System.out.println(calculator.doCalc());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
