package com.example.comparesocial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        // Create a new Scene with the loaded FXML root
        Scene scene = new Scene(root);

        // Set the stage title
        primaryStage.setTitle("Social Media Engagement");

        // Set application icon
        primaryStage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("logo.png")));

        // Set the scene for the primary stage
        primaryStage.setScene(scene);

        // Display the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
