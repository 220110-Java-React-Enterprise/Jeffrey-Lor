package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;
import web.ConnectionManager;

public class LoginService implements ILoginService {
    public User login(String username, String password) {
        try {
            PreparedStatement login = ConnectionManager.getConnection()
                    .prepareStatement("SELECT * FROM users WHERE UPPER(username)=UPPER(?) and password=?");
            login.setString(1, username);
            login.setString(2, password);
            ResultSet rs = login.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"), rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
