package ui;

import dao.IUserRepo;
import dao.UserRepoDB;
import models.User;
import services.ILoginService;
import services.LoginService;

public class LoginMenu extends View {

    private IUserRepo repo = new UserRepoDB();
    private ILoginService loginService = new LoginService();

    public LoginMenu() {
        viewName = "LoginMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        String option = "";
        boolean flag = true;
        while (flag) {
            System.out.println("===========================");
            System.out.println("1. Login\n2. Register");
            System.out.println("===========================");
            option = viewManager.getScanner().nextLine();
            if (option.equals("1")) {
                // Login
                System.out.println("========== Login ==========");
                System.out.print("Username: ");
                String username = viewManager.getScanner().nextLine();
                System.out.print("Password: ");
                String password = viewManager.getScanner().nextLine();

                User u = loginService.login(username, password);
                if(u != null) {
                    System.out.println("==== Login Successful! ====");
                    DataStore.setUser(u);
                    flag = !flag;
                } else {
                    System.out.println("Username or Password is incorrect or not found.");
                }
                
            } else if (option.equals("2")) {
                // Register
                System.out.println("========= Register ========");
                System.out.print("Username: ");
                String username = viewManager.getScanner().nextLine();
                System.out.print("Password: ");
                String password = viewManager.getScanner().nextLine();

                // Add username and password checks here

                // Add User to database
                repo.addUser(username, password);
            } else if (!option.equals("1")) {
                System.out.println("Invalid option.");
            }
        }

        viewManager.navigate("MainMenu");
    }
}
