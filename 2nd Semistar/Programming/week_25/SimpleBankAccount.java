public class SimpleBankAccount {
    private String owner;
    private double balance;

    public SimpleBankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        SimpleBankAccount account = new SimpleBankAccount("Alice", 500);
        account.deposit(200);
        System.out.println("Balance after deposit: " + account.getBalance());
        account.withdraw(800);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}

