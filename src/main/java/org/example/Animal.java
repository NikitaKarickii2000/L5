package org.example;

public class Animal {
    String name;
    private static int animalCounter = 0;

    public Animal(String name) {
        this.name = name;
        animalCounter++;
    }
    public int getAnimalCounter () {
        return animalCounter;
    }
    public void run (int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }
    public void swim (int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

}

