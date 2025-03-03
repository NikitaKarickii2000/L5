package org.example;

public interface Figure {
    String getFillColor();
    String getBorderColor();
    void setFillColor(String color);
    void setBorderColor(String color);

    default double calculationArea() {
        return 0;
    }
    default double calculationPerimeter() {
        return 0;
    }
    default void printFigure() {
        System.out.println("Периметр: " + calculationPerimeter());
        System.out.println("Площадь: " + calculationArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
    }


}
