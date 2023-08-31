import org.example.ppab.entities.Employee;
import org.example.ppab.enums.Gender;
import org.junit.jupiter.api.Test;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void testEmployeeConstructorArguments() {
        // Given
        String name = "John Doe";
        Gender gender = MALE;

        // When
        Employee employee = new Employee(name, gender);

        // Then
        assertNotNull(employee);
        assertEquals(name, employee.getName());
        assertEquals(gender, employee.getGender());
    }

    @Test
    public void testMaleEmployeeIdFormat() {
        // Given
        Employee maleEmployee = new Employee("John", MALE);

        // When
        String maleId = maleEmployee.getId();

        // Then
        assertTrue(maleId.matches("^[0-9]{11}[13579]$")); // Matches 11 digits followed by an uneven number
    }

    @Test
    public void testFemaleEmployeeIdFormat() {
        // Given
        Employee femaleEmployee = new Employee("Jane", FEMALE);

        // When
        String femaleId = femaleEmployee.getId();

        // Then
        assertTrue(femaleId.matches("^[0-9]{11}[2468]$")); // Matches 11 digits followed by an even number
    }

}
