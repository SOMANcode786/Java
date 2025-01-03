import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

import java.util.Timer;
import java.util.TimerTask;

public class java extends Application {

    private int timeInSeconds = 0;
    private Label timerLabel; 
    private Timer timer;
    private boolean isPaused = false; 

    @Override
    public void start(Stage primaryStage) {
        // Create input fields
        TextField inputField = new TextField();
        inputField.setPromptText("Enter time (e.g., 2 for minutes or 120 for seconds)");

        // Create choice box for time type
        ChoiceBox<String> timeType = new ChoiceBox<>();
        timeType.getItems().addAll("Minutes", "Seconds");
        timeType.setValue("Seconds"); // Default choice

        // Create buttons
        Button startButton = new Button("Start Timer");
        Button pauseButton = new Button("Pause Timer");
        pauseButton.setDisable(true); // Disable pause initially

        // Label to display countdown
        timerLabel = new Label("00:00");
        timerLabel.setFont(new Font("Arial", 48));
        timerLabel.setStyle("-fx-text-fill: #333;");

        // Handle start button click
        startButton.setOnAction(e -> {
            String timeInput = inputField.getText();
            try {
                int time = Integer.parseInt(timeInput);
                if (timeType.getValue().equals("Minutes")) {
                    timeInSeconds = time * 60; 
                } else {
                    timeInSeconds = time; 
                }
                isPaused = false;
                pauseButton.setDisable(false); 
                startCountdown(); 
            } catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid number.");
            }
        });

        // Handle pause button click
        pauseButton.setOnAction(e -> {
            isPaused = !isPaused; 
            pauseButton.setText(isPaused ? "Resume Timer" : "Pause Timer");
        });

        
        HBox inputLayout = new HBox(10, inputField, timeType, startButton, pauseButton);
        inputLayout.setAlignment(Pos.CENTER);

        // Main layout
        VBox root = new VBox(20, timerLabel, inputLayout);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 20; -fx-background-color: #f0f0f0;");

        // Set up the stage
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Countdown Timer By Muhammad Soman");
        primaryStage.show();
    }

    // Start the countdown timer
    private void startCountdown() {
        if (timer != null) {
            timer.cancel(); 
        }
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!isPaused && timeInSeconds > 0) {
                    updateTimerLabel(); 
                    timeInSeconds--;
                } else if (timeInSeconds == 0) {
                    timer.cancel(); 
                    showAlert("Timer Finished", "Time's up!");
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);  
    }

    // Update the timer label on the UI thread
    private void updateTimerLabel() {
        javafx.application.Platform.runLater(() -> {
            int minutes = timeInSeconds / 60;
            int seconds = timeInSeconds % 60;
            timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
        });
    }

    // Show an alert dialog
    private void showAlert(String title, String message) {
        javafx.application.Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}