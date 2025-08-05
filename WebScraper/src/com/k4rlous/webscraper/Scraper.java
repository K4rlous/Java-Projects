package com.k4rlous.webscraper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import com.k4rlous.webscraper.utils.HtmlParser;

public class Scraper {
    private URL url;

    public Scraper() {
        System.out.println("Scraper initialized");
    }

    public void setUrl(String urlStr) {
        System.out.println("URL received in Scraper: " + urlStr);
        try {
            URI uri = new URI(urlStr);
            this.url = uri.toURL();
            System.out.println("Converted URL: " + url);
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void runScraping() {
        if (url == null || url.toString().isEmpty()) {
            System.out.println("Error: URL is not set");
            return;
        }
        System.out.println("Starting scraping for URL: " + url);
        HtmlParser htmlParser = new HtmlParser();
        try {
            List<URL> pdfLinks = htmlParser.extractPdfLinks(url);
            System.out.println("Found " + pdfLinks.size() + " PDF links.");
            for (URL pdfLink : pdfLinks) {
                System.out.println("PDF Link: " + pdfLink);
            }
        } catch (IOException e) {
            System.out.println("Error during scraping: " + e.getMessage());
        }
    }
}
