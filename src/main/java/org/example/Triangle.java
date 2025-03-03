package org.example;

public class Triangle implements Figure{
    private double a, b, c;
    private String fillColor;
    private String borderColor;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double calculationPerimeter(){
        return a + b + c;
    }
    public double calculationArea(){
        double s = calculationPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
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
