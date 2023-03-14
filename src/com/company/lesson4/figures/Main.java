package com.company.lesson4.figures;

public class Main {
    public static void main(String[] args) {
        AreaCalculator circle = new Circle(2);
        AreaCalculator square = new Square(3);
        AreaCalculator triangle = new Triangle(2.5, 2);

        GeneralAreaCalculator generalAreaCalculator = new GeneralAreaCalculator();
        AreaCalculator[] figures = {circle, square, triangle};
        generalAreaCalculator.getGeneralArea(figures);
    }
}
