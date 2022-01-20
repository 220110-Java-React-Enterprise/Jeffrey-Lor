package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import collections.CustomArrayList;
import collections.CustomListInterface;
import models.Card;

public class CardService implements ICardService {

    private CustomListInterface<Card> localCollection = new CustomArrayList<Card>();

    public void viewCollection() {
        for (Card c : localCollection) {
            System.out.println("[" + c.getName() + "] x" + c.getNum());
        }
    }

    public void printCard(Card c) {
        System.out.printf("%-40.40s%n", c.getName());
        System.out.printf("%-20.20s %20.20s%n", "Attribute: " + c.getAttribute(), "Level: " + c.getLevel());
        System.out.printf("%-40.40s%n", "Monster Race: " + c.getRace());
        System.out.printf("%-40.40s%n", c.getType());
        System.out.printf("%-20.20s %20.20s%n", "ATK " + c.getAtk(), "DEF " + c.getDef());
        System.out.printf("%s%n", c.getDesc());
    }

    public void exportCollection(String filename) {
        File file = new File("src/resources/" + filename + ".txt");
        try {
            FileWriter fw = new FileWriter(file, false);
            for (Card c : localCollection) {
                if (c != null) {
                    fw.write("\n" + c + "\n");
                }
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
