package ui;

public class LoginMenu extends View {
    public LoginMenu() {
        viewName = "LoginMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("========== Login ==========");
        System.out.println("Login Functionality goes here");
        System.out.println("===========================");

        viewManager.navigate("MainMenu");
    }
}
