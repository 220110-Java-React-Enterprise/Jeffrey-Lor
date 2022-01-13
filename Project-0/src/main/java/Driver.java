import models.Card;
import ui.Menu;
import ui.MenuConsole;

public class Driver {
	public static void main(String [] args) {
		Menu menu = new MenuConsole();
		if(menu.loginMenu()) {
			menu.mainMenu();
		}
		Card c = new Card();
		c.printCard();
	}
}
