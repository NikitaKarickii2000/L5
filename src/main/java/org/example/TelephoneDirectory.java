package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneDirectory {
    private HashMap<String, ArrayList<String>> contacts = new HashMap<>();

    public void add(String surname, String phone){
        if(!contacts.containsKey(surname)){
            contacts.put(surname, new ArrayList<>());
        }
        contacts.get(surname) .add(phone);
    }


    public ArrayList<String> get(String surname){
        if(!contacts.containsKey(surname)){
            return new ArrayList<>();
        }
        return contacts.get(surname);
    }

    public static void main(String[] args) {
        TelephoneDirectory book = new TelephoneDirectory();

        book.add("Иванов", "89001234567");
        book.add("Карпов", "89012345678");
        book.add("Карпов", "89023456789");
        book.add("Петров", "89023556889");


        System.out.println("Иванов: " + book.get("Иванов"));
        System.out.println("Карпов: " + book.get("Карпов"));
        System.out.println("Петров: " + book.get("Петров"));
    }

}

