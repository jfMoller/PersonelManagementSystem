package org.example.ppab.entities;

import org.example.ppab.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Personell {
    private double salary;
    private final LocalDateTime startDate;
    private static List<Employee> employees = new ArrayList<>();

    public Employee(String name, Gender gender, double salary, LocalDateTime startDate) {
        super(name, gender);
        this.salary = salary;
        this.startDate = startDate;
        employees.add(this);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public void adjustSalary(double adjustment) {
        //handles an increase (positive adjustment) or decrease (negative adjustment) in salary,
        this.salary += adjustment;
    }

    public static void compareMeanSalaryByGender() {
        Double maleMeanSalary = getMeanSalary(Gender.MALE);
        Double femaleMeanSalary = getMeanSalary(Gender.FEMALE);

        System.out.println("Mean salary comparison:");
        System.out.println("    -Male mean salary: " + maleMeanSalary);
        System.out.println("    -Female mean salary: " + femaleMeanSalary);
    }

    private static double getMeanSalary(Gender gender) {
        double meanSalary = employees.stream()
                .filter(employee -> employee.getGender() == gender)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        return meanSalary;
    }

}
