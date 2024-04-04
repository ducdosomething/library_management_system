package system;

import view.LoginView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                while (true) {
                    System.out.print("Enter your new username: ");
                    String newUsername = scanner.nextLine();

                    if (!isValidUsername(newUsername)) {
                        System.out.println("Username is invalid, please try again!");
                        continue;
                    }

                    while (true) {
                        System.out.print("Enter your new password: ");
                        String newPassword = scanner.nextLine();

                        if (!isValidPassword(newPassword)) {
                            System.out.println("Password is invalid,please try again!");
                            continue;
                        }

                        registerUser(filePath, newUsername, newPassword);
                        System.out.println("Registration successful!");
                        LoginView loginView = new LoginView();
                        loginView.login(scanner);~
                        break;
                    }
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    private static boolean isValidUsername(String username) {
        String regex = "^[A-Z][a-zA-Z0-9]*\\d.*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
