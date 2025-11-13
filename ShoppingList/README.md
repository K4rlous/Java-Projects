# 🛒 Shopping List

A simple shopping list manager built with **JavaFX**. Add, remove, and export your shopping items with automatic data persistence.

## Features

- Add items to your shopping list
- Remove selected items
- Export list to a text file
- Automatic save and load functionality
- Data persistence between sessions
- Input validation with user-friendly alerts
- Confirmation dialog before overwriting existing files
- Clean and intuitive interface

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
javac --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -d out src/main/java/io/github/k4rlous/shoppinglist/MainApp.java
```

2. Run the application:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -cp out io.github.k4rlous.shoppinglist.MainApp
```

### Option 3: Building a JAR file

1. Create a JAR using your IDE or Maven/Gradle

2. Run with:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -jar ShoppingList.jar
```

> **Note:** Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder.
> Example: `C:\javafx-sdk-21\lib` (Windows) or `/usr/lib/javafx-sdk-21/lib` (Linux)

## How to Use

1. **Add items**: Type an item name in the text field and click **Add**
2. **Remove items**: Select an item from the list and click **Remove Selected**
3. **Export list**: Click **Export List** to save your shopping list to `shoppingList.txt`
4. **Auto-save**: The list automatically loads from `shoppingList.txt` when you open the app

## Features in Detail

### Automatic Persistence
- Your shopping list is automatically loaded from `shoppingList.txt` when you start the app
- Items persist between sessions

### Export Functionality
- Export your list to `shoppingList.txt` at any time
- Confirmation dialog appears if the file already exists
- Success/error alerts keep you informed

### Input Validation
- Empty items cannot be added
- Warning alerts appear for invalid actions
- Clear error messages for better user experience

## File Location

The `shoppingList.txt` file is saved in the same directory where you run the application.

## Icon Credit

Shopping cart icons created by [Freepik - Flaticon](https://www.flaticon.com/free-icons/shopping-cart)
