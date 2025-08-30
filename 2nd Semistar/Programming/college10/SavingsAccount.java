public class SavingsAccount extends Account 
{
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) 
    {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
        }
    }

    @Override
    public double checkBalance() 
    {
        return balance;
    }

    public void applyInterest() 
    {
        balance += balance * interestRate;
    }
}