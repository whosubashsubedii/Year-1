// Subclass 2
public class Analyst extends Employee {
    private double annualBonus;

    public Analyst(String name, double salary, int age, double annualBonus) {
        super(name, salary, age); // call Employee constructor
        this.annualBonus = annualBonus;
    }

    public void displayAnalystInfo() {
        displayInfo();
        System.out.println("Annual Bonus: $" + annualBonus);
    }
}