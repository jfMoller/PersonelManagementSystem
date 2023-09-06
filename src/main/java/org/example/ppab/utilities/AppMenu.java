package org.example.ppab.utilities;

import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.enums.Gender;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppMenu {

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> displayTotalPersonnel();
                    case 2 -> displayMeanSalaryByGender();
                    case 3 -> displayEmployeesByHiringDate();
                    case 4 -> {
                        System.out.print(getShutdownMessage());
                        return;
                    }
                }
            } else {
                scanner.next();
                System.out.println("Invalid choice, try again...");
            }
        }
    }

    public static void printMenu() {
        System.out.print(getMenuLayout());
    }

    public static void displayTotalPersonnel() {
        System.out.print(getTotalPersonnel());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void displayMeanSalaryByGender() {
        System.out.print(getMeanSalaryByGender());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void displayEmployeesByHiringDate() {
        System.out.print(getEmployeesByHiringDate());
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static String getMenuLayout() {
        return """
                ████████████████████████████████████████████████████████████████████████████████
                █                               Perfect Products AB                            █
                █                   Welcome to the Personnel Management System                 █
                ████████████████████████████████████████████████████████████████████████████████
                █ 1. Display total number of people in the system                              █
                █ 2. Display average salary for men and women among employees                  █
                █ 3. Display employees sorted by their hiring date (earliest to latest)        █
                █ 4. Exit                                                                      █
                ████████████████████████████████████████████████████████████████████████████████
                █ Please enter your choice (1/2/3/4):                                          █
                ████████████████████████████████████████████████████████████████████████████████
                """;
    }

    public static String getTotalPersonnel() {
        int employeeCount = Personnel.getTotalEmployees();
        int traineeCount = Personnel.getTotalTrainees();
        int totalPersonnelCount = Personnel.getTotalPersonnel();

        return "████████████████████████████████████████████████████████████████████████████████\n" +
                "1. Display total number of people in the system\n" +
                "   - Amount of employees: " + employeeCount + "\n" +
                "   - Amount of trainees: " + traineeCount + "\n" +
                "   - Total amount of people: " + totalPersonnelCount + "\n" +
                "\nPress ENTER to return to the menu...\n" +
                "████████████████████████████████████████████████████████████████████████████████\n";

    }

    public static String getMeanSalaryByGender() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        double maleMeanSalary = Employee.getMeanSalary(Gender.MALE);
        int maleEmployeeCount = Personnel.getTotalEmployees(Gender.MALE);

        double femaleMeanSalary = Employee.getMeanSalary(Gender.FEMALE);
        int femaleEmployeeCount = Personnel.getTotalEmployees(Gender.FEMALE);

        return  "████████████████████████████████████████████████████████████████████████████████\n" +
                "2. Display average salary for men and women among employees\n" +
                "   - Mean salary: " + decimalFormat.format(maleMeanSalary) + " kr (men, n = " + maleEmployeeCount + ")\n" +
                "   - Mean salary: " + decimalFormat.format(femaleMeanSalary) + " kr (women, n = " + femaleEmployeeCount + ")\n" +
                "\nPress ENTER to return to the menu...\n" +
                "████████████████████████████████████████████████████████████████████████████████\n";
    }

    public static String getEmployeesByHiringDate() {
        StringBuilder employeesBuilder = new StringBuilder();

        employeesBuilder.append("████████████████████████████████████████████████████████████████████████████████\n");
        employeesBuilder.append("3. Display a list of employees sorted by their hiring date (earliest to latest)\n");

        int number = 1;
        for (Employee employee : Employee.getEmployeesByStartDate()) {
            employeesBuilder.append("Employee - " + number + "\n");
            employeesBuilder.append("- id: " + employee.getId() + "\n");
            employeesBuilder.append("- name: " + employee.getName() + "\n");
            employeesBuilder.append("- gender: " + employee.getGender() + "\n");
            employeesBuilder.append("- salary: " + employee.getSalary() + "\n");
            employeesBuilder.append("- startDate: " + employee.getStartDate() + "\n");
            employeesBuilder.append("-".repeat(30) + "\n");
            number++;
        }

        employeesBuilder.append("Press ENTER to return to the menu...\n");
        employeesBuilder.append("████████████████████████████████████████████████████████████████████████████████\n");

        return employeesBuilder.toString();
    }

    public static String getShutdownMessage() {
        return """
                ████████████████████████████████████████████████████████████████████████████████
                Shutting down...
                ████████████████████████████████████████████████████████████████████████████████
                   """;
    }

    ;
}