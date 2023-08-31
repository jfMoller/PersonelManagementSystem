package org.example.ppab.entities;

import org.example.ppab.enums.Gender;

import java.util.Random;

import static org.example.ppab.enums.Gender.FEMALE;
import static org.example.ppab.enums.Gender.MALE;

public class Employee {
    private final String id;
    private String name;
    private final Gender gender;

    public Employee(String name, Gender gender) {
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

        if (gender.equals(MALE)) return generateUniqueDigitString(idLength, false);

        else if (gender.equals(FEMALE)) return generateUniqueDigitString(idLength, true);

        else throw new IllegalArgumentException("Invalid gender enum: " + gender);
    }

    private String generateUniqueDigitString(int stringLength, boolean isEvenLastDigit) {
        Random random = new Random();
        StringBuilder digits = new StringBuilder(stringLength);

        // Handles generation of the digits equivalent to (stringLength - 1),
        // e.g. the 11 / 12 digits if stringLength = 12
        for (int digit = 1; digit <= (stringLength - 1); ++digit) {
            int randomDigit = random.nextInt(10); // Generates a random digit between 0 and 9
            digits.append(randomDigit);
        }
        // Handles generation of the last digit
        int lastDigit = generateRandomDigit(isEvenLastDigit);
        digits.append(lastDigit);

        return digits.toString();
    }

    private int generateRandomDigit(boolean isEven) {
        Random random = new Random();
        int randomDigit;
        do {
            randomDigit = random.nextInt(10);
        } while ((randomDigit == 0) || (isEven ? randomDigit % 2 != 0 : randomDigit % 2 == 0) );
        return randomDigit;
    }

}
