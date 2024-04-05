package bookmanagerment;

import java.util.List;

import model.Book;
import storage.BookStorage;

/**
 * BookManagerment
 */
public class BookManagerment {

    public static void showAllBook() {
        List<Book> books = BookStorage.readBooks();
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }
        System.out.printf("%5s | %20s | %15s | %10s | %20s | %10s \n", "ID", "NAME", "CATEGORY", "PRICE", "AUTHOR",
                "INVENTORYQUANTITY");
        for (Book b : books) {
            System.out.printf("%5d | %20s | %15s | %10.2fs | %20s | %10d \n",
                    b.getBookId(), b.getName(), b.getCategory(), b.getPrice(), b.getAuthor(), b.getInventoryQuantity());
        }
    }
}