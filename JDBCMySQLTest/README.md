# 🐬 JDBC MySQL Test

A simple product management system built with **Java** and **JDBC** connecting to a **MySQL** database. Demonstrates basic CRUD operations with MySQL integration.

## Features

- Complete CRUD operations (Create, Read, Update, Delete)
- MySQL database connection
- Product management with name, quantity, price, and status
- DAO (Data Access Object) pattern implementation
- PreparedStatement for SQL injection prevention
- Error handling and connection management
- Command-line interface for testing

## Requirements

- Java 11 or higher
- MySQL Server 5.7 or higher
- MySQL Connector/J (JDBC Driver)

## Project Structure
```
jdbcmysqltest/
├── lib/
│   └── mysql-connector-j-9.5.0.jar
└── src/
    └── io.github.k4rlous.jdbcmysqltest/
        ├── ConnectionDB.java    # Database connection management
        ├── Product.java        # Product model/entity
        ├── ProductDAO.java     # Data Access Object for products
        └── Main.java          # Main application for testing
```

## Setup

### 1. Install MySQL Server

Make sure you have MySQL Server installed and running on your machine.

### 2. Create the Database and Table

Connect to MySQL and run the following commands:
```sql
CREATE DATABASE test;

USE test;

CREATE TABLE produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(255) NOT NULL,
    quantidade INT,
    preco DECIMAL(10, 2),
    status VARCHAR(50)
);
```

### 3. Configure Database Connection

Edit the `ConnectionDB.java` file with your MySQL credentials:
```java
private static final String URL = "jdbc:mysql://localhost:3306/test";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

> **⚠️ Security Warning**: Never commit database credentials to public repositories. Consider using environment variables or a configuration file for production applications.

### 4. Add MySQL Connector

Download MySQL Connector/J from [MySQL official website](https://dev.mysql.com/downloads/connector/j/) and add it to your project's `lib` folder.

## How to Run

### Option 1: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Go to **File → Project Structure → Libraries**
3. Add the MySQL Connector JAR from the `lib` folder
4. Make sure your MySQL server is running
5. Run the `Main.java` class

### Option 2: Using Command Line

1. Make sure MySQL server is running

2. Compile the project:
```bash
javac -cp "lib/mysql-connector-j-9.5.0.jar" -d out src/io/github/k4rlous/jdbcmysqltest/*.java
```

3. Run the application:
```bash
java -cp "out:lib/mysql-connector-j-9.5.0.jar" io.github.k4rlous.jdbcmysqltest.Main
```

> **Note:** On Windows, use semicolon (`;`) instead of colon (`:`) in the classpath:
> ```bash
> java -cp "out;lib/mysql-connector-j-9.5.0.jar" io.github.k4rlous.jdbcmysqltest.Main
> ```

## How to Use

The `Main.java` file contains examples of basic operations:

### Insert a Product
```java
Product produto1 = new Product("Headphone Wireless", 70, 199.99, "Estoque Alto");
produtoDAO.inserir(produto1);
```

### List All Products
```java
mostrarProdutos(produtoDAO);
```

### Update a Product
```java
Product produto = produtoDAO.consultarPorId(1);
if (produto != null) {
    produto.setPreco(179.99);
    produtoDAO.atualizar(produto);
}
```

### Delete a Product
```java
produtoDAO.excluir(1); // Delete by ID
```

### Delete All Products
```java
produtoDAO.excluirTodos();
```

## Database Information

- **Database Type**: MySQL
- **Database Name**: `test`
- **Table Name**: `produtos`
- **Connection URL**: `jdbc:mysql://localhost:3306/test`

### Database Schema

| Column | Type | Description |
|--------|------|-------------|
| id_produto | INT | Primary key (auto-increment) |
| nome_produto | VARCHAR(255) | Product name (NOT NULL) |
| quantidade | INT | Stock quantity |
| preco | DECIMAL(10,2) | Product price |
| status | VARCHAR(50) | Stock status |

## Technical Details

### DAO Pattern
The application uses the Data Access Object (DAO) pattern:
- `ProductDAO.java` handles all CRUD operations
- Clean separation between data layer and business logic
- Reusable and maintainable code structure

### Connection Management
- Database connection uses try-with-resources for automatic closure
- Connection is established at the start of operations
- Proper exception handling for SQL errors

### SQL Features
- **PreparedStatement**: Prevents SQL injection attacks
- **Parameterized queries**: Secure and efficient
- **Auto-increment ID**: Managed by MySQL
- **Transaction safety**: Each operation is atomic

## Available DAO Methods

| Method | Description |
|--------|-------------|
| `inserir(Product)` | Insert a new product |
| `consultarPorId(int)` | Get product by ID |
| `atualizar(Product)` | Update existing product |
| `excluir(int)` | Delete product by ID |
| `excluirTodos()` | Delete all products |
| `listarTodos()` | List all products |

## Important Notes

> **⚠️ Academic Purpose**: Code comments and variable names are in Portuguese for academic learning purposes. This helps in better understanding JDBC concepts and MySQL database operations during the learning process.

> **🔒 Security**: The current configuration includes hardcoded credentials for demonstration purposes only. In production environments, always use:
> - Environment variables
> - Configuration files (not committed to version control)
> - Connection pooling
> - Proper user permissions

## Troubleshooting

### Connection refused
- Ensure MySQL server is running: `sudo systemctl status mysql` (Linux) or check Services (Windows)
- Verify the port (default: 3306)
- Check firewall settings

### Authentication failed
- Verify username and password in `ConnectionDB.java`
- Check MySQL user permissions: `GRANT ALL PRIVILEGES ON test.* TO 'your_user'@'localhost';`

### ClassNotFoundException: com.mysql.cj.jdbc.Driver
- Ensure MySQL Connector JAR is added to project libraries
- Verify the JAR is in the classpath when running

### Table doesn't exist
- Make sure you created the database and table (see Setup section)
- Verify you're connected to the correct database

## Differences from SQLite Version

| Feature | SQLite Version | MySQL Version |
|---------|---------------|---------------|
| Database | File-based | Server-based |
| Connection | No credentials | Username/password required |
| Setup | Auto-creates DB file | Requires server installation |
| Deployment | Portable | Client-server architecture |
| Concurrency | Limited | High concurrency support |

