# 📝 Mini Text Editor

A simple text editor built with **JavaFX**. Open, edit, and save `.txt` files with an intuitive interface.

## Features

- Open and read `.txt` files
- Edit text content in a large text area
- Save files with automatic `.txt` extension
- Simple toolbar with Open and Save buttons
- Clean and minimalist interface

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
javac --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -d out src/main/java/io/github/k4rlous/minitexteditor/MainApp.java
```

2. Run the application:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -cp out io.github.k4rlous.minitexteditor.MainApp
```

### Option 3: Building a JAR file

1. Create a JAR using your IDE or Maven/Gradle

2. Run with:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -jar MiniTextEditor.jar
```

> **Note:** Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder.
> Example: `C:\javafx-sdk-21\lib` (Windows) or `/usr/lib/javafx-sdk-21/lib` (Linux)

## How to Use

1. Click **Open** to browse and open an existing `.txt` file
2. Edit the text in the text area
3. Click **Save** to save your changes (automatically adds `.txt` extension if not present)

## Icon Credit

Change icons created by [SBTS2018 - Flaticon](https://www.flaticon.com/free-icons/change)
