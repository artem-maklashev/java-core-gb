package ru.study.lesson3;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Метод реализующий интерфейс Iterator
 */
public class EmployeesIterator implements Iterator<Employee> {
    /**
     * Текущий индекс
     */
    private int currentIndex = 0;
    /**
     * Итерируемый список
     */
    private List<Employee> employees;

    /**
     * Конструктор класса
     * @param employees итерируемый список
     */
    public EmployeesIterator(List<Employee> employees){
        this.employees = employees;
    }

    /**
     * Метод возвращает истину если текущий индекс меньше размера списка
     * @return True если не null и есть следующий элемент
     */
    @Override
    public boolean hasNext() {
        return currentIndex< employees.size();
    }

    /**
     * Метод возвращает элемент списка и увеличивает индекс на 1
     * @return элемент списка
     */
    @Override
    public Employee next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return employees.get(currentIndex++);
    }
}
