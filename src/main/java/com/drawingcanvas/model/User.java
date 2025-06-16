package com.drawingcanvas.model;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;

    // Constructor without ID for registration
    public User(String username, String email, String password) {
        this(-1, username, email, password);
    }

    // Constructor with ID for login
    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
