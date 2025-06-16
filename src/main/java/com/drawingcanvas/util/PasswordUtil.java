package com.drawingcanvas.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    //convert plain password -> hashed password
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    //check plain password == hashed password during login
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
