package web;

import models.Card;

public class YGOLocal implements IYGOAPI {

    @Override
    public Card searchCard(String query) {
        Card c = null;
        int[] i = new int[2];
        String[] s = new String[7];

        switch (query.toUpperCase()) {
            case "TOUR GUIDE FROM THE UNDERWORLD":
                i[0] = 10802915;
                i[1] = 3;
                s[0] = "Tour Guide From the Underworld";
                s[1] = "Effect Monster";
                s[2] = "When this card is Normal Summoned: You can Special Summon 1 Level 3 Fiend monster from your hand or Deck, but negate its effects, also it cannot be used as Synchro Material.";
                s[3] = "1000";
                s[4] = "600";
                s[5] = "Fiend";
                s[6] = "Dark";
                c = new Card(i[0], s[0], s[1], s[2], s[3], s[4], i[2], s[5], s[6]);
                break;
            case "SANGAN":
                i[0] = 26202165;
                i[1] = 3;
                s[0] = "Sangan";
                s[1] = "Effect Monster";
                s[2] = "If this card is sent from the field to the GY: Add 1 monster with 1500 or less ATK from your Deck to your hand, but you cannot activate cards, or the effects of cards, with that name for the rest of this turn. You can only use this effect of \"Sangan\" once per turn.";
                s[3] = "1000";
                s[4] = "600";
                s[5] = "Fiend";
                s[6] = "Dark";
                c = new Card(i[0], s[0], s[1], s[2], s[3], s[4], i[2], s[5], s[6]);
                break;
            case "RAIGEKI":
                i[0] = 12580477;
                i[1] = 0;
                s[0] = "Raigeki";
                s[1] = "Spell Card";
                s[2] = "Destroy all monsters your opponent controls.";
                s[3] = "N/A";
                s[4] = "N/A";
                s[5] = "N/A";
                s[6] = "N/A";
                c = new Card(i[0], s[0], s[1], s[2], s[3], s[4], i[2], s[5], s[6]);
                break;
            case "TRAP HOLE":
                i[0] = 4206964;
                i[1] = 0;
                s[0] = "Trap Hole";
                s[1] = "Trap Card";
                s[2] = "When your opponent Normal or Flip Summons 1 monster with 1000 or more ATK: Target that monster; destroy that target.";
                s[3] = "N/A";
                s[4] = "N/A";
                s[5] = "N/A";
                s[6] = "N/A";
                c = new Card(i[0], s[0], s[1], s[2], s[3], s[4], i[2], s[5], s[6]);
                break;
        }
        return c;
    }

    @Override
    public Card getCard(String id) {
        return null;
    }

}
