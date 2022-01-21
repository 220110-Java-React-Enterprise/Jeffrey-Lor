package services;

import models.Card;

public interface ICardService {
    void viewCollection();
    void printCard(Card c);
    void naviCollection();
    Card naviCard(int index);
}
