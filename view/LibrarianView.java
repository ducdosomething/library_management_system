package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bookmanagerment.BookManagerment;
import model.Book;
import storage.BookStorage;

public class LibrarianView {
    public void showLibrarianView() {

        List<Book> list = BookStorage.readBooks();
        if (list == null) {
            list = new ArrayList<>();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("------------ Management program ------------");
        int choice;

        do {
            System.out.println("Choose an option: ");
            System.out.println("1. Show all books.");
            System.out.println("2. Search book.");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    BookManagerment.showBook();
                    break;
                case 2:
                    System.out.println("Case 2");
                    break;
                case 0:
                    System.out.println("Exiting...");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
}
