package org.example;

import java.awt.*;

    public class Circle implements Figure {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
    this.radius = radius;
    }
    public double calculationPerimeter() {
        return 2 * Math.PI * radius;
    }
    public double calculationArea(){
        return Math.PI * radius * radius;
    }
    public String getFillColor() {
        return fillColor;
    }
    public void setFillColor(String color) {
        this.fillColor = color;
        }
        public String getBorderColor() {
        return borderColor;
    }
    public void setBorderColor(String color) {
        this.borderColor = color;
    }
}
