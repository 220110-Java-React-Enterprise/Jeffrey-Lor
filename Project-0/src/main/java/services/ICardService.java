package services;

import models.Card;

public interface ICardService {
    void viewCollection();
    void printCard(Card c);
    void naviCollection();
    Card naviCard(int index);
    void exportCollection();
    void exportYDK(String name);
    void importYDK(String name);
}
