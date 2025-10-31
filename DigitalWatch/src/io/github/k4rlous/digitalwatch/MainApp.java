package io.github.k4rlous.digitalwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainApp extends Application {

    // Clock format pattern
    final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void start(Stage stage) {
        Image icon = new Image(getClass().getResourceAsStream("/icons/icon.png"));

        Label timeLabel = new Label();
        timeLabel.setStyle("-fx-font-size: 24pt; -fx-text-fill: yellow;");

        // Create KeyFrame for updating the time
        KeyFrame updateKeyFrame = new KeyFrame(Duration.ZERO, e -> {
            // Use the formatter defined above
            timeLabel.setText(LocalDateTime.now().format(FORMATTER));
        });

        // Create another KeyFrame to define update interval (1 second)
        KeyFrame intervalKeyFrame = new KeyFrame(Duration.seconds(1));

        // Create Timeline and add KeyFrames
        Timeline clock = new Timeline();
        clock.getKeyFrames().addAll(updateKeyFrame, intervalKeyFrame);

        // Set the timeline to repeat indefinitely
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play(); // Start the timeline

        // Create VBox layout
        VBox vboxLayout = new VBox(timeLabel);
        vboxLayout.setAlignment(Pos.CENTER);
        vboxLayout.setStyle("-fx-background-color: black;");

        // Create scene
        Scene scene = new Scene(vboxLayout, 210, 100);
        stage.setTitle("Digital Watch");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
