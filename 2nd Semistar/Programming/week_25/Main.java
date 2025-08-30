// Main class test
public class Main 
{
    public static void main(String[] args) 
    {
        Salesperson sp = new Salesperson("Alice", 50000, 30, 10);
        Analyst an = new Analyst("Bob", 60000, 35, 5000);

        System.out.println("=== Salesperson Info ===");
        sp.displaySalespersonInfo();
        sp.raiseSalary(2000);

        System.out.println("\n=== Analyst Info ===");
        an.displayAnalystInfo();
        an.raiseSalary(1500);
    }
}
