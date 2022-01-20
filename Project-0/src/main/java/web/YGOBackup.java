package web;

import models.Card;

public class YGOBackup implements IYGOAPI {

    @Override
    public Card searchCard(String query) {
        Card c = null;
        switch (query.toUpperCase()) {
            case "TIME WIZARD":
                break;
            case "TOUR GUIDE FROM THE UNDERWORLD":
                break;
            case "SANGAN":
                break;
            case "RAIGEKI":
                c = new Card();
                break;
            case "DARK HOLE":
                break;
            case "DARK MAGICIAN":
                break;
        }
        return c;
    }

}
