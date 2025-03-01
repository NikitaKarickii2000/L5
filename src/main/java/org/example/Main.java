package org.example;
import org.example.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product hummer = new Product("Молоток","31.12.2024",
                                   "Молодел", "Германия",
                                    "50$","Забронирован");
        hummer.printProduct();
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Телефон", "23.03.2000",
                                    "Samsung", "Корея",
                                        "1000$", "Забронирован");
        productsArray[1] = new Product("Телефон", "23.03.2000",
                "Iphone", "Корея",
                "1000$", "Забронирован");
        productsArray[2] = new Product("Телефон", "23.03.2000",
                "Motorolla", "Корея",
                "1000$", "Забронирован");
        productsArray[3] = new Product("Телефон", "23.03.2000",
                "Nokia", "Корея",
                "1000$", "Забронирован");
        productsArray[4] = new Product("Телефон", "23.03.2000",
                "Honor", "Корея",
                "1000$", "Забронирован");
        Park kirov = new Park();
        Park.Attraction koleso = kirov.new Attraction("Колесо обозрения", "C 9:00 до 22:00", 500);
        koleso.printAttraction();
    }


}