// Subclass that extends base class
public class SavingsAccount extends Account 
{
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) 
    {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) 
    {
        if (amount > 0) balance += amount;
    }

    @Override
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    public void applyInterest() 
    {
        balance += balance * interestRate;
    }
}
