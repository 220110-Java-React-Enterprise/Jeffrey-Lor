package ui;

import models.Card;
import services.CardService;
import services.ICardService;
import web.YGOAPI;

public class MainMenu extends View{

    private ICardService cs;
    private YGOAPI ygo;

    public MainMenu() {
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
        this.cs = new CardService();
        this.ygo = new YGOAPI();
    }

    @Override
    public void renderView() {
        String option = "";
        Card c;
        while (!option.equals("5")) {
            System.out.println(
                    "1. View your collection\n2. Add cards to your collection\n3. Remove cards from your collection\n4. View cards in your collection\n5. Quit");
            option = viewManager.getScanner().nextLine();
            switch (option) {
                case "1":
                    cs.viewCollection();
                    break;
                case "2":
                    System.out.print("Enter card name: ");
                    c = ygo.searchCard(viewManager.getScanner().nextLine().replaceAll(" ", "%20"));
                    cs.printCard(c);
                    break;
                case "3":
                    System.out.println("Test3");
                    break;
                case "4":
                    c = new Card();
                    cs.printCard(c);
                    break;
                case "5":
                    System.out.println("Logging off...");
                    viewManager.quit();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
