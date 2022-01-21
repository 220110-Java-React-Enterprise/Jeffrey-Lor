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
        while (!option.equals("7")) {
            try {
                System.out.println(
                        "1. View your collection\n2. Add cards to your collection\n3. Remove cards from your collection\n4. View card details from your collection\n5. Import Collecion from txt\n6. Export Collection to txt\n7. Quit");
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
                        cs.viewCollection();
                        break;
                    case "5":
                        cs.viewCollection();
                        break;
                    case "6":
                        cs.viewCollection();
                        break;
                    case "7":
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

    public void addCard() {
        System.out.print("Enter card name: ");
        Card c = ygo.searchCard(viewManager.getScanner().nextLine());
        if (c != null) {
            System.out.print(c.getName() + " - Enter Quantity: ");
            int num = Integer.parseInt(viewManager.getScanner().nextLine());
            c.setNum(num);
            db.addCard(c, DataStore.getUser().getID());
        }
    }

    public void removeCard() {
        cs.naviCollection();
        try {
            Card c = cs.naviCard(Integer.parseInt(viewManager.getScanner().nextLine()));
            db.removeCard(c.getId(), DataStore.getUser().getID());
        } catch (NumberFormatException e) {
            System.out.println("Invalid option.");
        }
        
    }

    public void viewCardDetails() {

    }

    public void importCollection() {

    }

    public void exportCollection() {

    }
}
