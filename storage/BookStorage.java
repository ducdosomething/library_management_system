package storage;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookStorage implements Serializable {

    private static final String FILE_PATH = "csdl/Book.csv";

    public static List<Book> readBooks() {
        List<Book> books = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length == 6) {
                    int bookId = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    String category = parts[3];
                    String author = parts[4];
                    int inventoryQuantity = Integer.parseInt(parts[5]);
                    Book book = new Book(bookId, name, category, price, author, inventoryQuantity);
                    books.add(book);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing data: " + e.getMessage());
        }
        return books;
    }
}
