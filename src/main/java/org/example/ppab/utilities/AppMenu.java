package org.example.ppab.utilities;

import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.entities.Trainee;
import org.example.ppab.enums.Gender;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;

public class AppMenu {

    private static final String newEmployeeInputRegex =
            "^([^,]+)," +                  // Match everything before the first comma (name)
                    "(MALE|FEMALE)," +             // Match either "MALE" or "FEMALE" (gender)
                    "(\\d+(\\.\\d+)?)," +          // Match a number with optional decimal (salary)
                    "(\\d{4}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2})$";  // Match a LocalDateTime format (startDate (YYYY-M-D-H-M))

    private static final String newTraineeInputRegex =
            "^([^,]+),(MALE|FEMALE)," +    // Match everything before the first comma (name)
                    "(\\d{4}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2})," +  // Match a LocalDateTime format (startDate (YYYY-M-D-H-M))
                    "(\\d{4}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2})$";  // Match a LocalDateTime format (endDate (YYYY-M-D-H-M))


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
                    case 4 -> addNewPersonnel();
                    case 5 -> {
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

    public static void addNewPersonnel() {
        System.out.println(getAddNewPersonnel());
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addNewEmployee();
                case 2 -> addNewTrainee();
            }
        } else {
            scanner.next();
            System.out.println("Invalid choice, try again...");
            addNewPersonnel();
        }
    }

    public static void addNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(getAddNewEmployee());
        String newEmployeeInput = scanner.nextLine();

        if (newEmployeeInput.matches(newEmployeeInputRegex)) {

            String[] inputValues = newEmployeeInput.split(",");
            String name = inputValues[0];
            Gender gender = inputValues[1].equals("MALE") ? MALE : FEMALE;
            double salary = Double.parseDouble(inputValues[2]);

            String[] dateInputValues = inputValues[3].split("-");
            int year = Integer.parseInt(dateInputValues[0]);
            int month = Integer.parseInt(dateInputValues[1]);
            int day = Integer.parseInt(dateInputValues[2]);
            int hour = Integer.parseInt(dateInputValues[3]);
            int minute = Integer.parseInt(dateInputValues[4]);
            LocalDateTime startDate = LocalDateTime.of(
                    year, month, day, hour, minute);

            Employee newEmployee = PersonnelUtility.createEmployee(name, gender, salary, startDate);

            for (Employee employee : Personnel.getEmployeesList()) {
                if (employee.equals(newEmployee)) {
                    System.out.println("New employee added successfully!");
                    return;
                }
            }
        } else {
            System.out.println("Invalid input, try again...");
            addNewEmployee();
        }
    }

    public static void addNewTrainee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(getAddNewTrainee());
        String newTraineeInput = scanner.nextLine();

        if (newTraineeInput.matches(newTraineeInputRegex)) {

            String[] inputValues = newTraineeInput.split(",");
            String name = inputValues[0];
            Gender gender = inputValues[1].equals("FEMALE") ? FEMALE : MALE;

            String[] startDateValues = inputValues[2].split("-");
            int startYear = Integer.parseInt(startDateValues[0]);
            int startMonth = Integer.parseInt(startDateValues[1]);
            int startDay = Integer.parseInt(startDateValues[2]);
            int startHour = Integer.parseInt(startDateValues[3]);
            int startMinute = Integer.parseInt(startDateValues[4]);
            LocalDateTime startDate = LocalDateTime.of(
                    startYear, startMonth, startDay, startHour, startMinute);

            String[] endDateValues = inputValues[3].split("-");
            int endYear = Integer.parseInt(endDateValues[0]);
            int endMonth = Integer.parseInt(endDateValues[1]);
            int endDay = Integer.parseInt(endDateValues[2]);
            int endHour = Integer.parseInt(endDateValues[3]);
            int endMinute = Integer.parseInt(endDateValues[4]);
            LocalDateTime endDate = LocalDateTime.of(
                    endYear, endMonth, endDay, endHour, endMinute);

            Trainee newTrainee = PersonnelUtility.createTrainee(name, gender, startDate, endDate);

            for (Trainee trainee : Personnel.getTraineesList()) {
                if (trainee.equals(newTrainee)) {
                    System.out.println("New trainee added successfully!");
                    return;
                }
            }
        } else {
            System.out.println("Invalid input, try again...");
            addNewTrainee();
        }
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
                █ 4. Add new personnel                                                         █
                █ 5. Exit                                                                      █
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

        return "████████████████████████████████████████████████████████████████████████████████\n" +
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

    public static String getAddNewPersonnel() {
        return """
                ████████████████████████████████████████████████████████████████████████████████
                █                            4. Add new personnel                              █
                ████████████████████████████████████████████████████████████████████████████████
                █ 1. Add new employee                                                          █
                █ 2. Add new trainee                                                           █
                ████████████████████████████████████████████████████████████████████████████████
                █ Please enter your choice (1/2):                                              █
                ████████████████████████████████████████████████████████████████████████████████
                """;
    }

    public static String getAddNewEmployee() {
        return "████████████████████████████████████████████████████████████████████████████████\n" +
                "4. Add new personnel - Employee \n" +
                "To add a new employee, copy and paste the text below," + "\n" +
                "replacing <values> with the values for that employee." + "\n" +
                "-".repeat(30) + "\n" +
                "<name>,<MALE or FEMALE>,<salary>,<YYYY-M-D-H-M>" + "\n" +
                "-".repeat(30) + "\n" +
                "For example: John Miller,MALE,42000,2023-9-8-8-0" + "\n" +
                "████████████████████████████████████████████████████████████████████████████████\n";
    }

    public static String getAddNewTrainee() {
        return "████████████████████████████████████████████████████████████████████████████████\n" +
                "4. Add new personnel - Trainee \n" +
                "To add a new trainee, copy and paste the text below," + "\n" +
                "replacing <values> with the values for that trainee." + "\n" +
                "-".repeat(30) + "\n" +
                "<name>,<MALE or FEMALE>,<YYYY-M-D-H-M>,<YYYY-M-D-H-M>" + "\n" +
                "-".repeat(30) + "\n" +
                "For example: Janet Mills,FEMALE,2023-9-8-8-0,2023-12-8-17-0" + "\n" +
                "████████████████████████████████████████████████████████████████████████████████\n";
    }

    public static String getShutdownMessage() {
        return """
                ████████████████████████████████████████████████████████████████████████████████
                Shutting down...
                ████████████████████████████████████████████████████████████████████████████████
                   """;
    }
}