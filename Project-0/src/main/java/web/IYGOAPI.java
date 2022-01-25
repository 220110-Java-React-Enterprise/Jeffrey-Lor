package web;

import models.Card;

public interface IYGOAPI {
    public Card searchCard(String query);
    public Card getCard(String id);
}
