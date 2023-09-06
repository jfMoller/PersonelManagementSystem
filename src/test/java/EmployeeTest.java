import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.enums.Gender;
import org.example.ppab.utilities.PersonnelUtility;
import org.junit.jupiter.api.AfterEach;
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
    @AfterEach
    public void clearPersonnel() {
        Personnel.clearPersonnel();
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
        Employee employee = PersonnelUtility.createEmployee(30000);
        double initialSalary = employee.getSalary();
        double salaryIncrease = 3000;

        // When
        employee.adjustSalary(salaryIncrease);
        double increasedSalary = employee.getSalary();

        // Then
        assertEquals((initialSalary + salaryIncrease), increasedSalary);
    }

    @Test
    public void testDecreaseEmployeeSalary() {
        // Given
        Employee employee = PersonnelUtility.createEmployee(23000);
        double initialSalary = employee.getSalary();
        double salaryDecrease = -3000;

        // When
        employee.adjustSalary(salaryDecrease);
        double decreasedSalary = employee.getSalary();

        // Then
        assertEquals((initialSalary + salaryDecrease), decreasedSalary);

    }

    @Test
    void testEmployeeSetterMethods() {
        // Given
        double initialSalary = 42000;
        LocalDateTime initialStartDate = LocalDateTime.of(1995, 5, 4, 9, 0);
        Employee employee = PersonnelUtility.createEmployee(initialSalary, initialStartDate);

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
        Employee maleEmployee1 = PersonnelUtility.createEmployee(MALE, 42000);
        Employee maleEmployee2 = PersonnelUtility.createEmployee(MALE, 29000);

        Employee femaleEmployee1 = PersonnelUtility.createEmployee(FEMALE, 42000);
        Employee femaleEmployee2 = PersonnelUtility.createEmployee(FEMALE, 29000);

        List<Employee> employees = new ArrayList<>(List.of(
                maleEmployee1, maleEmployee2, femaleEmployee1, femaleEmployee2));

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
    public void testSortingOfEmployeesByStartDate() {
        // Given
        Employee employee1 = PersonnelUtility.createEmployee(
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Employee employee2 = PersonnelUtility.createEmployee(
                LocalDateTime.of(1995, 5, 4, 10, 0));

        Employee employee3 = PersonnelUtility.createEmployee(
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

}
