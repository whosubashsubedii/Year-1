public class BankAccount {
    private long accountNumber;
    private String accountHolderName;
    private String regDate;
    private String accountType;
    private double balance;

    public BankAccount(long accNo, String name, String regDate, String type, double amt) {
        this.accountNumber = accNo;
        this.accountHolderName = name;
        this.regDate = regDate;
        this.accountType = type;
        this.balance = amt;
    }

    // Getters
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method with validation
    public String deposit(double amt) {
        if (amt <= 0) {
            return "Deposit amount must be positive.";
        }
        balance += amt;
        return "Balance after deposit is: " + balance;
    }

    // Withdraw method with balance check
    public String withdraw(double amt) {
        if (amt <= 0) {
            return "Withdrawal amount must be positive.";
        } else if (amt > balance) {
            return "Insufficient balance.";
        }
        balance -= amt;
        return "Balance after withdrawal is: " + balance;
    }

}
