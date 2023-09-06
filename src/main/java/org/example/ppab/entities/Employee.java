package org.example.ppab.entities;

import org.example.ppab.enums.Gender;

import java.time.LocalDateTime;
import java.util.*;

public class Employee extends Personnel {
    private double salary;
    private LocalDateTime startDate;

    public Employee(String name, Gender gender, double salary, LocalDateTime startDate) {
        super(name, gender);
        this.salary = salary;
        this.startDate = startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void adjustSalary(double adjustment) {
        //handles an increase (positive adjustment) or decrease (negative adjustment) in salary,
        this.salary += adjustment;
    }

    public static double getMeanSalary(Gender gender) {
        return Personnel.getEmployeesList().stream()
                .filter(employee -> employee.getGender() == gender)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public static List<Employee> getEmployeesByStartDate() {
        List<Employee> orderedList = new ArrayList<>(Personnel.getEmployeesList());
        orderedList.sort(Comparator.comparing(Employee::getStartDate));
        return orderedList;
    }

}
