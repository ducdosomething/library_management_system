package menu;

import java.util.Scanner;

import storage.AccountStorage;

/**
 * Menu
 */
public class  MainMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String filePath = "csdl/Account.csv";
        AccountStorage account = new AccountStorage();
        account.readFile(filePath);

        System.out.println("------ Library Management System ------");
        int choice;

        do {
            System.out.println("Choose the role: ");
            System.out.println("1. Librarian");
            System.out.println("2. User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    LibrarianMenu librarianMenu = new LibrarianMenu();
                    librarianMenu.librarian(scanner);
                    break;
                case 2:
                    // user(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}