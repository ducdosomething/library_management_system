package system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistrationSystem {

    public static void registerUser(String filePath, String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (new File(filePath).length() > 0) {
                writer.newLine();
            }
            writer.write(username + "," + password);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void checkRegistration(String filePath) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Would you like to register a new account? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                return;
            } else if (response.equalsIgnoreCase("yes")) {
                System.out.print("Enter your new username: ");
                String newUsername = scanner.nextLine();

                System.out.print("Enter your new password: ");
                String newPassword = scanner.nextLine();

                registerUser(filePath, newUsername, newPassword);
                System.out.println("Registration successful!");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
