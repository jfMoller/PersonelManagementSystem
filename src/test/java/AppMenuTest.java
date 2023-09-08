import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.entities.Trainee;
import org.example.ppab.enums.Gender;
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
                █ 4. Add new personnel                                                         █
                █ 5. Exit                                                                      █
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
    public void testAddNewPersonnel() {
        // When
        String expectedOptionLayout =
                """
                ████████████████████████████████████████████████████████████████████████████████
                █                            4. Add new personnel                              █
                ████████████████████████████████████████████████████████████████████████████████
                █ 1. Add new employee                                                          █
                █ 2. Add new trainee                                                           █
                ████████████████████████████████████████████████████████████████████████████████
                █ Please enter your choice (1/2):                                              █
                ████████████████████████████████████████████████████████████████████████████████
                """;

        String actualOptionLayout = AppMenu.getAddNewPersonnel();

        // Then
        assertEquals(expectedOptionLayout, actualOptionLayout);

    }

    @Test
    public void testAddNewEmployee() {
        // Given

        // When
        String expectedEmployeeOptionLayout =
                "████████████████████████████████████████████████████████████████████████████████\n" +
                        "4. Add new personnel - Employee \n" +
                        "To add a new employee, copy and paste the text below," + "\n" +
                        "replacing <values> with the values for that employee." + "\n" +
                        "-".repeat(30) + "\n" +
                        "<name>,<MALE or FEMALE>,<salary>,<YYYY-M-D-H-M>" + "\n" +
                        "-".repeat(30) + "\n" +
                        "For example: John Miller,MALE,42000,2023-9-8-8-0"  + "\n" +
                        "████████████████████████████████████████████████████████████████████████████████\n";

        String expectedInput = "John Miller,MALE,42000,2023-9-8-8-0";

        String[] expectedValues = expectedInput.split(",");
        String expectedName = expectedValues[0];
        Gender expectedGender = expectedValues[1].equals("MALE") ? MALE : FEMALE;
        double expectedSalary = Double.parseDouble(expectedValues[2]);

        String[] expectedDateValues = expectedValues[3].split("-");
        int expectedYear = Integer.parseInt(expectedDateValues[0]);
        int expectedMonth = Integer.parseInt(expectedDateValues[1]);
        int expectedDay = Integer.parseInt(expectedDateValues[2]);
        int expectedHour = Integer.parseInt(expectedDateValues[3]);
        int expectedMinute = Integer.parseInt(expectedDateValues[4]);
        LocalDateTime expectedStartDate = LocalDateTime.of(
                expectedYear, expectedMonth, expectedDay, expectedHour, expectedMinute);

        // Based on "John Miller,MALE,42000,2023-9-8-8-0"
        Employee actualEmployee = PersonnelUtility.createEmployee("John Miller", MALE, 42000,
                LocalDateTime.of(2023, 9, 8, 8, 0));

        String actualName = actualEmployee.getName();
        Gender actualGender = actualEmployee.getGender();
        double actualSalary = actualEmployee.getSalary();
        LocalDateTime actualStartDate = actualEmployee.getStartDate();

        String actualOptionLayout = AppMenu.getAddNewEmployee();

        // Then
        assertEquals(expectedName, actualName);
        assertEquals(expectedGender, actualGender);
        assertEquals(expectedSalary, actualSalary);
        assertEquals(expectedStartDate, actualStartDate);

        assertEquals(expectedEmployeeOptionLayout, actualOptionLayout);

    }

    @Test
    public void testAddNewTrainee() {
        // When
        String expectedEmployeeOptionLayout =
                "████████████████████████████████████████████████████████████████████████████████\n" +
                        "4. Add new personnel - Trainee \n" +
                        "To add a new trainee, copy and paste the text below," + "\n" +
                        "replacing <values> with the values for that trainee." + "\n" +
                        "-".repeat(30) + "\n" +
                        "<name>,<MALE or FEMALE>,<YYYY-M-D-H-M>,<YYYY-M-D-H-M>" + "\n" +
                        "-".repeat(30) + "\n" +
                        "For example: Janet Mills,FEMALE,2023-9-8-8-0,2023-12-8-17-0"  + "\n" +
                        "████████████████████████████████████████████████████████████████████████████████\n";

        String expectedInput = "Janet Mills,FEMALE,2023-9-8-8-0,2023-12-8-17-0";

        String[] expectedValues = expectedInput.split(",");
        String expectedName = expectedValues[0];
        Gender expectedGender = expectedValues[1].equals("FEMALE") ? FEMALE : MALE;

        String[] expectedStartDateValues = expectedValues[2].split("-");
        int expectedStartYear = Integer.parseInt(expectedStartDateValues[0]);
        int expectedStartMonth = Integer.parseInt(expectedStartDateValues[1]);
        int expectedStartDay = Integer.parseInt(expectedStartDateValues[2]);
        int expectedStartHour = Integer.parseInt(expectedStartDateValues[3]);
        int expectedStartMinute = Integer.parseInt(expectedStartDateValues[4]);
        LocalDateTime expectedStartDate = LocalDateTime.of(
                expectedStartYear, expectedStartMonth, expectedStartDay, expectedStartHour, expectedStartMinute);

        String[] expectedEndDateValues = expectedValues[3].split("-");
        int expectedEndYear = Integer.parseInt(expectedEndDateValues[0]);
        int expectedEndMonth = Integer.parseInt(expectedEndDateValues[1]);
        int expectedEndDay = Integer.parseInt(expectedEndDateValues[2]);
        int expectedEndHour = Integer.parseInt(expectedEndDateValues[3]);
        int expectedEndMinute = Integer.parseInt(expectedEndDateValues[4]);
        LocalDateTime expectedEndDate = LocalDateTime.of(
                expectedEndYear, expectedEndMonth, expectedEndDay, expectedEndHour, expectedEndMinute);

        // Based on "Janet Mills,FEMALE,2023-9-8-8-0,2023-12-8-17-0"
        Trainee actualTrainee = PersonnelUtility.createTrainee("Janet Mills", FEMALE,
                LocalDateTime.of(2023, 9, 8, 8, 0),
                LocalDateTime.of(2023, 12, 8, 17, 0));

        String actualName = actualTrainee.getName();
        Gender actualGender = actualTrainee.getGender();
        LocalDateTime actualStartDate = actualTrainee.getStartDate();
        LocalDateTime actualEndDate = actualTrainee.getEndDate();

        String actualOptionLayout = AppMenu.getAddNewTrainee();

        // Then
        assertEquals(expectedName, actualName);
        assertEquals(expectedGender, actualGender);
        assertEquals(expectedStartDate, actualStartDate);
        assertEquals(expectedEndDate, actualEndDate);

        assertEquals(expectedEmployeeOptionLayout, actualOptionLayout);

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
