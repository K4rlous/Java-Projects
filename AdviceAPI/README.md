# 💡 Advice API

A simple advice generator built with **Java**. Get random pieces of advice from the **Advice Slip API** directly in your terminal.

## Features

- Fetch random advice from Advice Slip API
- Display advice with unique ID
- Interactive loop to get multiple advice
- Network error handling
- HTTP status code validation
- Clean and simple command-line interface

## Requirements

- Java 11 or higher
- Internet connection

> No API key required! The Advice Slip API is completely free and open.

## How to Run

### Option 1: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/main/java/io/github/k4rlous/adviceapi/MainApp.java`
3. Right-click on the file and select **Run 'MainApp.main()'**

### Option 2: Using Command Line

1. Navigate to the project directory

2. Compile the project:
```bash
javac -cp "lib/*" -d out src/main/java/io/github/k4rlous/adviceapi/MainApp.java
```

3. Run the application:
```bash
java -cp "out:lib/*" io.github.k4rlous.adviceapi.MainApp
```

> **Note:** On Windows, use semicolon (`;`) instead of colon (`:`) in the classpath:
> ```bash
> java -cp "out;lib/*" io.github.k4rlous.adviceapi.MainApp
> ```

### Option 3: Building a JAR file

1. Create a JAR using your IDE or build tool

2. Run with:
```bash
java -jar AdviceAPI.jar
```

## How to Use

1. Run the application
2. Read the advice displayed with its unique ID
3. When prompted "Do you want one more advice? (Y/N)":
   - Press **Y** to get another advice
   - Press **N** to exit the program
4. Repeat as many times as you want!

## Example Output
```
The ID of your advice is: 117
Advice: Keep a positive attitude and good things will happen.
-----------------------------
Do you want one more advice? (Y/N)
```

## Dependencies

This project uses the following external library:
- **JSON-java (org.json)**: For parsing JSON responses from the Advice Slip API

## API Information

This application uses the free [Advice Slip API](https://api.adviceslip.com/):
- Random advice generation
- No authentication required
- Completely free to use
- No rate limits

## Error Handling

- **Network errors**: The system will notify you if the API cannot be reached
- **Interrupted requests**: Handles request interruptions gracefully
- **Invalid HTTP status codes**: Displays unexpected response codes (404, 500, etc.)
- **Invalid input validation**: Only accepts Y/N responses
