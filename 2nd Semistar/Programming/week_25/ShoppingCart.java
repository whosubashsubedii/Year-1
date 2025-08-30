import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Book, Integer> items = new HashMap<>();

    public void addBook(Book book, int quantity) {
        if (quantity > 0 && book.getStockQuantity() >= quantity) {
            items.put(book, items.getOrDefault(book, 0) + quantity);
        } else {
            throw new IllegalArgumentException("Invalid quantity or out of stock");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (var entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}