import org.example.ppab.entities.Employee;
import org.example.ppab.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @BeforeEach
    public void setUp() {
        // Clear the Employee list before each test
        Employee.clearEmployees();
    }

    @Test
    public void testEmployeeConstructorArguments() {
        // Given
        String name = "John Doe";
        Gender gender = MALE;
        Double salary = 30000d;
        LocalDateTime startDate = LocalDateTime.of(2023, 9, 8, 8, 0);

        // When
        Employee employee = new Employee(name, gender, salary, startDate);

        // Then
        assertNotNull(employee);
        assertEquals(name, employee.getName());
        assertEquals(gender, employee.getGender());
        assertEquals(salary, employee.getSalary());
        assertEquals(startDate, employee.getStartDate());
    }

    @Test
    public void testIncreaseEmployeeSalary() {
        // Given
        String name = "Jane Doe";
        Gender gender = FEMALE;
        Double salary = 30000d;
        LocalDateTime startDate = LocalDateTime.of(2023, 9, 9, 9, 0);

        // When
        Employee employee = new Employee(name, gender, salary, startDate);

        double initialSalary = employee.getSalary();
        double salaryIncrease = 3000;

        employee.adjustSalary(salaryIncrease);
        double increasedSalary = employee.getSalary();

        // Then
        assertEquals((initialSalary + salaryIncrease), increasedSalary);
    }

    @Test
    public void testDecreaseEmployeeSalary() {
        // Given
        String name = "John Doe";
        Gender gender = MALE;
        double salary = 23000d;
        LocalDateTime startDate = LocalDateTime.of(2022, 5, 4, 7, 1);

        // When
        Employee employee = new Employee(name, gender, salary, startDate);

        double initialSalary = employee.getSalary();
        double salaryDecrease = -3000;

        employee.adjustSalary(salaryDecrease);
        double decreasedSalary = employee.getSalary();

        // Then
        assertEquals((initialSalary + salaryDecrease), decreasedSalary);

    }

    @Test
    void testEmployeeSetterMethods() {
        // Given
        Employee employee = new Employee(
                "Sid", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        // When
        double expectedSalary = 50000;
        LocalDateTime expectedStartDate = LocalDateTime.of(2000, 6, 2, 8, 15);

        employee.setSalary(expectedSalary);
        employee.setStartDate(expectedStartDate);

        // Then
        assertEquals(expectedSalary, employee.getSalary());
        assertEquals(expectedStartDate, employee.getStartDate());
    }

    @Test
    public void testComparingMeanSalaryByGender() {
        // Given
        Employee maleEmployee1 = new Employee(
                "Sid", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Employee maleEmployee2 = new Employee(
                "Landon", MALE, 29000,
                LocalDateTime.of(1995, 5, 4, 10, 0));

        Employee femaleEmployee1 = new Employee(
                "Anna", FEMALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Employee femaleEmployee2 = new Employee(
                "Lilian", FEMALE, 29000,
                LocalDateTime.of(1995, 5, 4, 10, 0));

        List<Employee> employees = new ArrayList<>(List.of(maleEmployee1, maleEmployee2, femaleEmployee1, femaleEmployee2));

        // Then
        double expectedMaleMeanSalary = (maleEmployee1.getSalary() + maleEmployee2.getSalary()) / 2;

        double maleMeanSalary = employees.stream()
                .filter(employee -> employee.getGender() == Gender.MALE)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        double expectedFemaleMeanSalary = (femaleEmployee1.getSalary() + femaleEmployee2.getSalary()) / 2;

        double femaleMeanSalary = employees.stream()
                .filter(employee -> employee.getGender() == Gender.FEMALE)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        // When
        assertEquals(expectedMaleMeanSalary, maleMeanSalary);
        assertEquals(expectedFemaleMeanSalary, femaleMeanSalary);
        assertTrue(maleMeanSalary == femaleMeanSalary);
    }

    @Test
    void testEmployeesArrayListInstance() {
        // Given


        Employee employee1 = new Employee(
                "Mark", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));


        Employee employee2 = new Employee(
                "Norm", MALE, 42000,
                LocalDateTime.of(2010, 5, 4, 8, 15));

        // When
        int expectedEmployeesSize = Employee.getEmployees().size();

        // Then
        assertEquals(expectedEmployeesSize, 2);

        // When
        List<Employee> expectedEmployees = new ArrayList<>(List.of(employee1, employee2));
        List<Employee> employees = Employee.getEmployees();

        // Then
        assertEquals(expectedEmployees, employees);
    }

    @Test
    public void testSortingOfEmployeesByStartDate() {
        // Given
        Employee employee1 = new Employee(
                "Mark", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Employee employee2 = new Employee(
                "Jenny", FEMALE, 42000,
                LocalDateTime.of(1995, 5, 4, 10, 0));

        Employee employee3 = new Employee(
                "Norm", MALE, 39000,
                LocalDateTime.of(2010, 5, 4, 8, 0));

        List<Employee> employees = new ArrayList<>(List.of(employee1, employee2, employee3));

        // When
        //sorting by longest time employed
        Collections.sort(employees, Comparator.comparing(Employee::getStartDate));
        List<Employee> expectedAscendingOrder = List.of(employee1, employee2, employee3);

        // Then
        assertTrue(employees.equals(expectedAscendingOrder));

        // When
        //sorting by shortest time employed
        Collections.sort(employees, Comparator.comparing(Employee::getStartDate).reversed());
        List<Employee> expectedDescendingOrder = List.of(employee3, employee2, employee1);

        // Then
        assertTrue(employees.equals(expectedDescendingOrder));
    }

    @Test
    public void testEmployeeDetails() {
        // Given
        Employee employee1 = new Employee(
                "Mark", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        // When
        String expectedEmployeeDetails = "Employee - " + "1" +
                " - id: " + employee1.getId() +
                " - name: " + employee1.getName() +
                " - gender: " + employee1.getGender() +
                " - salary: " + employee1.getSalary() +
                " - startDate: " + employee1.getStartDate() +
                "-".repeat(30);

        String employeeDetails = employee1.printDetails(1);

        // Then
        assertEquals(expectedEmployeeDetails, employeeDetails);
    }
}
