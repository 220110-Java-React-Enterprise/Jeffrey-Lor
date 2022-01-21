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
    public void addCard(Card card, int user_id) {
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
            ps.setInt(11, user_id);
            ps.execute();

        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void removeCard(int id, int user_id) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("DELETE FROM cards WHERE id=? AND owner_id=?");
            ps.setInt(1, id);
            ps.setInt(2, user_id);
            ps.execute();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void updateCard(Card card, int user_id) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement(
                            "UPDATE cards SET name=?, `type`=?, `desc`=?, atk=?, def=?, `level`=?, race=?, `attribute`=?, num=? WHERE id=? AND owner_id=?");
            ps.setString(1, card.getName());
            ps.setString(2, card.getType());
            ps.setString(3, card.getDesc());
            ps.setString(4, card.getAtk());
            ps.setString(5, card.getDef());
            ps.setInt(6, card.getLevel());
            ps.setString(7, card.getRace());
            ps.setString(8, card.getAttribute());
            ps.setInt(9, card.getNum());
            ps.setInt(10, card.getId());
            ps.setInt(11, user_id);
            ps.execute();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public Card getCard(int id, int user_id) {
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("SELECT FROM cards WHERE id=? AND owner_id=?");
            ps.setInt(1, id);
            ps.setInt(2, user_id);
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
    public CustomListInterface<Card> getAllCards(int user_id) {
        CustomListInterface<Card> list = new CustomArrayList<>();
        try {
            PreparedStatement ps = ConnectionManager.getConnection()
                    .prepareStatement("SELECT * FROM cards WHERE owner_id=?");
            ps.setInt(1, user_id);
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
