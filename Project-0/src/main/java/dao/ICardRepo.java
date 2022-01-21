package dao;

import collections.CustomListInterface;
import models.Card;
import models.User;

public interface ICardRepo {
    void addCard(Card card, User user);
    void removeCard(int id, User user);
    Card getCard(int id, User user);
    CustomListInterface<Card> getAllCards(User user);

}
