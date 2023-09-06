import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.entities.Trainee;
import org.example.ppab.utilities.AppMenu;
import org.example.ppab.utilities.PersonnelUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppMenuTest {

    @BeforeEach
    @AfterEach
    public void clearPersonnel() {
        Personnel.clearPersonnel();
    }

    @Test
    public void testAppMenuLayout() {
        // Given
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
        // When
        String actualMenuLayout = AppMenu.getMenuLayout();

        // Then
        assertEquals(expectedMenuLayout, actualMenuLayout);
    }

    @Test
    public void testDisplayTotalPersonnel() {
        // Given
        Employee employee = PersonnelUtility.createEmployee();

        Trainee trainee = PersonnelUtility.createTrainee();

        // When
        String expectedOptionLayout =
                "████████████████████████████████████████████████████████████████████████████████\n" +
                        "1. Display total number of people in the system\n" +
                        "   - Amount of employees: " + "1" + "\n" +
                        "   - Amount of trainees: " + "1" + "\n" +
                        "   - Total amount of people: " + "2" + "\n" +
                        "\nPress ENTER to return to the menu...\n" +
                        "████████████████████████████████████████████████████████████████████████████████\n";

        String actualOptionLayout = AppMenu.getTotalPersonnel();

        // Then
        assertEquals(expectedOptionLayout, actualOptionLayout);

    }

    @Test
    public void testDisplayEmployeeMeanSalaries() {
        // Given
        Employee maleEmployee = PersonnelUtility.createEmployee(MALE, 42000);

        Employee femaleEmployee = PersonnelUtility.createEmployee(FEMALE, 42000);

        // When
        String expectedOptionLayout =
                "████████████████████████████████████████████████████████████████████████████████\n" +
                        "2. Display average salary for men and women among employees\n" +
                        "   - Mean salary: " + "42000" + " kr (men, n = " + "1" + ")\n" +
                        "   - Mean salary: " + "42000" + " kr (women, n = " + "1" + ")\n" +
                        "\nPress ENTER to return to the menu...\n" +
                        "████████████████████████████████████████████████████████████████████████████████\n";

        String actualOptionLayout = AppMenu.getMeanSalaryByGender();

        // Then
        assertEquals(expectedOptionLayout, actualOptionLayout);

    }

    @Test
    public void testDisplayEmployeesByHiringDate() {
        // Given
        Employee employee1 = PersonnelUtility.createEmployee(MALE, 42000,
                LocalDateTime.of(2003, 5, 4, 9, 0));

        Employee employee2 = PersonnelUtility.createEmployee(FEMALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Employee employee3 = PersonnelUtility.createEmployee(FEMALE, 42000,
                LocalDateTime.of(1993, 5, 4, 9, 0));

        // When
        String expectedOptionLayout =
                "████████████████████████████████████████████████████████████████████████████████\n" +
                        "3. Display a list of employees sorted by their hiring date (earliest to latest)\n" +
                        "Employee - 1\n" +
                        "- id: " + employee3.getId() + "\n" +
                        "- name: " + employee3.getName() + "\n" +
                        "- gender: " + employee3.getGender() + "\n" +
                        "- salary: " + employee3.getSalary() + "\n" +
                        "- startDate: " + employee3.getStartDate() + "\n" +
                        "-".repeat(30) + "\n" +
                        "Employee - 2\n" +
                        "- id: " + employee2.getId() + "\n" +
                        "- name: " + employee2.getName() + "\n" +
                        "- gender: " + employee2.getGender() + "\n" +
                        "- salary: " + employee2.getSalary() + "\n" +
                        "- startDate: " + employee2.getStartDate() + "\n" +
                        "-".repeat(30) + "\n" +
                        "Employee - 3\n" +
                        "- id: " + employee1.getId() + "\n" +
                        "- name: " + employee1.getName() + "\n" +
                        "- gender: " + employee1.getGender() + "\n" +
                        "- salary: " + employee1.getSalary() + "\n" +
                        "- startDate: " + employee1.getStartDate() + "\n" +
                        "-".repeat(30) + "\n" +
                        "Press ENTER to return to the menu...\n" +
                        "████████████████████████████████████████████████████████████████████████████████\n";

        String actualOptionLayout = AppMenu.getEmployeesByHiringDate();

        // Then
        assertEquals(expectedOptionLayout, actualOptionLayout);

    }

    @Test
    public void testDisplayShutDownMenu() {
        // When
        String expectedOptionLayout = """
                ████████████████████████████████████████████████████████████████████████████████
                Shutting down...
                ████████████████████████████████████████████████████████████████████████████████
                   """;

        String actualOptionLayout = AppMenu.getShutdownMessage();

        // Then
        assertEquals(expectedOptionLayout, actualOptionLayout);

    }
}
