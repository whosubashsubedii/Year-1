public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double startingBalance) {
        this.owner = owner;
        this.balance = Math.max(startingBalance, 0); // Ensures non-negative balance
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Wonder Woman", 1000);
        account.deposit(5000); // Adds 5000 to balance
        account.withdraw(2000); // Subtracts 2000 from balance
        System.out.println("Owner: " + account.getOwner() + ", Balance: " + account.getBalance());
    }
}