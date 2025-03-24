package org.example;

public class NumberComparator {
    public static String compare(int a, int b) {
        if (a > b) return a + " больше чем " + b;
        if (a < b) return a + " меньше чем " + b;
        return a + " равно " + b;
    }
}
