package com.k4rlous.webscraper.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

    public List<URL> extractPdfLinks(URL baseUrl) throws IOException {
        System.out.println("Connecting to URL: " + baseUrl);

        List<URL> pdfLinks = new ArrayList<>();

        try (InputStream inputStream = baseUrl.openStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            Document document = Jsoup.parse(content.toString(), baseUrl.toString());
            Elements pdfLinkElements = document.select("a[href$=.pdf]");
            System.out.println("Found " + pdfLinkElements.size() + " PDF links");

            for (Element linkElement : pdfLinkElements) {
                String rawHref = linkElement.attr("href");

                try {
                    URI baseUri = baseUrl.toURI();
                    URI resolvedUri = baseUri.resolve(rawHref);
                    URL pdfUrl = resolvedUri.toURL();

                    pdfLinks.add(pdfUrl);
                    System.out.println("Found PDF: " + pdfUrl);

                } catch (URISyntaxException e) {
                    System.out.println("Invalid URI: " + rawHref + " - " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error converting to URL: " + rawHref + " - " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error connecting to URL: " + e.getMessage());
            throw e;
        }

        return pdfLinks;
    }
}
