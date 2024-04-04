package menu;

import java.util.Scanner;

import storage.AccountStorage;
import system.LoginSystem;
import view.LoginView;
import view.RegisterView;

public class LibrarianMenu {
    public void librarian(Scanner scanner) {
        String filePath = "csdl/Account.csv";
        AccountStorage account = new AccountStorage();
        account.readFile(filePath);
        LoginSystem loginSystem = new LoginSystem(filePath);
        System.out.println("------ Management program ------");
        int choice;
        do {
            System.out.println("Choose an option: ");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    LoginView loginView = new LoginView();
                    loginView.login(scanner);
                    // login(scanner);
                    break;
                case 2:
                    RegisterView registerView = new RegisterView();
                    registerView.register(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        boolean loggedIn = loginSystem.checkLogin(filePath);
        if (loggedIn) {
            System.out.println("Logged in successfully! Starting management program...");
        } else {
            System.out.println("Exiting program...");
        }
    }
}
