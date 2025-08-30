public class BankAccount 
{
    private String owner;
    private double balance;

    public BankAccount(String owner, double startingBalance) 
    {
        this.owner = owner;
        this.balance = Math.max(startingBalance, 0);   
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
        }
    }
}












