package ru.study.lesson3;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getSurName().compareTo(o2.getSurName());
        if (res == 0) {
            res = o1.getName().compareTo(o2.getName());
            if (res == 0){
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        }
            return res;
    }
}
