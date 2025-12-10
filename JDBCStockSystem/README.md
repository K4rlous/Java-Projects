# 📦 JDBC Stock System

A product inventory management system built with **Java**, **JavaFX**, and **JDBC** using **SQLite** database. Manage your product stock with a complete CRUD interface.

## Features

- Complete CRUD operations (Create, Read, Update, Delete)
- Product management with name, quantity, price, and status
- Interactive TableView with automatic data refresh
- SQLite database with auto-increment ID
- Input validation and error handling
- Selection-based editing (click on table row to edit)
- Status dropdown (Normal Stock / Low Stock)
- Price input supports both comma and period as decimal separator
- Custom CSS styling
- Automatic database connection management
- DAO (Data Access Object) pattern implementation

## Requirements

- Java 11 or higher
- JavaFX SDK 11 or higher
- SQLite JDBC driver

> JavaFX is required to run this application.
> You can download it from [Gluon](https://gluonhq.com/products/javafx/).

## Project Structure
```
jdbcstocksystem/
├── ConnectionDB.java       # Database connection management
├── Product.java           # Product model/entity
├── ProductDAO.java        # Data Access Object for products
├── TableCreator.java      # Database table creation script
├── MainApp.java          # CLI version for testing
├── MainAppGUI.java       # JavaFX GUI application
└── resources/
    ├── icons/
    │   └── icon.png
    └── styles/
        └── styles-products.css
```

## Setup

### 1. Create the Database Table

First, run the `TableCreator.java` to create the SQLite database and products table:
```bash
java io.github.k4rlous.jdbcstocksystem.TableCreator
```

This will create a file named `meu_banco_de_dados.db` in your project directory with the following structure:
```sql
CREATE TABLE produtos (
    id_produto INTEGER PRIMARY KEY,
    nome_produto TEXT NOT NULL,
    quantidade INTEGER,
    preco REAL,
    status TEXT
);
```

### 2. Run the Application

After creating the table, you can run either version:

**GUI Version (Recommended):**
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml io.github.k4rlous.jdbcstocksystem.MainAppGUI
```

**CLI Version (for testing):**
```bash
java io.github.k4rlous.jdbcstocksystem.MainApp
```

## How to Run

### Option 1: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Go to **File → Project Structure → Libraries**
3. Add the JavaFX SDK library (point to the `lib` folder of your JavaFX installation)
4. Add the SQLite JDBC driver JAR to your project libraries
5. Go to **Run → Edit Configurations**
6. Add VM options:
```
--module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml
```

Replace `PATH_TO_JAVAFX_LIB` with the actual path to your JavaFX `lib` folder

7. Run `TableCreator` first to create the database
8. Then run `MainAppGUI` to start the application

### Option 2: Using Command Line

1. Create the database table:
```bash
javac -cp "lib/*" -d out src/main/java/io/github/k4rlous/jdbcstocksystem/TableCreator.java
java -cp "out:lib/*" io.github.k4rlous.jdbcstocksystem.TableCreator
```

2. Compile the GUI application:
```bash
javac --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -cp "lib/*" -d out src/main/java/io/github/k4rlous/jdbcstocksystem/*.java
```

3. Run the application:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -cp "out:lib/*" io.github.k4rlous.jdbcstocksystem.MainAppGUI
```

> **Note:** On Windows, use semicolon (`;`) instead of colon (`:`) in the classpath.

### Option 3: Building a JAR file

1. Create a JAR using your IDE or Maven/Gradle

2. Make sure to include:
    - SQLite JDBC driver
    - JavaFX runtime
    - Resources folder (icons and CSS)

3. Run with:
```bash
java --module-path "PATH_TO_JAVAFX_LIB" --add-modules javafx.controls,javafx.fxml -jar JDBCStockSystem.jar
```

## How to Use

### Adding Products
1. Fill in the product details:
    - **Product**: Product name
    - **Quantity**: Stock quantity
    - **Price**: Product price (use comma or period for decimals)
    - **Status**: Select "Normal Stock" or "Low Stock"
2. Click **Add** button

### Updating Products
1. Click on a product in the table to select it
2. Modify the fields as needed
3. Click **Update** button

### Deleting Products
1. Click on a product in the table to select it
2. Click **Delete** button

### Clearing Form
- Click **Clear** button to reset all input fields

## Database Information

- **Database Type**: SQLite
- **Database File**: `meu_banco_de_dados.db`
- **Table Name**: `produtos`
- **Auto-generated**: Database file is created automatically if it doesn't exist

### Database Schema

| Column | Type | Description |
|--------|------|-------------|
| id_produto | INTEGER | Primary key (auto-increment) |
| nome_produto | TEXT | Product name (NOT NULL) |
| quantidade | INTEGER | Stock quantity |
| preco | REAL | Product price |
| status | TEXT | Stock status |

## Technical Details

### DAO Pattern
The application uses the Data Access Object (DAO) pattern to separate database operations from business logic:
- `ProductDAO.java` handles all CRUD operations
- Clean separation between data layer and presentation layer

### Connection Management
- Database connection is opened when the application starts
- Connection is automatically closed when the application exits (using JavaFX `stop()` method)
- Generic connection method available for other databases (MySQL, PostgreSQL, etc.)

### Features Implementation
- **PreparedStatement**: Used for all SQL operations to prevent SQL injection
- **ObservableList**: Enables automatic UI updates when data changes
- **TableView Listener**: Automatically populates form fields when selecting a row
- **CSS Styling**: Custom styles for better user experience

## Important Notes

> **⚠️ Academic Purpose**: Code comments and variable names are in Portuguese for academic learning purposes. This helps in better understanding JDBC concepts and database operations during the learning process.

## Icon Credit

Database icons created by [Freepik - Flaticon](https://www.flaticon.com/free-icons/database)

## Troubleshooting

### Database file not found
- Make sure to run `TableCreator.java` first
- Check that `meu_banco_de_dados.db` exists in your project directory

### JavaFX components not loading
- Verify JavaFX SDK is properly added to project libraries
- Check VM options include correct module path

### SQLite JDBC driver error
- Ensure SQLite JDBC driver JAR is added to project dependencies
- Check classpath includes the driver