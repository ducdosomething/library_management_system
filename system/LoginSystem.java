package system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoginSystem {
    private HashMap<String, String> users;

    public LoginSystem(String filePath) {
        users = new HashMap<>();
        loadUsers(filePath);
    }

    private void loadUsers(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    users.put(username, password);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public boolean authenticate(String username, String password) {
        if (users.containsKey(username)) {
            String storedPassword = users.get(username);
            return storedPassword.equals(password);
        }
        return false;
    }

    public boolean checkLogin(String filePath) {
        LoginSystem loginSystem = new LoginSystem(filePath);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your username (or 'exit' to quit): ");
            String username = scanner.nextLine();
            if (username.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                return false;
            }

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (loginSystem.authenticate(username, password)) {
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }
}
