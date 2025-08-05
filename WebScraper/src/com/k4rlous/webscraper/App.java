package com.k4rlous.webscraper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        System.out.println("Web Scraper Application Started");

        Properties properties = new Properties();

        try (InputStream input = App.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Error: Unable to find config.properties in resources folder");
                return;
            }

            properties.load(input);
            String url = properties.getProperty("base.url");

            if (url == null || url.isEmpty()) {
                System.out.println("Error: 'base.url' not specified in config.properties");
                return;
            }

            System.out.println("URL from properties: " + url);

            Scraper scraper = new Scraper();          // <<< Importante: o Scraper deve estar no mesmo pacote ou importado
            scraper.setUrl(url);
            scraper.runScraping();

            System.out.println("Scraper initialized successfully.");

        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error running scraper: " + e.getMessage());
        }
    }
}
