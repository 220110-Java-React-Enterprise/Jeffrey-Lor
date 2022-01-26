package services;

import models.Card;

public interface ICardService {

    // Prints to console the collection of the currently logged in User
    void viewCollection();

    // Prints to console the given Card object
    void printCard(Card c);

    // Displays all cards of the current user and numbers them for menu navigation
    void naviCollection();

    // Returns a Card object at the given index corresponding to naviCollection()
    Card naviCard(int index);

    // Exports the current user's collection to txt
    void exportCollection();

    // Exports the current user's collection to ydk
    void exportYDK(String name);

    // Imports a ydk and adds all cards to the current user's collection
    void importYDK(String name);
}
