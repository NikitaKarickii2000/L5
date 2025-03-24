package org.example;

public class NumberComparator {
    public static String compare(int a, int b) {
        if (a > b) return a + " is greater than " + b;
        if (a < b) return a + " is less than " + b;
        return a + " is equal to " + b;
    }
}
