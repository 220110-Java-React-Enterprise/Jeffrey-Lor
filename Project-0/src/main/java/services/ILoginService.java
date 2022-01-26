package services;

import models.User;

public interface ILoginService {
    
    // Returns a User object if the email and password combination exists, otherwise null
    public User login(String email, String password);
}
