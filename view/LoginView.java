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
        if (loginSystem.checkLogin(filePath)) {

            LibrarianView librarianView = new LibrarianView();
            librarianView.showLibrarianView();
            // System.out.println("------------ Management program ------------");
            // int choice;

            // do {
            // System.out.println("Choose an option: ");
            // System.out.println("1. Show all books.");
            // System.out.println("2. Search book.");
            // System.out.println("0. Exit");
            // System.out.print("Enter your choice: ");
            // choice = scanner.nextInt();

            // switch (choice) {
            // case 1:
            // System.out.println("Case 1");
            // break;
            // case 2:
            // System.out.println("Case 2");
            // break;
            // case 0:
            // System.out.println("Exiting...");
            // default:
            // System.out.println("Invalid choice. Please try again.");
            // }
            // } while (choice != 3);
        }
        System.out.println("Press 0 to return to the main menu.");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}
