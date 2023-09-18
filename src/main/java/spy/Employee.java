package spy;

public class Employee {
    private String name;
    private static int BASE_SALARY = 3000;
    private double bonus;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return BASE_SALARY + getBonus();
    }

    public double getBonus() {
        return bonus;
    }
}
