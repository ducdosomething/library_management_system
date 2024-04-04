package menu;

import java.util.Scanner;

import storage.AccountStorage;
import system.LoginSystem;
import system.RegistrationSystem;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filePath = "csdl/Account.txt";
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
                    view1(scanner);
                    break;
                case 2:
                    view2(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        boolean loggedIn = loginSystem.checkLogin(filePath);
        if (loggedIn) {
            System.out.println("Logged in successfully! Starting management program...");
        } else {
            System.out.println("Exiting program...");
        }
    }

    private static void view1(Scanner scanner) {

        String filePath = "csdl/Account.txt";
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

    private static void view2(Scanner scanner) {

        String filePath = "csdl/Account.txt";
        AccountStorage account = new AccountStorage();
        account.readFile(filePath);

        RegistrationSystem registrationSystem = new RegistrationSystem();

        System.out.println("----------- Register -----------");
        registrationSystem.checkRegistration(filePath);
        System.out.println("Press 0 to return to the main menu.");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}
