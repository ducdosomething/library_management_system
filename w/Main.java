package w;

import java.util.Scanner;

import storage.AccountStorage;
import system.LoginSystem;
import system.RegistrationSystem;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String filePath = "csdl/Account.txt";
        AccountStorage account = new AccountStorage();
        account.readFile(filePath);

        LoginSystem loginSystem = new LoginSystem(filePath);
        RegistrationSystem registrationSystem = new RegistrationSystem();

        System.out.println("------ Management program ------");
        boolean exitProgram = false;
        while (!exitProgram) {
            System.out.println("Choose an option: ");
            System.out.println("1. Login ");
            System.out.println("2. Register ");
            System.out.println("3. Exit ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("------------ Log in ------------");
                    loginSystem.checkLogin(filePath);

                    break;
                case 2:
                    System.out.println("----------- Register -----------");
                    registrationSystem.checkRegistration(filePath);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    break;
            }
        }

        boolean loggedIn = loginSystem.checkLogin(filePath);
        if (loggedIn) {
            System.out.println("Logged in successfully! Starting management program...");
        } else {
            System.out.println("Exiting program...");
        }
    }
}
