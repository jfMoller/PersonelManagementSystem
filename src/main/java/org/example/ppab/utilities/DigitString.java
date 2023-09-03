package org.example.ppab.utilities;

import java.util.Random;

public class DigitString {
    public static String generateRandomDigits(int stringLength, boolean isEvenLastDigit) {
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

    private static int generateRandomDigit(boolean isEven) {
        Random random = new Random();
        int randomDigit;
        do {
            randomDigit = random.nextInt(10);
        } while ((randomDigit == 0) || (isEven ? randomDigit % 2 != 0 : randomDigit % 2 == 0));
        return randomDigit;
    }

}
