package dao;

import collections.CustomListInterface;
import models.Card;

public interface ICardRepo {

    // Adds a Card and assigns it to the given user_id
    void addCard(Card card, int user_id);

    // Removes a Card and from the given user_id
    void removeCard(int id, int user_id);

    // Updates the Card entry with the same card id for the given user_id
    void updateCard(Card card, int user_id);

    // Returns a Card object based on the given card id from the given user_id
    Card getCard(int id, int user_id);
    CustomListInterface<Card> getAllCards(int user_id);

}
