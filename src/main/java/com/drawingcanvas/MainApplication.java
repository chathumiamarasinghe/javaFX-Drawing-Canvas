package com.drawingcanvas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/drawingcanvas/fxml/new-login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 780, 460);
        scene.getStylesheets().add(getClass().getResource("/com/drawingcanvas/css/newLoginView.css").toExternalForm());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}