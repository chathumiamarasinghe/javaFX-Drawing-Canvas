package com.drawingcanvas.service.impl;

import com.drawingcanvas.config.DatabaseConnector;
import com.drawingcanvas.model.User;
import com.drawingcanvas.service.AuthService;
import com.drawingcanvas.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthServiceImpl implements AuthService {

    @Override
    public boolean register(User user) {

        //query to insert a new user
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        //try connection with Prepared statements
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the values
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, PasswordUtil.hashPassword(user.getPassword()));

            // Execute query
            int rowsInserted = stmt.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {

            // Print error when have error
            System.err.println("Registration failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public User login(String username, String password) {

        //query find a user
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the username
            stmt.setString(1, username);

            //Execute the query
            ResultSet rs = stmt.executeQuery();

            //check password & return details if correct
            if (rs.next()) {
                String storedHash = rs.getString("password");

                if (PasswordUtil.checkPassword(password, storedHash)) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            storedHash
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Login failed: " + e.getMessage());
        }

        return null;
    }
}
