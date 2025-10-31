# 🍔 BMI Calculator

A simple BMI (Body Mass Index) calculator built with **JavaFX**.  
Calculations and classifications are based on data from the **World Health Organization (WHO)**.

## Features

- Input weight (kg) and height (m)
- Calculates BMI and displays classification
- Reference link to the WHO BMI fact sheet

## Requirements

- Java 25 or compatible JDK
- JavaFX 25

> JavaFX is required to run this application.  
> You can download it from [Gluon](https://gluonhq.com/products/javafx/).

 ## How to Compile and Run

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Go to **Build → Build Artifacts → BMICalculator:jar → Build**.
3. After building, the JAR file will be located in:  
   `out/artifacts/BMICalculator_jar/BMICalculator.jar`
4. Run the application from the terminal using:
    ```
   java --module-path "PATH_TO_FX_LIB" --add-modules javafx.controls,javafx.fxml -jar out/artifacts/BMICalculator_jar/BMICalculator.jar
    ```


This will generate a folder containing `BMICalculator.exe`, which can be launched with a double-click.

## Icon Credit

Hamburger icons created by [Freepik - Flaticon](https://www.flaticon.com/free-icons/hamburger)
