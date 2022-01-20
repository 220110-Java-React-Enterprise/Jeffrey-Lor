package ui;


public class DataStore {
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setName(String name) {
        username = name;
    }
}
