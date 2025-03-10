package org.example;

public class MyArray {

    public static int sumArray(String[][] array) {

        if (array.length != 4) {
            throw new MyArraySizeException("Неверный размер массива");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Неверный размер массива");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArraySizeException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }

        }
        return sum;


    }

}
