// Customer adding book to cart and checkout
public class Customer extends User {
    private Cart shoppingCart = new char();

    public void addToCart(Book book) {
        if (book.getStockQuantity() > 0) shoppingCart.addItem(book);
        else System.out.println("Out of stock!");
    }

    public void checkout(Payment payment) {
        double total = shoppingCart.calculateTotal();
        payment.processPayment(total);
        // Process order & update inventory here...
    }
}
