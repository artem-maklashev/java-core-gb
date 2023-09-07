package ru.study.lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllEmloyees implements Iterable<Employee>{
    private List<Employee> employees;

    public AllEmloyees(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Метод имплементирует соответствующий метод интерфейса Iterable
     * В качестве итератора вытупает класс EmployeesIterator
     * @return
     */
    @Override
    public Iterator<Employee> iterator() {
        return new EmployeesIterator(employees);
    }
}
