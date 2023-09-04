import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.entities.Trainee;
import org.example.ppab.utilities.AppMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppMenuTest {

    @BeforeEach
    public void clearBefore() {
        Personnel.clearPersonnel();
    }

    @AfterEach
    public void clearAfter() {
        Personnel.clearPersonnel();
    }

    @Test
    public void testAppMenuLayout() {
        // Given
        AppMenu.getMenuLayout();

        // When
        String expectedMenuLayout = """
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

        // Then
        assertEquals(expectedMenuLayout, AppMenu.getMenuLayout());
    }

    @Test
    public void testDisplayTotalPersonnel() {
        // Given
        Employee employee = new Employee(
                "Sid", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Trainee trainee = new Trainee(
                "Jonathan", MALE,
                LocalDateTime.of(1995, 5, 4, 9, 0),
                LocalDateTime.of(1995, 9, 5, 17, 0));

        // When
        String expectedOptionLayout =
                        "████████████████████████████████████████████████████████████████████████████████\n" +
                        "1. Display total number of people in the system\n" +
                        "   - Amount of employees: " + "1" + "\n" +
                        "   - Amount of trainees: " + "1" + "\n" +
                        "   - Total amount of people: " + "2" + "\n" +
                        "\nPress any key to return to the menu...\n" +
                        "████████████████████████████████████████████████████████████████████████████████\n";

        // Then
        assertEquals(expectedOptionLayout, AppMenu.getTotalPersonnel());

    }

    @Test
    public void testDisplayEmployeeMeanSalaries() {
        // Given
        Employee maleEmployee = new Employee(
                "Sid", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Employee femaleEmployee = new Employee(
                "Sidney", FEMALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        AppMenu.getMeanSalaryByGender();

        // When
        String expectedOptionLayout =
                "████████████████████████████████████████████████████████████████████████████████\n" +
                "2. Display average salary for men and women among employees\n" +
                "   - Mean salary: " + "42000" + " kr (men, n = " + "1" + ")\n" +
                "   - Mean salary: " + "42000" + " kr (women, n = " + "1" + ")\n" +
                "\nPress any key to return to the menu...\n" +
                "████████████████████████████████████████████████████████████████████████████████\n";

        // Then
        assertEquals(expectedOptionLayout, AppMenu.getMeanSalaryByGender());

    }

    @Test
    public void testDisplayEmployeesByHiringDate() {
        // Given
        Employee employee1 = new Employee(
                "Sid", MALE, 42000,
                LocalDateTime.of(2003, 5, 4, 9, 0));

        Employee employee2 = new Employee(
                "Sidney", FEMALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Employee employee3 = new Employee(
                "Sidney", FEMALE, 42000,
                LocalDateTime.of(1993, 5, 4, 9, 0));

        AppMenu.getEmployeesByHiringDate();

        // When
        String expectedOptionLayout =
                "████████████████████████████████████████████████████████████████████████████████\n" +
                "3. Display a list of employees sorted by their hiring date (earliest to latest)\n" +
                        "Employee - 1\n" +
                        "- id: " + employee1.getId() + "\n" +
                        "- name: " + employee1.getName() + "\n" +
                        "- gender: " + employee1.getGender() + "\n" +
                        "- salary: " + employee1.getSalary() + "\n" +
                        "- startDate: " + employee1.getStartDate() + "\n" +
                        "-".repeat(30) + "\n" +
                        "Employee - 2\n" +
                        "- id: " + employee2.getId() + "\n" +
                        "- name: " + employee2.getName() + "\n" +
                        "- gender: " + employee2.getGender() + "\n" +
                        "- salary: " + employee2.getSalary() + "\n" +
                        "- startDate: " + employee2.getStartDate() + "\n" +
                        "-".repeat(30) + "\n" +
                        "Employee - 3\n" +
                        "- id: " + employee3.getId() + "\n" +
                        "- name: " + employee3.getName() + "\n" +
                        "- gender: " + employee3.getGender() + "\n" +
                        "- salary: " + employee3.getSalary() + "\n" +
                        "- startDate: " + employee3.getStartDate() + "\n" +
                        "-".repeat(30) + "\n" +
                        "Press any key to return to the menu...\n" +
                        "████████████████████████████████████████████████████████████████████████████████\n";

        // Then
        assertEquals(expectedOptionLayout, AppMenu.getEmployeesByHiringDate());

    }

    public void testDisplayShutDownMenu() {
        // Given
        AppMenu.getShutdownMessage();

        // When
        String expectedOptionLayout = """
                ████████████████████████████████████████████████████████████████████████████████
                Shutting down...
                ████████████████████████████████████████████████████████████████████████████████
                   """;

        // Then
        assertEquals(expectedOptionLayout, AppMenu.getShutdownMessage());

    }
}
