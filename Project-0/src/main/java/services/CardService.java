package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import collections.CustomListInterface;
import dao.CardRepoDB;
import dao.ICardRepo;
import models.Card;
import ui.DataStore;
import web.IYGOAPI;
import web.YGOAPI;

public class CardService implements ICardService {

    private final String DIR = "./Project-0/io/";
    private ICardRepo repo;
    private IYGOAPI ygo;

    public CardService() {
        this.repo = new CardRepoDB();
        this.ygo = new YGOAPI();
    }

    public void viewCollection() {

        CustomListInterface<Card> list = repo.getAllCards(DataStore.getUser().getID());
        int card_count = 0;
        for (Card c : list) {
            card_count += c.getNum();
        }

        System.out.println("=================== Collection ===================");
        System.out.println("Cards:" + card_count);
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
        if (c.getType().contains("Monster")) {
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
            FileWriter fw = new FileWriter(DIR + "collection.txt");
            for (Card c : repo.getAllCards(DataStore.getUser().getID())) {
                if (c != null) {
                    fw.write("[" + c.getNum() + "] " + c.getName() + "\n");
                }
            }
            fw.flush();
            fw.close();

            System.out.println("Exported collection to " + DIR + "collection.txt");
        } catch (IOException e) {
            System.out.println("Error while exporting file.");
        }
    }

    public void exportYDK(String name) {
        try {
            FileWriter fw = new FileWriter(DIR + name + ".ydk");
            for (Card c : repo.getAllCards(DataStore.getUser().getID())) {
                if (c != null) {
                    for (int i = 0; i < c.getNum(); i++) {
                        fw.write(c.getId() + "\n");
                    }
                }
            }
            fw.flush();
            fw.close();

            System.out.println("Exported collection as a YDK to " + DIR + name + ".ydk");
        } catch (IOException e) {
            System.out.println("Error while exporting file.");
        }
    }

    @Override
    public void importYDK(String name) {
        try {
            int count = 0;
            File file = new File(DIR + name + ".ydk");
            Scanner scan = new Scanner(file);
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if(isNumeric(line)) {
                    Card c = ygo.getCard(line);
                    c.setNum(1);
                    repo.addCard(c, DataStore.getUser().getID());
                    count++;
                }
                
            }
            scan.close();

            System.out.println("Imported " + count + " cards from collection.");
        } catch (IOException e) {
            System.out.println("Error. Either the file does not exist, or there is a problem with the file.");
        }
    }

    //
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
