import ui.*;

public class Driver {

	public static void main(String[] args) {
		ViewManager viewManager = ViewManager.getViewManager();

		// Add Views
		viewManager.addView(new LoginMenu());
		viewManager.addView(new MainMenu());

		// Navigate to Main Menu
		viewManager.navigate("LoginMenu");

		while (viewManager.isRunning()) {
			viewManager.render();
		}

	}

}
