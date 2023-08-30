package ru.study.lesson1.sample;

import ru.study.lesson1.regular.Decorator;
import ru.study.lesson1.regular.OtherClass;

/**
 * Класс для выполнения элементарных арифмитических операций
 */
public class Main {
    public static void main(String[] args) {
        int result = OtherClass.add(2,2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.sub(2,2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.div(2,2);
        System.out.println(Decorator.decorator(result));
        result = OtherClass.mul(2,2);
        System.out.println(Decorator.decorator(result));
    }
}
