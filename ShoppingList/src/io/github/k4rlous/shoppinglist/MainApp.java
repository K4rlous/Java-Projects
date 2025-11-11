package io.github.k4rlous.shoppinglist;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp extends Application {
    Image icon = new Image(getClass().getResourceAsStream("/icons/icon.png"));

    private ArrayList<String> shoppingList = new ArrayList<>();
    private ListView<String> visibleList = new ListView<>(); // To display the items in the shopping list

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Shopping List");

        TextField textFieldItemDescription = new TextField();
        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove Selected"); // New button to remove items from the list
        Button exportButton = new Button("Export List");

        Label labelAdd = new Label("Type the item you want to add:");
        Label labelShoppingList = new Label("Shopping List:");

        // Creation of the ObservableList object from the shoppingList
        ObservableList<String> observableShoppingList = FXCollections.observableArrayList(shoppingList);
        visibleList.setItems(observableShoppingList); // Displays the items in the shopping list

        // Try to load saved items from a file (if it exists)
        try {
            File file = new File("shoppingList.txt");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String item = scanner.nextLine().trim();
                    if (!item.isEmpty()) {
                        shoppingList.add(item);
                        observableShoppingList.add(item); // Updates the visible list as well
                    }
                }
                scanner.close();
            }
        } catch (Exception ex) {
            System.out.println("Error loading list: " + ex.getMessage());
        }

        VBox vBox = new VBox();
        vBox.getChildren().addAll(labelAdd, textFieldItemDescription, addButton);
        vBox.getChildren().addAll(removeButton, labelShoppingList, visibleList, exportButton);
        vBox.setSpacing(10); // Vertical spacing between components
        vBox.setPadding(new Insets(10)); // Padding for the VBox

        // Action for "Add" button
        addButton.setOnAction(e -> {
            String item = textFieldItemDescription.getText();
            if(!item.isEmpty()){
                shoppingList.add(item);
                visibleList.getItems().add(item); // Adds the text to the visible list
                textFieldItemDescription.clear(); // Clears the text field
            } else {
                // If the text field is empty, show an alert
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Empty field");
                alert.setContentText("Please type an item before adding.");
                alert.showAndWait();
            }
        });

        // Action for "Remove Selected" button
        removeButton.setOnAction(e -> {
            String selected = visibleList.getSelectionModel().getSelectedItem(); // Gets the selected item from the list
            if (selected != null) {
                shoppingList.remove(selected); // Removes the item from the data list
                visibleList.getItems().remove(selected); // Removes the item from the visible list
            } else {
                // If no item is selected
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("No item selected");
                alert.setContentText("Select an item to remove.");
                alert.showAndWait();
            }
        });

        // Action for "Export List" button
        exportButton.setOnAction(e -> {
            try {
                File file = new File("shoppingList.txt");

                // If the file already exists, ask the user for confirmation
                if (file.exists()) {
                    Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                    confirmation.setTitle("Confirm Export");
                    confirmation.setHeaderText("File already exists");
                    confirmation.setContentText("Do you want to overwrite the existing file?");
                    if (confirmation.showAndWait().orElse(ButtonType.CANCEL) != ButtonType.OK) {
                        return; // If the user cancels, exit the action
                    }
                }

                PrintWriter writer = new PrintWriter(file); // Writes the items to the file
                for(String item : shoppingList){ // Iterates over the shopping list
                    writer.println(item); // Writes each item to the file
                }
                writer.close();

                // Shows success message
                Alert success = new Alert(Alert.AlertType.INFORMATION);
                success.setTitle("Success");
                success.setHeaderText(null);
                success.setContentText("Shopping list exported successfully!");
                success.showAndWait();

            } catch (Exception ex) {
                // If an error occurs during export
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText("Failed to export list");
                error.setContentText(ex.getMessage());
                error.showAndWait();
            }
        });

        Scene scene = new Scene(vBox, 350, 350);
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
