package com.drawingcanvas.service.intf;

import com.drawingcanvas.model.User;

public interface AuthService {

    //Interface for login & registration
    boolean register(User user);
    User login(String username, String password);
}
