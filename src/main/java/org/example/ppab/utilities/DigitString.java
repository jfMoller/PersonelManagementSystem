package org.example.ppab.utilities;

import java.security.SecureRandom;

public class DigitString {
    private static final int MAX_DIGIT = 10; // Sets maximum digit value (0-9)
    private static final SecureRandom secureRandom = new SecureRandom();

    /**
     * Generates a random string of digits with the given length and an option to have an even or odd last digit.
     *
     * @param stringLength    -> The length of the generated string.
     * @param isEvenLastDigit -> If true, ensures the last digit is even; if false, ensures the last digit is uneven.
     * @return -> A randomly generated string of digits.
     */
    public static String generateRandomDigits(int stringLength, boolean isEvenLastDigit) {
        StringBuilder digits = new StringBuilder(stringLength - 1);

        for (int digit = 1; digit <= stringLength - 1; ++digit) {
            int randomDigit = generateRandomDigit();
            digits.append(randomDigit);
        }

        int lastDigit = generateRandomDigit(isEvenLastDigit);
        digits.append(lastDigit);

        return digits.toString();
    }

    /**
     * Generates a random digit between 0 and 9.
     *
     * @return -> A random digit.
     */
    private static int generateRandomDigit() {
        return secureRandom.nextInt(MAX_DIGIT);
    }

    /**
     * Generates a random digit that is either even or odd based on the provided flag.
     *
     * @param isEven -> If true, generates an even digit; if false, generates an uneven digit.
     * @return -> A randomly generated even or odd digit.
     */
    private static int generateRandomDigit(boolean isEven) {
        int randomDigit;
        do {
            randomDigit = generateRandomDigit();
        } while ((randomDigit == 0) || (isEven ? randomDigit % 2 != 0 : randomDigit % 2 == 0));
        return randomDigit;
    }
}