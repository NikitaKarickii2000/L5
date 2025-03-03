package org.example;

public class Cat extends Animal {
    private static int catCounter = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCounter++;
    }
    public int getCatCounter () {

        return catCounter;
    }
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(name + " устанет бежать " + distance + " м.");
        }
    }
    public void swim(int distance) {
          //  super.swim(distance);
            System.out.println("Коты не умеют плавать");
    }
    public void eat(Miska miska, int kol) {
        if (miska.eatFood(kol)){
            this.isFull = true;
            System.out.println(name + " поел и сыт");
        } else {
            System.out.println(name + "у не хватило еды в миске");
        }
    }
    public boolean isFull() {
        return isFull;
    }
}

