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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public static List<Employee> getEmployees() {
        return Personnel.getEmployeesList();
    }

    public void adjustSalary(double adjustment) {
        //handles an increase (positive adjustment) or decrease (negative adjustment) in salary,
        this.salary += adjustment;
    }

    public static double getMeanSalary(Gender gender) {
        double meanSalary = Personnel.getEmployeesList().stream()
                .filter(employee -> employee.getGender() == gender)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        return meanSalary;
    }

    public static List<Employee> getEmployeesByStartDate() {
        List<Employee> orderedList = new ArrayList(Personnel.getEmployeesList());
        Collections.sort(orderedList, Comparator.comparing(Employee::getStartDate).reversed());
        return orderedList;
    }

}
