package org.example;

import static org.example.MyArray.sumArray;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] array1 = {
                {"1","2","3","4"}, {"1","2","3","вамав"}, {"1","2","3","4"}, {"1","2","3","4"}
        };
        String[][] array2 = {
                {"1","2","3","4"}, {"1","2","3","4"}, {"1","2","3","4"}
        };
        try {
            System.out.println("Сумма масива: " + sumArray(array1));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Сумма масива: " + sumArray(array2));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try{
            int[] arr = new int[2];
            System.out.println(arr[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }



    }


}