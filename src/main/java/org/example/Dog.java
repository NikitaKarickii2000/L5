package org.example;

public class Dog extends Animal {
    private static int dogCounter = 0;

    public Dog(String name) {
        super(name);
        dogCounter++;
    }

    public int getDogCounter() {
        return dogCounter;
    }
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(name + " устанет бежать " + distance + " м.");
        }
    }
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(name + " устанет плыть " + distance + " м.");
        }
    }
}