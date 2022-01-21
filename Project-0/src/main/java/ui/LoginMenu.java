package ui;

import dao.IUserRepo;
import dao.UserRepoDB;
import exceptions.InvalidEmailException;
import exceptions.InvalidInputException;
import models.User;
import services.EmailValidator;
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
        String email;
        String password;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("==================================================");
                System.out.println("1. Login\n2. Register");
                System.out.println("==================================================");
                option = viewManager.getScanner().nextLine();
                if (option.equals("1")) {
                    // Login
                    System.out.println("===================== Login ======================");
                    
                    System.out.print("Email: ");
                    email = viewManager.getScanner().nextLine();
                    System.out.print("Password: ");
                    password = viewManager.getScanner().nextLine();

                    User u = loginService.login(email, password);
                    if (u != null) {
                        System.out.println("=============== Login Successful! ================");
                        DataStore.setUser(u);
                        flag = !flag;
                    } else {
                        System.out.println("Username or Password is incorrect or not found.");
                    }

                } else if (option.equals("2")) {
                    // Register
                    System.out.println("===================== Register ===================");
                    System.out.print("Email: ");
                    email = viewManager.getScanner().nextLine();

                    if (!EmailValidator.isValid(email)) {
                        throw new InvalidEmailException("Invalid email.");
                    }

                    System.out.print("Password: ");
                    password = viewManager.getScanner().nextLine();

                    // Add User to database
                    repo.addUser(email, password);

                } else if (!option.equals("1")) {
                    throw new InvalidInputException("Invalid option.");
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }

        }

        viewManager.navigate("MainMenu");
    }
}
