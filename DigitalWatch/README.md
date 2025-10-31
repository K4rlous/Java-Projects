# ⌚ Digital Watch

A simple digital clock application built with **JavaFX**.  
Displays the current time in HH:mm:ss format with real-time updates.

## Features

- Real-time clock display
- 24-hour format (HH:mm:ss)
- Clean, minimalist interface with black background and yellow text
- Updates every second using JavaFX Timeline animation

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
   --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls
```
Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder
6. Run the `MainApp` class

### Option 2: Using Command Line

1. Compile the project:
```bash
   javac --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls -d out src/main/java/io/github/k4rlous/digitalwatch/MainApp.java
```

2. Run the application:
```bash
   java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls -cp out io.github.k4rlous.digitalwatch.MainApp
```

### Option 3: Building a JAR file

1. Create a JAR using your IDE or Maven/Gradle
2. Run with:
```bash
   java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls -jar DigitalWatch.jar
```

> **Note:** Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder.  
> Example: `C:\javafx-sdk-21\lib` (Windows) or `/usr/lib/javafx-sdk-21/lib` (Linux)

## Icon Credit

Smart watch icons created by [Ehtisham Abid - Flaticon](https://www.flaticon.com/free-icons/smart-watch)