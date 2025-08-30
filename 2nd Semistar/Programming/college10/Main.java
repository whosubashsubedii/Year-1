public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Wonder Woman", 1000);
        account.deposit(5000);
        account.withdraw(2000);
        System.out.println("Owner: " + account.getOwner() + ", Balance: " + account.getBalance());
    }
}
