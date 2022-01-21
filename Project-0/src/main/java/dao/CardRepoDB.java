package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import collections.CustomArrayList;
import collections.CustomListInterface;
import models.Card;
import models.User;
import web.ConnectionManager;

public class CardRepoDB implements ICardRepo {

    @Override
    public void addCard(Card card, User user) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement(
                            "INSERT INTO cards (id, name, `type`, `desc`, atk, def, `level`, race, `attribute`, num, owner_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, card.getId());
            ps.setString(2, card.getName());
            ps.setString(3, card.getType());
            ps.setString(4, card.getDesc());
            ps.setString(5, card.getAtk());
            ps.setString(6, card.getDef());
            ps.setInt(7, card.getLevel());
            ps.setString(8, card.getRace());
            ps.setString(9, card.getAttribute());
            ps.setInt(10, card.getNum());
            ps.setInt(11, user.getID());
            ps.execute();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void removeCard(int id, User user) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("DELETE FROM cards WHERE id=? AND owner_id=?");
            ps.setInt(1, id);
            ps.setInt(2, user.getID());
            ps.execute();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public Card getCard(int id, User user) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("SELECT FROM cards WHERE id=? AND owner_id=?");
            ps.setInt(1, id);
            ps.setInt(2, user.getID());
            ps.execute();

            ResultSet rs = ps.getResultSet();
            Card c = new Card();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setType(rs.getString("type"));
            c.setDesc(rs.getString("desc"));
            c.setAtk(rs.getString("atk"));
            c.setDef(rs.getString("def"));
            c.setLevel(rs.getInt("level"));
            c.setRace(rs.getString("race"));
            c.setAttribute(rs.getString("attribute"));
            c.setNum(rs.getInt("num"));
            return c;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public CustomListInterface<Card> getAllCards(User user) {
        CustomListInterface<Card> list = new CustomArrayList<>();
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("SELECT * FROM cards WHERE owner_id=?");
            ps.setInt(1, user.getID());
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Card c = new Card();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setType(rs.getString("type"));
                c.setDesc(rs.getString("desc"));
                c.setAtk(rs.getString("atk"));
                c.setDef(rs.getString("def"));
                c.setLevel(rs.getInt("level"));
                c.setRace(rs.getString("race"));
                c.setAttribute(rs.getString("attribute"));
                c.setNum(rs.getInt("num"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
