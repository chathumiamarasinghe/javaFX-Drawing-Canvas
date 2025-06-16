package com.drawingcanvas.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/drawing_app";
    private static final String USER = "root";
    private static final String PASSWORD = "2001chathu";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //test db connection
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            System.out.println("Database connection successful!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}