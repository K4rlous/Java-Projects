# 🌤️ Weather System

A simple weather information system built with **Java**. Get real-time weather data for any city in the world using the **WeatherAPI**.

## Features

- Real-time weather data retrieval
- Search by city and country name
- Displays current temperature and "feels like" temperature
- Shows humidity, wind speed, and atmospheric pressure
- Weather condition description
- Automatic location validation
- Multi-language city name support (UTF-8 encoding)
- JSON data parsing

## Requirements

- Java 11 or higher
- Internet connection
- WeatherAPI key (free tier available)

> You need to get a free API key from [WeatherAPI.com](https://www.weatherapi.com/)

## Setup

1. Register at [WeatherAPI.com](https://www.weatherapi.com/) and get your free API key

2. Create a file named `api-key.txt` in the `src/main/resources/` directory

3. Paste your API key into the `api-key.txt` file (no quotes, just the key)

## How to Run

### Option 1: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Make sure you have created the `api-key.txt` file in `src/main/resources/`
3. Navigate to `src/main/java/io/github/k4rlous/weathersystem/MainApp.java`
4. Right-click on the file and select **Run 'MainApp.main()'**

### Option 2: Using Command Line

1. Navigate to the project directory

2. Compile the project:
```bash
javac -cp "lib/*" -d out src/main/java/io/github/k4rlous/weathersystem/MainApp.java
```

3. Run the application:
```bash
java -cp "out:lib/*" io.github.k4rlous.weathersystem.MainApp
```

> **Note:** On Windows, use semicolon (`;`) instead of colon (`:`) in the classpath:
> ```bash
> java -cp "out;lib/*" io.github.k4rlous.weathersystem.MainApp
> ```

### Option 3: Building a JAR file

1. Create a JAR using your IDE or build tool

2. Make sure to include the `api-key.txt` in the resources folder

3. Run with:
```bash
java -jar WeatherSystem.jar
```

## How to Use

1. Run the application
2. Enter the city name and country (e.g., "London, UK" or "São Paulo, Brazil")
3. Press Enter
4. View the current weather information:
   - Current temperature (°C)
   - Feels like temperature (°C)
   - Weather condition
   - Humidity (%)
   - Wind speed (km/h)
   - Atmospheric pressure (mb)
   - Date and time of the data

## Dependencies

This project uses the following external library:
- **JSON-java (org.json)**: For parsing JSON responses from the WeatherAPI

## API Information

This application uses the free tier of [WeatherAPI.com](https://www.weatherapi.com/):
- Real-time weather data
- Current conditions
- Location lookup
- Free tier: 1,000,000 calls/month

## Error Handling

- Invalid location: The system will notify you if the location is not found
- Network errors: Exception messages will be displayed
- Invalid API key: Check your `api-key.txt` file
