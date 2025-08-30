// Book class with encapsulation
public class Book {
    private String title, author, ISBN;
    private double price;
    private Genre genre;
    private int stockQuantity;

    public Book(String title, String author, String ISBN, double price, Genre genre, int stockQuantity) {
        this.title = title; this.author = author; this.ISBN = ISBN;
        this.price = price; this.genre = genre; this.stockQuantity = stockQuantity;
    }

    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void updateStock(int change) {
        if (stockQuantity + change < 0) throw new IllegalArgumentException("Stock cannot be negative");
        stockQuantity += change;
    }
}
