package org.example;

public class Park {

    public class Attraction{
        String name;
        String workHours;
        int price;
        public Attraction(String name, String workHours, int price) {
            this.name = name;
            this.workHours = workHours;
            this.price = price;
        }
        public void printAttraction(){
            System.out.println(name);
            System.out.println(workHours);
            System.out.println(price);
        }
    }

}
