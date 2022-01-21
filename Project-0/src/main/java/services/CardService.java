package services;

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
        if(c.getType().contains("Monster")) {
            System.out.printf("%-40.40s%n", c.getName());
            System.out.printf("%-20.20s %20.20s%n", "Attribute: " + c.getAttribute(), "Level: " + c.getLevel());
            System.out.printf("%-40.40s%n", "Monster Race: " + c.getRace());
            System.out.printf("%-40.40s%n", c.getType());
            System.out.printf("%-20.20s %20.20s%n", "ATK " + c.getAtk(), "DEF " + c.getDef());
            System.out.printf("%s%n", c.getDesc());
        } else {
            System.out.printf("%-40.40s%n", c.getName());
            System.out.printf("%-40.40s%n", c.getRace() + " " + c.getType());
            System.out.printf("%s%n", c.getDesc());
        }
        
    }

    public void exportCollection() {
        try {
            FileWriter fw = new FileWriter("./Project-0/io/collection.txt");
            for (Card c : repo.getAllCards(DataStore.getUser().getID())) {
                if (c != null) {
                    fw.write("[" + c.getNum() + "] " + c.getName() + "\n");
                }
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportYDK(String name) {
        try {
            FileWriter fw = new FileWriter("./Project-0/io/" + name + ".ydk");
            for (Card c : repo.getAllCards(DataStore.getUser().getID())) {
                if (c != null) {
                    for(int i = 0; i < c.getNum(); i++) {
                        fw.write(c.getId() + "\n");
                    }
                }
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
