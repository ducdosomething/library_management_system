package view;

import java.util.Scanner;

import storage.AccountStorage;
import system.RegistrationSystem;

public class RegisterView {
    public void register(Scanner scanner) {

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
