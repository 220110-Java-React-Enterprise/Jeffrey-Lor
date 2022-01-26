package ui;

import dao.CardRepoDB;
import dao.ICardRepo;
import exceptions.InvalidInputException;
import models.Card;
import services.CardService;
import services.ICardService;
import web.IYGOAPI;
import web.YGOAPI;

public class MainMenu extends View {

    private ICardRepo db = new CardRepoDB();
    private ICardService cs;
    private IYGOAPI ygo;

    public MainMenu() {
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
        this.cs = new CardService();
        this.ygo = new YGOAPI();
    }

    @Override
    public void renderView() {
        String option = "";
        while (!option.equals("8")) {
            try {
                System.out.println(
                        "1. View your collection\n2. Add cards to your collection\n3. Remove cards from your collection\n4. View card details from your collection\n5. Export Collection to txt\n6. Export Collecion to ydk\n7. Import Collection from ydk\n8. Quit");
                option = viewManager.getScanner().nextLine();
                switch (option) {
                    case "1":
                        cs.viewCollection();
                        break;
                    case "2":
                        addCard();
                        break;
                    case "3":
                        removeCard();
                        break;
                    case "4":
                        viewCardDetails();
                        break;
                    case "5":
                        cs.exportCollection();
                        break;
                    case "6":
                        System.out.print("Enter filename: ");
                        cs.exportYDK(viewManager.getScanner().nextLine());
                        break;
                    case "7":
                        System.out.print("Enter filename: ");
                        cs.importYDK(viewManager.getScanner().nextLine());
                        break;
                    case "8":
                        System.out.println("Logging off...");
                        viewManager.quit();
                        break;
                    default:
                        throw new InvalidInputException("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("==================================================");
        }
    }

    // Takes user input needed to add a card to the database using YGOAPI
    public void addCard() {
        System.out.print("Enter card name: ");
        String query = viewManager.getScanner().nextLine();
        Card c = ygo.searchCard(query);

        if (c != null) {
            try {
                System.out.print(c.getName() + " - Enter Quantity: ");
                int num = Integer.parseInt(viewManager.getScanner().nextLine());
                if (num <= 0) {
                    System.out.println("Invalid quantity. Quantity set to 1.");
                    num = 1;
                }
                c.setNum(num);
                db.addCard(c, DataStore.getUser().getID());
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number.");
            }
        }
    }

    // Takes user input needed to remove a card from the database using YGOAPI
    public void removeCard() {
        cs.naviCollection();
        try {
            Card c = cs.naviCard(Integer.parseInt(viewManager.getScanner().nextLine()));
            System.out.print("You have " + c.getNum() + " copies. How many would you like to remove? ");
            int num = Integer.parseInt(viewManager.getScanner().nextLine());
            if (num >= c.getNum()) {
                num = c.getNum();
                db.removeCard(c.getId(), DataStore.getUser().getID());
            } else {
                c.setNum(c.getNum() - num);
                db.updateCard(c, DataStore.getUser().getID());
            }
            System.out.println("Removed " + num + " copies.");
        } catch (NumberFormatException e) {
            System.out.println("Input must be a number.");
        }
    }

    // Takes user input to display a single card's details
    public void viewCardDetails() {
        cs.naviCollection();
        try {
            Card c = cs.naviCard(Integer.parseInt(viewManager.getScanner().nextLine()));
            System.out.println("==================================================");
            cs.printCard(c);
        } catch (NumberFormatException e) {
            System.out.println("Invalid option.");
        }
    }

}
