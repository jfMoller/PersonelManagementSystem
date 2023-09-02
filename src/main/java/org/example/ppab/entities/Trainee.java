package org.example.ppab.entities;

import org.example.ppab.enums.Gender;
import org.example.ppab.enums.PerformanceGrade;

import java.time.LocalDateTime;

public class Trainee extends Personnel {
    private final LocalDateTime startDate;

    private final LocalDateTime endDate;

    public Trainee(String name, Gender gender, LocalDateTime startDate, LocalDateTime endDate) {
        super(name, gender);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getPerformanceAssessment(PerformanceGrade grade) {
        return "Assessment of: " + this.getName() +
                ", related to the trainee period: " + startDate + " - " + endDate +
                ", performance grade: " + grade;
    }
}
