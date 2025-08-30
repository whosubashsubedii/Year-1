public class BankAccount 
{
    private String owner;
    private double balance;

    public static class InsufficientFundsException extends Exception 
    {
        public InsufficientFundsException(String message) 
        {
            super(message);
        }
    }

    public BankAccount(String owner, double startingBalance) 
    {
        if (startingBalance < 0) 
        {
            throw new IllegalArgumentException("Starting balance cannot be negative.");
        }
        this.owner = owner;
        this.balance = startingBalance;
    }

    public void deposit(double amount) 
    {
        if (amount <= 0) 
        {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) 
        {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) 
        {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }

    public double getBalance() 
    {
        return balance;
    }

    public static void main(String[] args) 
    {
        try 
        {
            BankAccount account = new BankAccount("Wonder Woman", 1000);
            System.out.println("Account created with balance: $" + account.getBalance());

            account.deposit(-50); // Invalid deposit
        } catch (IllegalArgumentException e) 
        {
            System.out.println("Error: " + e.getMessage());
        }

        try 
        {
            BankAccount account = new BankAccount("Wonder Woman", 1000);
            account.withdraw(1500); // Exceeds balance
        } catch (InsufficientFundsException | IllegalArgumentException e) 
        {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction processing complete.");
        }
    }
}