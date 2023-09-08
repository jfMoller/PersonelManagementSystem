package org.example.ppab.entities;

import org.example.ppab.enums.Gender;
import org.example.ppab.utilities.DigitString;

import java.util.ArrayList;
import java.util.List;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;

public class Personnel {
    private final String id;
    private String name;
    private Gender gender;

    protected static List<Personnel> personnel = new ArrayList<>();

    public Personnel(String name, Gender gender) {
        this.id = getUniqueId(gender);
        this.name = name;
        this.gender = gender;
        personnel.add(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static List<Personnel> getPersonnel() {
        return personnel;
    }

    public static void clearPersonnel() {
        //used for testing purposes
        personnel.clear();
    }

    private String getUniqueId(Gender gender) {
        int idLength = 12;

        if (gender.equals(MALE)) return DigitString.generateRandomDigits(idLength, false);

        else if (gender.equals(FEMALE)) return DigitString.generateRandomDigits(idLength, true);

        else throw new IllegalArgumentException("Invalid gender enum: " + gender);
    }

    public static int getTotalPersonnel() {
        return personnel.size();
    }

    public static int getTotalEmployees() {
        return countPersonnelCohort(Employee.class);
    }

    public static int getTotalEmployees(Gender gender) {
        return countPersonnelCohort(Employee.class, gender);
    }

    public static int getTotalTrainees() {
        return countPersonnelCohort(Trainee.class);
    }

    public static List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<>();

        for (Personnel person : personnel) {
            if (person instanceof Employee) {
                employees.add((Employee) person);
            }
        }

        return employees;
    }

    public static List<Trainee> getTraineesList() {
        List<Trainee> trainees = new ArrayList<>();

        for (Personnel person : personnel) {
            if (person instanceof Trainee) {
                trainees.add((Trainee) person);
            }
        }

        return trainees;
    }

    private static int countPersonnelCohort(Class<?> cohort) {
        int count = 0;
        for (Personnel person : personnel) {
            if (cohort.isInstance(person)) {
                count++;
            }
        }
        return count;
    }

    private static int countPersonnelCohort(Class<?> cohort, Gender gender) {
        int count = 0;
        for (Personnel person : personnel) {
            if (cohort.isInstance(person) && person.gender == gender) {
                count++;
            }
        }
        return count;
    }

}
