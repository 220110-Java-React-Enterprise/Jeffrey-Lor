package dao;

import collections.CustomListInterface;
import models.Card;
import models.User;

public interface ICardRepo {
    void addCard(Card card);
    void removeCard(int id);
    Card getCard(int id);
    CustomListInterface<Card> getAllCards(User u);

}
