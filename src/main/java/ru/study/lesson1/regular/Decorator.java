package ru.study.lesson1.regular;

/**
 * Класс для оформления выводимых данных
 */
public class Decorator {

    /**
     * Метод, возвращающий результат вычисления
     * в форматирвоанном виде
     * @param a число для вставки в форматированную строку
     * @return Отформатированная строка
     */
    public static String decorator(int a){
        return String.format("полученный результат: %d.", a);
    }
}
