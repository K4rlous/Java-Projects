# 🍔 BMI Calculator

A simple BMI (Body Mass Index) calculator built with **JavaFX**.  
Calculations and classifications are based on data from the **World Health Organization (WHO)**.

## Features

- Input weight (kg) and height (m)
- Calculates BMI and displays classification
- Reference link to the WHO BMI fact sheet

## Requirements

- Java 11 or higher
- JavaFX SDK 11 or higher

> JavaFX is required to run this application.  
> You can download it from [Gluon](https://gluonhq.com/products/javafx/).

## How to Run

### Option 1: Using IntelliJ IDEA

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

### Option 2: Using Command Line

1. Compile the project:
```bash
   javac --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -d out src/main/java/io/github/k4rlous/bmicalculator/MainApp.java
```

2. Run the application:
```bash
   java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -cp out io.github.k4rlous.bmicalculator.MainApp
```

### Option 3: Building a JAR file

1. Create a JAR using your IDE or Maven/Gradle
2. Run with:
```bash
   java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -jar BMICalculator.jar
```

> **Note:** Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder.  
> Example: `C:\javafx-sdk-21\lib` (Windows) or `/usr/lib/javafx-sdk-21/lib` (Linux)

## Icon Credit

Hamburger icons created by [Freepik - Flaticon](https://www.flaticon.com/free-icons/hamburger)