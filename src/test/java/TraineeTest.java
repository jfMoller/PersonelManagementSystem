import org.example.ppab.entities.Trainee;
import org.example.ppab.enums.Gender;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.example.ppab.enums.Gender.MALE;
import static org.example.ppab.enums.PerformanceGrade.A;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TraineeTest {

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
