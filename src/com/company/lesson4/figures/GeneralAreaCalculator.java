package com.company.lesson4.figures;

public class GeneralAreaCalculator {
    public void getGeneralArea(AreaCalculator[] figures) {
        if (figures != null && figures.length > 0) {
            double generalArea = 0;
            for (AreaCalculator figure : figures) {
                generalArea += figure != null ? figure.getArea() : 0;
            }
            System.out.println("General area: " + generalArea);
        } else {
            System.out.println("No figures!");
        }
    }
}
