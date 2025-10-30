import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.Image;

public class BmiCalculator extends Application {

    @Override
    public void start(Stage stage) {
        Image icon = new Image(getClass().getResourceAsStream("icon.png"));

        // Labels for input fields
        Label weightLabel = new Label("Weight");
        Label heightLabel = new Label("Height");

        // Text fields for user input
        TextField weightField = new TextField();
        weightField.setPromptText("Weight in kg");
        TextField heightField = new TextField();
        heightField.setPromptText("Height in meters");

        // Labels for displaying results
        Label resultLabel = new Label();
        Label classificationLabel = new Label();

        // Source info label
        Label sourceLabel = new Label("Classifications according to WHO (World Health Organization)");
        Hyperlink whoLink = new Hyperlink("https://www.who.int/news-room/fact-sheets/detail/obesity-and-overweight#BMI");
        whoLink.setOnAction(e -> getHostServices().showDocument(whoLink.getText()));

        // Button to calculate BMI
        Button calculateButton = new Button("Calculate BMI");
        calculateButton.setOnAction(e -> {
            try {
                double weight = Double.parseDouble(weightField.getText().replace(",", "."));
                double height = Double.parseDouble(heightField.getText().replace(",", "."));
                double bmi = weight / (height * height);
                resultLabel.setText(String.format("Your BMI is: %.2f", bmi));

                // BMI classification
                if (bmi < 17) {
                    classificationLabel.setText("Classification: Severely underweight");
                } else if (bmi >= 17 && bmi < 18.5) {
                    classificationLabel.setText("Classification: Underweight");
                } else if (bmi >= 18.5 && bmi < 25) {
                    classificationLabel.setText("Classification: Normal weight");
                } else if (bmi >= 25 && bmi < 30) {
                    classificationLabel.setText("Classification: Overweight");
                } else if (bmi >= 30 && bmi < 35) {
                    classificationLabel.setText("Classification: Obesity I");
                } else if (bmi >= 35 && bmi < 40) {
                    classificationLabel.setText("Classification: Obesity II (Severe)");
                } else {
                    classificationLabel.setText("Classification: Obesity III (Morbid)");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers for weight and height");
                classificationLabel.setText(""); // clear previous classification
            }
        });

        // Vertical layout
        VBox layout = new VBox(10, weightLabel, weightField, heightLabel, heightField, calculateButton,
                resultLabel, classificationLabel, sourceLabel, whoLink);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        // Scene and stage
        Scene scene = new Scene(layout, 400, 400);
        stage.getIcons().add(icon);
        stage.setTitle("BMI Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
