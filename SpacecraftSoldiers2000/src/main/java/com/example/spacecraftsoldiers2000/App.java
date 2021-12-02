package com.example.spacecraftsoldiers2000;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // le meto la vista
        Scene scene = new Scene(new Juego(), 500, 500);
        stage.setTitle("Spacecraft Soldier");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}