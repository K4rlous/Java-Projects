package io.github.k4rlous.hangmangame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> secretWords = new ArrayList<>();
        secretWords.add("banana");
        secretWords.add("terminal");
        secretWords.add("hotel");
        secretWords.add("animal");
        secretWords.add("hospital");
        secretWords.add("motor");
        secretWords.add("radio");
        secretWords.add("piano");
        secretWords.add("virus");
        secretWords.add("internet");
        secretWords.add("taxi");
        secretWords.add("chocolate");
        secretWords.add("digital");
        secretWords.add("video");
        secretWords.add("bar");
        secretWords.add("menu");
        secretWords.add("email");

        // Avoid duplicates and choose a random word
        Random random = new Random();
        String secretWord = secretWords.get(random.nextInt(secretWords.size()));
        ArrayList<Character> discoveredLetters = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            discoveredLetters.add('_');
        }
        int attempts = 6;
        boolean wordDiscovered = false;
        ArrayList<Character> guessedLetters = new ArrayList<>();
        System.out.println("Welcome to the Hangman Game!");
        System.out.println("Guess the secret word. You have " + attempts + " attempts.\n");
        while (!wordDiscovered && attempts > 0) {
            System.out.print("Word: ");
            for (char c : discoveredLetters) System.out.print(c + " ");
            System.out.println();
            System.out.print("Enter a letter: ");
            String input = scanner.next().toLowerCase();

            // Check for invalid input
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter only one valid letter!");
                continue;
            }
            char guess = input.charAt(0);

            // Check if letter was already guessed
            if (guessedLetters.contains(guess)) {
                System.out.println("You already tried that letter!");
                continue;
            }
            guessedLetters.add(guess);
            boolean hit = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    discoveredLetters.set(i, guess);
                    hit = true;
                }
            }
            if (hit) {
                System.out.println("Good job! The letter '" + guess + "' is in the word!");
            } else {
                attempts--;
                System.out.println("The letter '" + guess + "' is not in the word. You have " + attempts + " attempts left.");
            }
            wordDiscovered = !discoveredLetters.contains('_');
            System.out.println();
        }
        if (wordDiscovered) {
            System.out.println("Congratulations! You guessed it! The word was: " + secretWord);
        } else {
            System.out.println("You lost! The word was: " + secretWord);
        }
        scanner.close();
    }
}
