package com.drawingcanvas.controller;

import com.drawingcanvas.model.User;
import com.drawingcanvas.service.impl.AuthServiceImpl;
import com.drawingcanvas.service.intf.AuthService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML
    private Button signUpbutton;
    @FXML
    private Button loginButton;
    @FXML private Label errorLabel;

    private final AuthService authService = new AuthServiceImpl();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isBlank() || password.isBlank()) {
            showError("Please fill in all fields.");
            return;
        }

        User loggedUser = authService.login(username, password);
        if (loggedUser != null) {
            System.out.println("Login successful! Welcome, " + loggedUser.getUsername());
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/drawingcanvas/fxml/drawing_canvas.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Drawing Canvas");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showError("Invalid username or password.");
        }
    }

    private void showError(String message) {
       // errorLabel.setText(message);
       // errorLabel.setVisible(true);
    }

    @FXML
    private void handleSignUp() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/drawingcanvas/fxml/signup.fxml"));
            Parent signupRoot = fxmlLoader.load();

            Stage stage = (Stage) signUpbutton.getScene().getWindow();
            stage.setScene(new Scene(signupRoot));
            stage.setTitle("Sign Up");
            stage.show();

        } catch (IOException e) {
            System.err.println("Failed to load sign-up view: " + e.getMessage());
            e.printStackTrace();
        }
    }



}
