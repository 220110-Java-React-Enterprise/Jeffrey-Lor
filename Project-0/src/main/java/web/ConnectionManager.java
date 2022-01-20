package web;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static ConnectionManager cm;
    private static Connection connection;

    private ConnectionManager() {

    }

    public static ConnectionManager getConnectionManager() {
        if (cm == null) {
            cm = new ConnectionManager();
        }
        return cm;
    }

    public static Connection getConnection() {
        if (connection == null) {
            connect();
        }
        return connection;
    }

    private static void connect() {
        try {
            Properties p = new Properties();
            FileReader fr = new FileReader("./Project-0/src/main/resources/connection.properties");
            p.load(fr);

            String connectionString = "jdbc:mariadb://" +
            p.getProperty("hostname") + ":" +
            p.getProperty("port") + "/" +
            p.getProperty("dbname") + "?user=" +
            p.getProperty("username") + "&password=" +
            p.getProperty("password");

            connection = DriverManager.getConnection(connectionString);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void finalize() {
        try {
            connection.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
