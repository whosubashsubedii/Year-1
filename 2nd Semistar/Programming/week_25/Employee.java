// Superclass
public class Employee 
{
    protected String name;
    protected double salary;
    protected int age;

    public Employee(String name, double salary, int age) 
    {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public void raiseSalary(double amount) 
    {
        salary += amount;
        System.out.println(name + "'s salary increased to " + salary);
    }

    public void displayInfo() 
    {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: $" + salary);
    }
}
