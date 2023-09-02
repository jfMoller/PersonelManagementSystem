package org.example.ppab;

import org.example.ppab.entities.Employee;

import java.time.LocalDateTime;

import static org.example.ppab.enums.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Mark", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));
        Employee employee2 = new Employee(
                "Mark", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 1));
        Employee employee3 = new Employee(
                "Mark", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 2));

        Employee.printEmployeesByStartDate(true);
    }
}
