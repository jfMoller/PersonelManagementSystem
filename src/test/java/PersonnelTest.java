import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.entities.Trainee;
import org.example.ppab.enums.Gender;
import org.example.ppab.utilities.PersonnelUtility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class PersonnelTest {

    @BeforeEach
    @AfterEach
    public void clearPersonnel() {
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
        Employee employee = PersonnelUtility.createEmployee();

        Trainee trainee = PersonnelUtility.createTrainee();

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
    public void testCountPersonnelCohorts() {
        // Given
        int expectedEmployeeCount = 1;
        int expectedTraineeCount = 1;
        int expectedPersonnelCount = expectedEmployeeCount + expectedTraineeCount;

        // When
        Employee employee = PersonnelUtility.createEmployee();

        Trainee trainee = PersonnelUtility.createTrainee();

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
