package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Бобик");
        Miska miska = new Miska(20);
        dog.run(400);
        dog.swim(3);
        cat.swim(14);
        cat.run(200);
        cat.eat(miska, 40);
        Miska miska2 = new Miska(50);
        Cat[] cats ={
                new Cat("Масик"),
                new Cat("Мурзик"),
                new Cat("Черныш")
        };
        for (Cat cat1 : cats) {
            cat1.eat(miska2, 20);
        }
        for (Cat cat1 : cats) {
            System.out.println(cat1.name + " сыт? " + cat1.isFull());
        }
        miska2.addFood(60);
        for (Cat cat1 : cats) {
            cat1.eat(miska2, 20);
        }
        for (Cat cat1 : cats) {
            System.out.println(cat1.name + " сыт? " + cat1.isFull());
        }

        Circle circle = new Circle(10);
        circle.setFillColor("Красный");
        circle.setBorderColor("Черный");
        circle.printFigure();

        Rectangle rectangle = new Rectangle(10,20);
        rectangle.setBorderColor("Зеленый");
        rectangle.setFillColor("Жёлтый");
        rectangle.printFigure();

        Triangle triangle = new Triangle(3,5,7);
        triangle.setBorderColor("Белый");
        triangle.setFillColor("Синий");
        triangle.printFigure();
    }


}