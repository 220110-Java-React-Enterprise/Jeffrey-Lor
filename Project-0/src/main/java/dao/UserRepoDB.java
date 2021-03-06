package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web.ConnectionManager;

public class UserRepoDB implements IUserRepo {

    @Override
    public void addUser(String email, String password) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.execute();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("DELETE FROM users WHERE user_id=?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void viewAllUsers() {
        try {
            Statement s = ConnectionManager.getConnection().createStatement();
            s.executeQuery("SELECT * FROM users");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                System.out.println("[" + rs.getInt("user_id") + "] " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public boolean checkDuplicate(String email) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("SELECT 1 FROM users WHERE email=?");
            ps.setString(1, email);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if(rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

}
