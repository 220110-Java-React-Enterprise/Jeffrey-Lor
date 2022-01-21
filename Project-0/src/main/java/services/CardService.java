package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import collections.CustomListInterface;
import dao.CardRepoDB;
import dao.ICardRepo;
import models.Card;
import ui.DataStore;

public class CardService implements ICardService {

    private ICardRepo repo;

    public CardService() {
        this.repo = new CardRepoDB();
    }

    public void viewCollection() {

        CustomListInterface<Card> list = repo.getAllCards(DataStore.getUser().getID());
        System.out.println("=================== Collection ===================");
        System.out.println("Cards:" + list.size());
        for (Card c : list) {
            System.out.println("[" + c.getName() + "] x" + c.getNum());
        }
    }

    public void naviCollection() {

        CustomListInterface<Card> list = repo.getAllCards(DataStore.getUser().getID());
        System.out.println("====== Select using the numbers on the left ======");
        int i = 1;
        for (Card c : list) {
            System.out.println("[" + i++ + "] - " + c.getName());
        }
        System.out.println("==================================================");
    }

    public Card naviCard(int index) {
        CustomListInterface<Card> list = repo.getAllCards(DataStore.getUser().getID());
        return list.get(index - 1);
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
            for (Card c : repo.getAllCards(DataStore.getUser().getID())) {
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
