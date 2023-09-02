import org.example.ppab.entities.Personnel;
import org.example.ppab.enums.Gender;
import org.junit.jupiter.api.Test;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class PersonnelTest {

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

}
