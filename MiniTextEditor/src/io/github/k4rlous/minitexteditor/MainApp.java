package io.github.k4rlous.minitexteditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Image icon = new Image(getClass().getResourceAsStream("/icons/icon.png"));

        // Editable text area
        TextArea textArea = new TextArea();

        // Buttons
        Button openButton = new Button("Open");
        Button saveButton = new Button("Save");

        // Toolbar
        ToolBar toolBar = new ToolBar(openButton, saveButton);

        // Layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(toolBar);
        borderPane.setCenter(textArea);

        // Scene and stage setup
        Scene scene = new Scene(borderPane, 800, 600);
        stage.setTitle("MiniTextEditor");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();

        // Button actions
        openButton.setOnAction(e -> openFile(stage, textArea));
        saveButton.setOnAction(e -> saveFile(stage, textArea));
    }
    // Open .txt file and load content
    private void openFile(Stage stage, TextArea textArea) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt")
        );

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                String content = Files.readString(file.toPath());
                textArea.setText(content);
            } catch (IOException e) {
                System.out.println("Error opening file: " + e.getMessage());
            }
        }
    }
    // Save .txt file (always with .txt extension)
    private void saveFile(Stage stage, TextArea textArea) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Text File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt")
        );

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getAbsolutePath() + ".txt");
            }

            try (PrintWriter writer = new PrintWriter(file)) {
                writer.print(textArea.getText());
            } catch (Exception e) {
                System.out.println("Error saving file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
