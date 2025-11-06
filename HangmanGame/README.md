# 🎮 Hangman Game

A simple **Hangman** word-guessing game built with **Java**. Try to discover the secret word before running out of attempts!

## Features

- Random word selection from a predefined list
- 6 attempts to guess the word
- Input validation (single letters only)
- Prevents duplicate guesses
- Interactive command-line interface

## Requirements

- Java 11 or higher

## How to Run

### Option 1: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/main/java/io/github/k4rlous/hangmangame/MainApp.java`
3. Right-click on the file and select **Run 'MainApp.main()'**

### Option 2: Using Command Line

1. Navigate to the project directory

2. Compile the project:
```bash
javac -d out src/main/java/io/github/k4rlous/hangmangame/MainApp.java
```

3. Run the application:
```bash
java -cp out io.github.k4rlous.hangmangame.MainApp
```

### Option 3: Building a JAR file

1. Create a JAR using your IDE or build tool

2. Run with:
```bash
java -jar HangmanGame.jar
```

## How to Play

1. The game will display underscores representing each letter of the secret word
2. Enter one letter at a time to guess
3. You have 6 attempts to guess the word
4. If you guess correctly, you win! If you run out of attempts, you lose.

## Word List

The game includes 17 words such as: banana, terminal, hotel, animal, chocolate, and more!
