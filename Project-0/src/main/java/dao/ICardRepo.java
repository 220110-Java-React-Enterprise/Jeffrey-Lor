package dao;

import collections.CustomListInterface;
import models.Card;

public interface ICardRepo {
    void addCard(Card card);
    void removeCard(int id);
    Card getCard(int id);
    CustomListInterface<Card> getAllCards();

}
