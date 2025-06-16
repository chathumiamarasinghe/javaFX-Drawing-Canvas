package com.drawingcanvas.service;

import com.drawingcanvas.model.User;

public interface AuthService {

    //Interface for login & registration
    boolean register(User user);
    User login(String username, String password);
}
