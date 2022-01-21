package dao;

import collections.CustomListInterface;
import models.Card;

public interface ICardRepo {
    void addCard(Card card, int user_id);
    void removeCard(int id, int user_id);
    Card getCard(int id, int user_id);
    CustomListInterface<Card> getAllCards(int user_id);

}
