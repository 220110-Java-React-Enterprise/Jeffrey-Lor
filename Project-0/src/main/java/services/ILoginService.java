package services;

import models.User;

public interface ILoginService {
    public User login(String username, String password);
}
