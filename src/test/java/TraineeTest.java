import org.example.ppab.entities.Personnel;
import org.example.ppab.entities.Trainee;
import org.example.ppab.enums.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.example.ppab.enums.Gender.MALE;
import static org.example.ppab.enums.PerformanceGrade.A;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TraineeTest {

    @BeforeEach
    public void clearBefore() {
        Personnel.clearPersonnel();
    }

    @AfterEach
    public void clearAfter() {
        Personnel.clearPersonnel();
    }

    @Test
    public void testTraineeConstructorArguments() {
        // Given
        String name = "John Doe";
        Gender gender = MALE;
        LocalDateTime startDate = LocalDateTime.of(2023, 6, 8, 8, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 9, 8, 8, 0);

        // When
        Trainee trainee = new Trainee(name, gender, startDate, endDate);

        // Then
        assertNotNull(trainee);
        assertEquals(name, trainee.getName());
        assertEquals(gender, trainee.getGender());
        assertEquals(startDate, trainee.getStartDate());
        assertEquals(endDate, trainee.getEndDate());
    }

    @Test
    void testTraineeSetterMethods() {
        // Given
        Trainee trainee = new Trainee(
                "Sid", MALE,
                LocalDateTime.of(1995, 5, 4, 9, 0),
                LocalDateTime.of(1995, 9, 5, 17, 0));

        // When
        LocalDateTime expectedStartDate = LocalDateTime.of(2000, 5, 4, 9, 0);
        LocalDateTime expectedEndDate = LocalDateTime.of(2000, 7, 7, 17, 0);

        trainee.setStartDate(expectedStartDate);
        trainee.setEndDate(expectedEndDate);

        // Then
        assertEquals(expectedStartDate, trainee.getStartDate());
        assertEquals(expectedEndDate, trainee.getEndDate());
    }

    @Test
    public void testTraineePerformanceAssessment() {
        // Given
        String name = "John Doe";
        Gender gender = MALE;
        LocalDateTime startDate = LocalDateTime.of(2023, 6, 8, 8, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 9, 8, 8, 0);

        // When
        Trainee trainee = new Trainee(name, gender, startDate, endDate);

        String expectedPerformanceAssessment =
                "Assessment of: " + name +
                        ", related to the trainee period: " + startDate + " - " + endDate +
                        ", performance grade: " + A;

        String performanceAssessment = trainee.getPerformanceAssessment(A);

        // Then
        assertEquals(expectedPerformanceAssessment, performanceAssessment);
    }
}
