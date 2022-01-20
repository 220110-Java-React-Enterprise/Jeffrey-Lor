package ui;

import models.User;

public class DataStore {
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User u) {
        user = u;
    }
}
