# 🛠️ SpringbootAPI (Spring Boot + SQLite) – 2026
A RESTful product management API built with **Spring Boot**, **Hibernate**, and **SQLite**. Supports full CRUD operations and batch saving, tested with Postman.

## Features
- List all products
- Find a product by ID
- Create a single product
- Create multiple products at once (batch save)
- Update an existing product
- Delete a product
- Input validation with `@NotEmpty`
- Auto-incremented ID managed by the database
- JPA/Hibernate for ORM with SQLite persistence

## Technologies
- Java
- Spring Boot
- Hibernate (JPA)
- SQLite
- JDBC
- Maven
- Postman (for testing)

## Product Model
Each product contains the following fields:

| Field       | Type     | Description              |
|-------------|----------|--------------------------|
| `id`        | `long`   | Auto-generated (primary key) |
| `nome`      | `String` | Product name (required)  |
| `quantidade`| `int`    | Stock quantity           |
| `preco`     | `double` | Product price            |
| `status`    | `String` | Product status           |

## Endpoints
Base URL: `http://localhost:8080/produtos`

| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| GET    | `/produtos`           | List all products            |
| GET    | `/produtos/{id}`      | Find product by ID           |
| POST   | `/produtos`           | Create a new product         |
| POST   | `/produtos/salvarLista` | Create multiple products   |
| PUT    | `/produtos/{id}`      | Update an existing product   |
| DELETE | `/produtos/{id}`      | Delete a product             |

## Example Request (POST /produtos)
```json
{
  "nome": "Notebook",
  "quantidade": 10,
  "preco": 3500.00,
  "status": "available"
}
```

## Requirements
- Java 21 or higher
- Maven 3.8 or higher

## How to Run

### Option 1: Using IntelliJ IDEA
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Let Maven download the dependencies automatically
4. Run the `SpringbootApiApplication` class

### Option 2: Using Command Line
1. Clone the repository:
```bash
git clone https://github.com/K4rlous/Java-Projects.git
```
2. Navigate to the project folder:
```bash
cd Java-Projects/SpringbootAPI
```
3. Build and run with Maven:
```bash
./mvnw spring-boot:run
```

### Option 3: Building a JAR
1. Package the project:
```bash
./mvnw clean package
```
2. Run the JAR:
```bash
java -jar target/SpringbootAPI-0.0.1-SNAPSHOT.jar
```

## How to Test
Use [Postman](https://www.postman.com/) or any HTTP client to send requests to the endpoints listed above.

## Web Client
The `client/` folder contains a simple HTML/JavaScript frontend that consumes the API and displays all products in a styled table.

**Features:**
- Fetches all products from `GET /produtos` on page load
- Displays data in a formatted table (ID, Nome, Quantidade, Preço, Status)
- Shows total product count
- Displays an error message if the API is unreachable

**How to use:**
1. Make sure the API is running on `http://localhost:8080`
2. Open `client/client-web-listagem.html` directly in your browser
