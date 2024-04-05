package bookmanagerment;

import java.util.List;

import model.Book;
import storage.BookStorage;

/**
 * BookManagerment
 */
public class BookManagerment {

    public static void showBook() {
        List<Book> books = BookStorage.readBooks();
        if (books.isEmpty()) {
            System.out.println("No book available!");
            return;
        }
        System.out.printf("%10s | %20s | %30s | %20s | %10s \n", "ID", "Name", "PRICE", "AUTHOR", "INVENTORYQUANTITY");
        for (Book b : books) {
            System.out.printf("%10s | %20s | %30s | %20s | %10s \n",
                    b.getBookId(), b.getName(), b.getPrice(), b.getAuthor(), b.getInventoryQuantity());
        }
    }
}