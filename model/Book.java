package model;

public class Book {
    private int bookId;
    private String name;
    private double price;
    private String author;
    private int inventoryQuantity;

    public Book() {
    }

    public Book(int bookId, String name, double price, String author, int inventoryQuantity) {
        this.bookId = bookId;
        this.name = name;
        this.price = price;
        this.author = author;
        this.inventoryQuantity = inventoryQuantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", inventoryQuantity=" + inventoryQuantity +
                '}';
    }
}
