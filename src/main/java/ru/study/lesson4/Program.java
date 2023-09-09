package ru.study.lesson4;

import ru.study.lesson4.exeptions.MyArrayDataException;
import ru.study.lesson4.exeptions.MyArrayException;
import ru.study.lesson4.exeptions.MyArraySizeException;

public class Program {
    public static void main(String[] args) {
        // 3 различных массива
        String[][] array = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] array1 = new String[][]{
                {"1", "2", "fff", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] array2 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16", "17"}
        };
        int result;
//       вывод суммы элементова массива
        try {
           result= getSum(array);
            System.out.println(result);
        } catch (MyArrayException e) {
            System.out.println(e.getMessage("Ошибка суммирвоания массива"));
        }
        try {
            result= getSum(array1);
            System.out.println(result);
        } catch (MyArrayException e) {
            System.out.println(e.getMessage("Ошибка суммирвоания массива"));
        }
        try {
            result= getSum(array2);
            System.out.println(result);
        } catch (MyArrayException e) {
            System.out.println(e.getMessage("Ошибка суммирвоания массива"));
        }
    }
// Метод вывода суммы элементов массива
    public static int getSum(String[][] array) throws MyArrayException {
        int result = 0;
        int rowSize = array.length;
        int columnSize = 0;
        for (String[] row : array) {
            if (columnSize < row.length) {
                columnSize = row.length;
            }
        }
        if (rowSize > 4 || columnSize > 4) {
            throw new MyArraySizeException("Ошибка размерности массива.", rowSize, columnSize);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (isDigit(array[i][j])) {
                    result += Integer.parseInt(array[i][j]);
                } else {
                    throw new MyArrayDataException("Ошибка значения массива.", array[i][j], i, j);
                }
            }
        }
        return result;
    }

    private static boolean isDigit(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
