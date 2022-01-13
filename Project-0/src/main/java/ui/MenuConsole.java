package ui;

import java.util.Scanner;

public class MenuConsole implements Menu {

    @Override
    public boolean loginMenu() {
        System.out.println("Login");
        return true;
    }

    @Override
    public void mainMenu() {
        int input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();
        switch(input) {
        case 0:
            System.out.println("Test1");
            break;
        case 1:
            System.out.println("Test2");
            break;
        case 2:
            System.out.println("Test3");
            break;
        case 3:
            System.out.println("Test4");
            break;
        default:
            break;
        }
        System.out.println("Test");
        scan.close();
    }

}
