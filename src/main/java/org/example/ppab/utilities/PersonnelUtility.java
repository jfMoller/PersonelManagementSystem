package org.example.ppab.utilities;

import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Trainee;
import org.example.ppab.enums.Gender;

import java.time.LocalDateTime;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;

public class PersonnelUtility {

    public static Employee createEmployee() {
        return new Employee(
                "test", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));
    }

    public static Employee createEmployee(double salary) {
        return new Employee(
                "test", MALE, salary,
                LocalDateTime.of(2003, 5, 4, 9, 0));
    }

    public static Employee createEmployee(LocalDateTime startDate) {
        return new Employee(
                "test", MALE, 42000, startDate);
    }

    public static Employee createEmployee(Gender gender, double salary) {
        return new Employee(
                "test", gender, salary,
                LocalDateTime.of(2003, 5, 4, 9, 0));
    }

    public static Employee createEmployee(double salary, LocalDateTime startDate) {
        return new Employee(
                "test", FEMALE, salary, startDate);
    }

    public static Employee createEmployee(Gender gender, double salary, LocalDateTime startDate) {
        return new Employee(
                "test", gender, salary, startDate);
    }

    public static Trainee createTrainee() {
        return new Trainee(
                "test", MALE,
                LocalDateTime.of(1995, 5, 4, 9, 0),
                LocalDateTime.of(1995, 9, 5, 17, 0));
    }

    public static Trainee createTrainee(LocalDateTime startDate, LocalDateTime endDate) {
        return new Trainee(
                "test", MALE, startDate, endDate);
    }

    public static void generateDefaultPersonell() {
        //handles employees
        new Employee(
                "John Doe", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        new Employee(
                "Jonas Rowe", MALE, 39000,
                LocalDateTime.of(1999, 3, 1, 9, 0));

        new Employee(
                "Jon Lowe", MALE, 48000,
                LocalDateTime.of(2003, 9, 15, 8, 0));

        new Employee(
                "Jane Doe", FEMALE, 27000,
                LocalDateTime.of(2000, 8, 2, 8, 0));

        new Employee(
                "Janet Rowe", FEMALE, 36000,
                LocalDateTime.of(2003, 9, 15, 8, 15));

        new Employee(
                "Julie Lowe", FEMALE, 54000,
                LocalDateTime.of(1991, 8, 3, 8, 0));

        //handles trainees

        new Trainee(
                "Jonathan Dorn", MALE,
                LocalDateTime.of(1995, 5, 4, 9, 0),
                LocalDateTime.of(1995, 9, 5, 17, 0));

        new Trainee(
                "Jessy Moore", FEMALE,
                LocalDateTime.of(2001, 5, 4, 9, 0),
                LocalDateTime.of(2002, 9, 5, 17, 0));
    }
}
