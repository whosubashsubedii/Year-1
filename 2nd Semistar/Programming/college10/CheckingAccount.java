public class CheckingAccount extends Account 
{
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) 
    {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) 
    {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;
        }
    }

    @Override
    public double checkBalance() 
    {
        return balance;
    }
}


