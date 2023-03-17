package com.company.lesson4.figures;

public class Triangle implements AreaCalculator {
    private double side;
    private double heightToSide;

    public Triangle(double side, double heightToSide) {
        this.side = side;
        this.heightToSide = heightToSide;
    }

    @Override
    public double getArea() {
        return side * heightToSide / 2;
    }
}
