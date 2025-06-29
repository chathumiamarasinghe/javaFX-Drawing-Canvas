package com.drawingcanvas.controller;

import com.drawingcanvas.model.User;
import com.drawingcanvas.service.intf.AuthService;
import com.drawingcanvas.service.impl.AuthServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Button signUpButton;

    private final AuthService authService = new AuthServiceImpl();

    @FXML
    private void handleSignup() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showError("All fields are required.");
            return;
        }

        User newUser = new User(username, email, password);
        boolean success = authService.register(newUser);

        if (success) {
            System.out.println("Signup successful! You can now log in.");
            clearFields();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/drawingcanvas/fxml/new-login.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) signUpButton.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Drawing Canvas");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showError("Signup failed. Username or email may already exist.");
        }
    }

    private void showError(String message) {
       // errorLabel.setText(message);
        //errorLabel.setVisible(true);
    }

    private void clearFields() {
        usernameField.clear();
        emailField.clear();
        passwordField.clear();
    }

    @FXML
    private void goToLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/drawingcanvas/fxml/new-login.fxml"));
            Parent loginRoot = loader.load();

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(loginRoot));
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
