import org.example.ppab.entities.Personell;
import org.example.ppab.enums.Gender;
import org.junit.jupiter.api.Test;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class PersonellTest {

    @Test
    public void testPersonellConstructorArguments() {
        // Given
        String name = "John Doe";
        Gender gender = MALE;

        // When
        Personell personell = new Personell(name, gender);

        // Then
        assertNotNull(personell);
        assertEquals(name, personell.getName());
        assertEquals(gender, personell.getGender());
    }

    @Test
    public void testMalePersonellIdFormat() {
        // Given
        Personell malePersonell = new Personell("John", MALE);

        // When
        String maleId = malePersonell.getId();

        // Then
        assertTrue(maleId.matches("^[0-9]{11}[13579]$")); // Matches 11 digits followed by an uneven number
    }

    @Test
    public void testFemalePersonellIdFormat() {
        // Given
        Personell femalePersonell = new Personell("Jane", FEMALE);

        // When
        String femaleId = femalePersonell.getId();

        // Then
        assertTrue(femaleId.matches("^[0-9]{11}[2468]$")); // Matches 11 digits followed by an even number
    }

}
