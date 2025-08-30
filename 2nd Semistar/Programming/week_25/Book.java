public class Book 
{
    private String title;
    private String author;
    private String ISBN;
    private double price;
    private int stockQuantity;

    public Book(String title, String author, String ISBN, double price, int stockQuantity) 
    {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public void updateStock(int change) 
    {
        if (stockQuantity + change < 0) throw new IllegalArgumentException("Out of stock");
        stockQuantity += change;
    }
}