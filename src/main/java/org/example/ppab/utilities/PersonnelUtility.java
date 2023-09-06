package org.example.ppab.utilities;

        import org.example.ppab.entities.Employee;
        import org.example.ppab.entities.Trainee;
        import org.example.ppab.enums.Gender;

        import java.time.LocalDateTime;

        import static org.example.ppab.enums.Gender.FEMALE;
        import static org.example.ppab.enums.Gender.MALE;

public class PersonnelUtility {

    private static final String DEFAULT_NAME = "test";
    private static final LocalDateTime DEFAULT_START_DATE = LocalDateTime.of(1995, 5, 4, 9, 0);
    private static final double DEFAULT_SALARY = 42000;

    public static Employee createEmployee() {
        return createEmployee(DEFAULT_NAME, MALE, DEFAULT_SALARY, DEFAULT_START_DATE);
    }

    public static Employee createEmployee(double salary) {
        return createEmployee(DEFAULT_NAME, MALE, salary, DEFAULT_START_DATE);
    }

    public static Employee createEmployee(LocalDateTime startDate) {
        return createEmployee(DEFAULT_NAME, MALE, DEFAULT_SALARY, startDate);
    }

    public static Employee createEmployee(Gender gender, double salary) {
        return createEmployee(DEFAULT_NAME, gender, salary, DEFAULT_START_DATE);
    }

    public static Employee createEmployee(double salary, LocalDateTime startDate) {
        return createEmployee(DEFAULT_NAME, FEMALE, salary, startDate);
    }

    public static Employee createEmployee(Gender gender, double salary, LocalDateTime startDate) {
        return createEmployee(DEFAULT_NAME, gender, salary, startDate);
    }

    public static Employee createEmployee(String name, Gender gender, double salary, LocalDateTime startDate) {
        return new Employee(name, gender, salary, startDate);
    }

    public static Trainee createTrainee() {
        return createTrainee(DEFAULT_NAME, MALE, DEFAULT_START_DATE, DEFAULT_START_DATE.plusHours(8));
    }

    public static Trainee createTrainee(LocalDateTime startDate, LocalDateTime endDate) {
        return createTrainee(DEFAULT_NAME, MALE, startDate, endDate);
    }

    public static Trainee createTrainee(String name, Gender gender, LocalDateTime startDate, LocalDateTime endDate) {
        return new Trainee(name, gender, startDate, endDate);
    }

    public static void generateDefaultPersonnel() {
        // Handles employees
        createEmployee("John Doe", MALE, 42000, LocalDateTime.of(1995, 5, 4, 9, 0));
        createEmployee("Jonas Rowe", MALE, 39000, LocalDateTime.of(1999, 3, 1, 9, 0));
        createEmployee("Jon Lowe", MALE, 48000, LocalDateTime.of(2003, 9, 15, 8, 0));
        createEmployee("Jane Doe", FEMALE, 27000, LocalDateTime.of(2000, 8, 2, 8, 0));
        createEmployee("Janet Rowe", FEMALE, 36000, LocalDateTime.of(2003, 9, 15, 8, 15));
        createEmployee("Julie Lowe", FEMALE, 54000, LocalDateTime.of(1991, 8, 3, 8, 0));

        // Handles trainees
        createTrainee("Jonathan Dorn", MALE, LocalDateTime.of(1995, 5, 4, 9, 0), LocalDateTime.of(1995, 9, 5, 17, 0));
        createTrainee("Jessy Moore", FEMALE, LocalDateTime.of(2001, 5, 4, 9, 0), LocalDateTime.of(2002, 9, 5, 17, 0));
    }
}
