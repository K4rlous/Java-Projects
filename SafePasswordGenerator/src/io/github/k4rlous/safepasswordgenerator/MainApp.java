package io.github.k4rlous.safepasswordgenerator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image(getClass().getResourceAsStream("/icons/icon.png"));

        stage.setTitle("Safe Password Generator");

        Label passwordLengthLabel = new Label("Password length:");
        TextField passwordLengthField = new TextField();
        passwordLengthField.setText("16"); // Suggested password length

        Label generatedPasswordLabel = new Label("Generated password:");
        TextField generatedPasswordField = new TextField();
        generatedPasswordField.setEditable(false); // Prevent editing of the generated password field
        generatedPasswordField.setStyle("-fx-text-fill: cyan; -fx-background-color: black;");

        Button generateButton = new Button("Generate password");
        generateButton.setOnAction(e -> {
            try {
                int passwordLength = Integer.parseInt(passwordLengthField.getText()); // Get desired length
                String password = SafePasswordGenerator.generatePassword(passwordLength);
                generatedPasswordField.setText(password);
            } catch (NumberFormatException ex) {
                generatedPasswordField.setText("Invalid input! Please enter only whole numbers.");
            }
        });

        VBox vBox = new VBox(passwordLengthLabel, passwordLengthField, generateButton, generatedPasswordLabel, generatedPasswordField);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox, 300, 200);
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
