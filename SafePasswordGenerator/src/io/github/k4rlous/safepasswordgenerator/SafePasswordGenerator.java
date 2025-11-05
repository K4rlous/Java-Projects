package io.github.k4rlous.safepasswordgenerator;

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SafePasswordGenerator {
    private static final String CHARACTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789!@#$%&*()_+-=[]/,.|?<>'";

    // The intention is to make the 'generatePassword' method available for use at any time
    public static String generatePassword(int length) {
        SecureRandom randomNumberGenerator = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // Generate a random index number between 0 and CHARACTERS.length() - 1
            int index = randomNumberGenerator.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the desired password length (Kaspersky recommends 16): ");
            int length = scanner.nextInt();
            String password = generatePassword(length);
            System.out.println("Your password is: " + password);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter only whole numbers.");
        }
    }
}
