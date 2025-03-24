package org.example;

public class TriangleArea {
    public static double calculateArea ( double base, double height) {
        if (base <= 0 || height <= 0) throw new IllegalArgumentException("Значения должны быть положительные");
        return (base * height) / 2;
    }

}
