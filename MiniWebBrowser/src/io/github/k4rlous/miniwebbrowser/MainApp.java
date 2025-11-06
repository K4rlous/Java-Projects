package io.github.k4rlous.miniwebbrowser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Image icon = new Image(getClass().getResourceAsStream("/icons/icon.png"));

        TextField urlField = new TextField();
        urlField.setPromptText("Type the URL and press 'Enter' - no need to include HTTP or HTTPS!");

        // Toolbar buttons
        Button backButton = new Button("←");
        Button forwardButton = new Button("→");
        Button reloadButton = new Button("⟳");
        ToolBar toolbar = new ToolBar(backButton, forwardButton, reloadButton);

        WebView browser = new WebView();
        WebEngine engine = browser.getEngine(); // Using a WebView to create a WebEngine

        // Button handlers
        backButton.setOnAction(e -> {
            if (engine.getHistory().getCurrentIndex() > 0)
                engine.getHistory().go(-1);
        });

        forwardButton.setOnAction(e -> {
            if (engine.getHistory().getCurrentIndex() < engine.getHistory().getEntries().size() - 1)
                engine.getHistory().go(1);
        });

        reloadButton.setOnAction(e -> engine.reload());

        // Load page when pressing Enter
        urlField.setOnAction(event -> engine.load(formatUrl(urlField.getText())));

        // Update URL field when navigating through links
        engine.locationProperty().addListener((obs, oldLoc, newLoc) -> urlField.setText(newLoc));

        // Main layout
        VBox layout = new VBox(toolbar, urlField, browser);
        VBox.setVgrow(browser, Priority.ALWAYS);

        Scene scene = new Scene(layout, 900, 600);
        stage.setTitle("Mini Web Browser");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();

        // Optional home page
        engine.load("https://www.google.com");
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String formatUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        return url;
    }
}
