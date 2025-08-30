public class BookstoreApp 
{
    public static void main(String[] args) 
    {
        Inventory inventory = Inventory.getInstance();
        Book book = new Book("1984", "George Orwell", "1234567890", 15.99, 100);
        inventory.addBook(book);
        Customer customer = new Customer("john_doe", "pass123", "john@example.com");
        customer.addToCart(book, 2);
        System.out.println("Cart total: $" + customer.getCart().calculateTotal());
    }
}