package view;

import java.util.Scanner;

import storage.AccountStorage;
import system.LoginSystem;

public class LoginView {
    public void login(Scanner scanner) {

        String filePath = "csdl/Account.csv";
        AccountStorage account = new AccountStorage();
        account.readFile(filePath);

        LoginSystem loginSystem = new LoginSystem(filePath);

        System.out.println("------------ Log in ------------");
        loginSystem.checkLogin(filePath);
        System.out.println("Press 0 to return to the main menu.");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}
