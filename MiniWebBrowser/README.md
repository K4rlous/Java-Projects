# 🌐 Mini Web Browser

A simple web browser built with **JavaFX**. Browse the internet with basic navigation features in a lightweight application.

## Features

- Navigate to any website by entering a URL
- Back and forward navigation buttons
- Reload current page
- Automatic HTTP/HTTPS protocol handling
- URL field updates automatically when clicking links
- Opens with Google as the home page

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
--module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml,javafx.web
```

Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder

6. Run the `MainApp` class

### Option 2: Using Command Line

1. Compile the project:
```bash
javac --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml,javafx.web -d out src/main/java/io/github/k4rlous/miniwebbrowser/MainApp.java
```

2. Run the application:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml,javafx.web -cp out io.github.k4rlous.miniwebbrowser.MainApp
```

### Option 3: Building a JAR file

1. Create a JAR using your IDE or Maven/Gradle

2. Run with:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml,javafx.web -jar MiniWebBrowser.jar
```

> **Note:** Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder.
> Example: `C:\javafx-sdk-21\lib` (Windows) or `/usr/lib/javafx-sdk-21/lib` (Linux)

## How to Use

1. Type a URL in the text field (no need to include `http://` or `https://`)
2. Press **Enter** to navigate to the website
3. Use **←** button to go back to previous page
4. Use **→** button to go forward to next page
5. Use **⟳** button to reload the current page

## Icon Credit

Global icons created by [Freepik - Flaticon](https://www.flaticon.com/free-icons/global)
