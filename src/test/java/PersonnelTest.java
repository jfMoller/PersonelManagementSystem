import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.entities.Trainee;
import org.example.ppab.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class PersonnelTest {

    @BeforeEach
    public void setUp() {
        // Clear the personell list before each test
        Personnel.clearPersonnel();
    }

    @Test
    public void testPersonellConstructorArguments() {
        // Given
        String name = "John Doe";
        Gender gender = MALE;

        // When
        Personnel personnel = new Personnel(name, gender);

        // Then
        assertNotNull(personnel);
        assertEquals(name, personnel.getName());
        assertEquals(gender, personnel.getGender());
    }

    @Test
    void testPersonellSetterMethods() {
        // Given
        Personnel personnel = new Personnel("Sid", MALE);

        // When
        String expectedName = "Sidney";
        Gender expectedGender = FEMALE;

        personnel.setName(expectedName);
        personnel.setGender(expectedGender);

        // Then
        assertEquals(expectedName, personnel.getName());
        assertEquals(expectedGender, personnel.getGender());
    }

    @Test
    public void testMalePersonellIdFormat() {
        // Given
        Personnel malePersonnel = new Personnel("John", MALE);

        // When
        String maleId = malePersonnel.getId();

        // Then
        assertTrue(maleId.matches("^[0-9]{11}[13579]$")); // Matches 11 digits followed by an uneven number
    }

    @Test
    public void testFemalePersonellIdFormat() {
        // Given
        Personnel femalePersonnel = new Personnel("Jane", FEMALE);

        // When
        String femaleId = femalePersonnel.getId();

        // Then
        assertTrue(femaleId.matches("^[0-9]{11}[2468]$")); // Matches 11 digits followed by an even number
    }

    @Test
    void testPersonnelArrayListInstance() {
        // Given
        Employee employee = new Employee(
                "Sid", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Trainee trainee = new Trainee(
                "Jonathan", MALE,
                LocalDateTime.of(1995, 5, 4, 9, 0),
                LocalDateTime.of(1995, 9, 5, 17, 0));

        // When
        int expectedPersonnelSize = Personnel.getPersonnel().size();

        // Then
        assertEquals(expectedPersonnelSize, 2);

        // When
        List<Personnel> expectedPersonnel = new ArrayList<>(List.of(employee, trainee));
        List<Personnel> personnel = Personnel.getPersonnel();

        // Then
        assertEquals(expectedPersonnel, personnel);
    }

    @Test
    public void testShowPersonnel() {
        // Given
        int expectedEmployeeCount = 1;
        int expectedTraineeCount = 1;
        int expectedPersonnelCount = expectedEmployeeCount + expectedTraineeCount;

        // When
        Employee employee = new Employee(
                "Sid", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Trainee trainee = new Trainee(
                "Jonathan", MALE,
                LocalDateTime.of(1995, 5, 4, 9, 0),
                LocalDateTime.of(1995, 9, 5, 17, 0));

        // Then
        int employeeCount = 0;
        int traineeCount = 0;
        List<Personnel> personnel = Personnel.getPersonnel();

        for (Personnel person : personnel) {
            if (person instanceof Employee) {
                employeeCount++;
            } else if (person instanceof Trainee) {
                traineeCount++;
            }
        }

        assertEquals(expectedEmployeeCount, employeeCount);
        assertEquals(expectedTraineeCount, traineeCount);
        assertEquals(expectedPersonnelCount, (traineeCount + employeeCount));
    }
}
