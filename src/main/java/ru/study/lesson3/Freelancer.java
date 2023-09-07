package ru.study.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Freelancer extends Employee {


    protected Freelancer(String surName, String name, double salary) {
        super(surName, name);
        if (salary < 30000){
            throw new RuntimeException("Ставка заработной платы должна быть не менее 30000");
        }
        this.salary = salary;
    }

    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(30000, 50000));
    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surName, name, salary);
    }
}
