package io.github.k4rlous.adviceapi;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keep = true;

        do {
            try {
                String advice = getAdvice();
                printAdvice(advice);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            System.out.println("-----------------------------");
            System.out.println("Do you want one more advice? (Y/N)");
            char answer = scanner.next().charAt(0);

            if (answer == 'N' || answer == 'n') {
                keep = false;
            } else if (answer != 'Y' && answer != 'y') {
                System.out.println("Invalid input");
            }

        } while (keep);

        scanner.close();
    }

    public static String getAdvice() throws Exception {
        String apiUrl = "https://api.adviceslip.com/advice";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build(); // First the request

        HttpClient client = HttpClient.newHttpClient(); // We make the client

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // The Response of the connection
            if (response.statusCode() != 200) { // 200 = Success!
                throw new IOException("Unexpected response code: " +  response.statusCode()); // We get the error code, like 404 500...
            }
            return response.body(); // Then we have our json
        } catch (IOException e) {
            throw new IOException("Network error: could not reach the API. Please check your connection");
        } catch (InterruptedException e) {
            throw new InterruptedIOException("The request has been interrupted");
        }

    }

    public static void printAdvice(String data) {
        JSONObject jsonData = new JSONObject(data); // We use the json to create an JSONObject!
        JSONObject dataGetter = jsonData.getJSONObject("slip"); // Then we access the json structure
        int slipId = dataGetter.getInt("id"); // And get the data that we want
        String advice = dataGetter.getString("advice");

        System.out.println("The ID of your advice is: " + slipId); // Final step is to print them
        System.out.println("Advice: " + advice);
    }
}
