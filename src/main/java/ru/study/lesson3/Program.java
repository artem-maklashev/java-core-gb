package ru.study.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Employee> employees = Worker.getEmployees(15);
        //Сортируем по ЗП
        employees.sort(new EmployeeSalaryComparator());

        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println();

        List<Employee> employees2 = Freelancer.getEmployees(15);
        //Сортируем по ЗП
        employees2.sort(new EmployeeSalaryComparator());
        for (Employee employee: employees2) {
            System.out.println(employee);
        }

        System.out.println();
        //Создаем общий список работников
        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.addAll(employees);
        allEmployees.addAll(employees2);
        //Сортируем по имени
        allEmployees.sort(new EmployeeNameComparator());
        //Создаем объект класса всех работников
        AllEmloyees ae = new AllEmloyees(allEmployees);

        for (Employee e: ae) {
            System.out.println(e);
        }
    }
}
