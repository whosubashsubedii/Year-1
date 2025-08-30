// Subclass 1
public class Salesperson extends Employee 
{
    private double commissionPercentage;

    public Salesperson(String name, double salary, int age, double commissionPercentage) 
    {
        super(name, salary, age); // call Employee constructor
        this.commissionPercentage = commissionPercentage;
    }

    public double calculateCommission() 
    {
        return salary * (commissionPercentage / 100);
    }

    public void displaySalespersonInfo() 
    {
        displayInfo();
        System.out.println("Commission Percentage: " + commissionPercentage + "%");
        System.out.println("Commission Earned: $" + calculateCommission());
    }
}