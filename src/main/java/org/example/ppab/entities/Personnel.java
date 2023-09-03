package org.example.ppab.entities;

import org.example.ppab.utilities.DigitString;
import org.example.ppab.enums.Gender;

import java.util.ArrayList;
import java.util.List;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;

public class Personnel {
    private final String id;
    private String name;
    private Gender gender;

    private static List<Personnel> personnel = new ArrayList<>();

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
}
