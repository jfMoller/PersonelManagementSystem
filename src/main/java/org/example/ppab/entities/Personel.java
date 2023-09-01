package org.example.ppab.entities;

import org.example.ppab.DigitString;
import org.example.ppab.enums.Gender;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;

public class Personel {
    private final String id;
    private String name;
    private final Gender gender;

    public Personel(String name, Gender gender) {
        this.id = getUniqueId(gender);
        this.name = name;
        this.gender = gender;
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

    private String getUniqueId(Gender gender) {
        int idLength = 12;

        if (gender.equals(MALE)) return DigitString.generateRandomDigits(idLength, false);

        else if (gender.equals(FEMALE)) return DigitString.generateRandomDigits(idLength, true);

        else throw new IllegalArgumentException("Invalid gender enum: " + gender);
    }
}
