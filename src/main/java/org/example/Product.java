package org.example;

public class Product {
    String name;
    String productionDate;
    String production;
    String countryProduction;
    String price;
    String reservationStatus;


    public Product(String name, String productionDate, String production,
                   String countryProduction, String price, String reservationStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.production = production;
        this.countryProduction = countryProduction;
        this.price = price;
        this.reservationStatus = reservationStatus;
        //System.out.println("Название: " + name +
        //        ". Дата производства: " + productionDate +
        //      ". Производитель: " + production + ". Страна происхождения: " + countryProduction +
        //    ". Цена: " + price + ". Статус бронирования: " + reservationStatus);
    }
    public void printProduct() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + production);
        System.out.println("Страна происхождения: " + countryProduction);
        System.out.println("Цена: " + price);
        System.out.println("Статус бронирования: " + reservationStatus);
    }


}