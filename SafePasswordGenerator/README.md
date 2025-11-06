# 🔒 Safe Password Generator

A secure password generator built with **JavaFX** and command-line support. Generate strong, random passwords using cryptographically secure methods.

## Features

- Generate cryptographically secure random passwords
- Customizable password length (default: 16 characters)
- Includes uppercase, lowercase, numbers, and special characters
- GUI interface with JavaFX
- Command-line interface option
- Non-editable password display with visual styling
- Input validation for password length

## Requirements

- Java 11 or higher
- JavaFX SDK 11 or higher (for GUI version)

> JavaFX is required to run the GUI application.
> You can download it from [Gluon](https://gluonhq.com/products/javafx/).

## How to Run

### Option 1: Using IntelliJ IDEA (GUI)

1. Open the project in IntelliJ IDEA
2. Go to **File → Project Structure → Libraries**
3. Add the JavaFX SDK library (point to the `lib` folder of your JavaFX installation)
4. Go to **Run → Edit Configurations**
5. Add VM options:
```
--module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml
```

Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder

6. Run the `MainApp` class

### Option 2: Using Command Line (GUI)

1. Compile the project:
```bash
javac --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -d out src/main/java/io/github/k4rlous/safepasswordgenerator/*.java
```

2. Run the application:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -cp out io.github.k4rlous.safepasswordgenerator.MainApp
```

### Option 3: Command Line Interface (No JavaFX needed)

1. Compile the generator class:
```bash
javac -d out src/main/java/io/github/k4rlous/safepasswordgenerator/SafePasswordGenerator.java
```

2. Run the CLI version:
```bash
java -cp out io.github.k4rlous.safepasswordgenerator.SafePasswordGenerator
```

### Option 4: Building a JAR file

1. Create a JAR using your IDE or Maven/Gradle

2. Run with:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -jar SafePasswordGenerator.jar
```

> **Note:** Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder.
> Example: `C:\javafx-sdk-21\lib` (Windows) or `/usr/lib/javafx-sdk-21/lib` (Linux)

## How to Use

### GUI Version
1. Enter the desired password length (Kaspersky recommends 16 characters)
2. Click **Generate password** button
3. Your secure password will appear in the cyan text field
4. Copy and use your new password

### CLI Version
1. Run the application
2. Enter the desired password length when prompted
3. Your secure password will be displayed in the terminal

## Security

This password generator uses `SecureRandom` from Java's security library, which provides cryptographically strong random number generation suitable for security-sensitive applications.

## Character Set

Passwords include:
- Lowercase letters (a-z)
- Uppercase letters (A-Z)
- Numbers (0-9)
- Special characters (!@#$%&*()_+-=[]/,.|?<>')

## Icon Credit

Lock icons created by [Pixel perfect - Flaticon](https://www.flaticon.com/free-icons/lock)
