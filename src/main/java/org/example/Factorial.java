package org.example;

public class Factorial {
    public static long calculateFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Отрицательные числа не допускаются");
        return (n == 0) ? 1 : n * calculateFactorial(n - 1);
    }
}
