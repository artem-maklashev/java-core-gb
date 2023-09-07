package ru.study.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee{
    private int hourlyRate;


    private Worker(String surName, String name, int hourlyRate){
        super(surName, name);
        this.hourlyRate = hourlyRate;
        if (hourlyRate < 200){
            throw new RuntimeException("Часовая ставка заработной платы должна быть не менее 200");
        }
        this.salary = calculateSalary();
        //System.out.println("Constructor - Worker");
    }

    public static Employee getInstance(){
        return new Worker(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(200, 500));

    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate*20.8*8;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surName, name, salary);
    }
    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
