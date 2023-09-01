import org.example.ppab.entities.Personel;
import org.example.ppab.enums.Gender;
import org.junit.jupiter.api.Test;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.*;

public class PersonelTest {

    @Test
    public void testPersonellConstructorArguments() {
        // Given
        String name = "John Doe";
        Gender gender = MALE;

        // When
        Personel personel = new Personel(name, gender);

        // Then
        assertNotNull(personel);
        assertEquals(name, personel.getName());
        assertEquals(gender, personel.getGender());
    }

    @Test
    public void testMalePersonellIdFormat() {
        // Given
        Personel malePersonel = new Personel("John", MALE);

        // When
        String maleId = malePersonel.getId();

        // Then
        assertTrue(maleId.matches("^[0-9]{11}[13579]$")); // Matches 11 digits followed by an uneven number
    }

    @Test
    public void testFemalePersonellIdFormat() {
        // Given
        Personel femalePersonel = new Personel("Jane", FEMALE);

        // When
        String femaleId = femalePersonel.getId();

        // Then
        assertTrue(femaleId.matches("^[0-9]{11}[2468]$")); // Matches 11 digits followed by an even number
    }

}
