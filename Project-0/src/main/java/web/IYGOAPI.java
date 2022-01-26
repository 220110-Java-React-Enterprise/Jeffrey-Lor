package web;

import models.Card;

public interface IYGOAPI {

    // Returns a Card object based on the given query string
    public Card searchCard(String query);

    // Returns a Card object based on the given card id
    public Card getCard(String id);
}
