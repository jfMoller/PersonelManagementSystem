import org.example.ppab.entities.Employee;
import org.example.ppab.entities.Personnel;
import org.example.ppab.entities.Trainee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Scanner;

import static org.example.ppab.enums.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    @BeforeEach
    public void setUp() {
        // Clear the personell list before each test
        Personnel.clearPersonnel();
    }

    @Test
    public void testMenuLayout() {
        // Given
        Menu.run();

        // When
        String expectedMenuLayout = """
                Perfect Products AB
                Welcome to the Personnel Management System!

                1. Display total number of people in the system
                2. Display average salary for men and women among employees
                3. Display a list of employees sorted by their hiring date (earliest to latest)
                4. Exit

                Please enter your choice (1/2/3/4): 
                """;

        // Then
        assertEquals(expectedMenuLayout, Menu.run());
    }

    @Test
    public void testDisplayTotalNumberOfPeople() {
        // Given
        Employee employee = new Employee(
                "Sid", MALE, 42000,
                LocalDateTime.of(1995, 5, 4, 9, 0));

        Trainee trainee = new Trainee(
                "Jonathan", MALE,
                LocalDateTime.of(1995, 5, 4, 9, 0),
                LocalDateTime.of(1995, 9, 5, 17, 0));

        Menu.run();
        int userInput = 1;

        // When
        String expectedOptionLayout = """
                1. Display total number of people in the system
                    - Amount of employees: 1
                    - Amount of trainees: 1
                    - Total amount of people: 2
                    
                Press any key to return to the menu:
                """;

        // Then
        assertEquals(expectedOptionLayout, Menu.run());

    }
}
