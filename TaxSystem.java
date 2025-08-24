
abstract class TaxPayer {
    private String name;
    private double income;

    public TaxPayer(String name, double income) throws Exception {
        if (income < 0) {
            throw new Exception("Income cannot be negative for: " + name);
        }
        this.name = name;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public abstract double calculateTax();
}

class Individual extends TaxPayer {
    public Individual(String name, double income) throws Exception {
        super(name, income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * 0.1; // 10% tax
    }
}

class Business extends TaxPayer {
    public Business(String name, double income) throws Exception {
        super(name, income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * 0.25; // 25% tax
    }
}

class Freelancer extends TaxPayer {
    public Freelancer(String name, double income) throws Exception {
        super(name, income);
    }

    @Override
    public double calculateTax() {
        return getIncome() * 0.15; // 15% tax
    }
}

public class TaxSystem {
    public static void main(String[] args) {
        try {
            TaxPayer p1 = new Individual("Raj", 50000);
            TaxPayer p2 = new Business("karan", 200000);
            TaxPayer p3 = new Freelancer("binaya", 80000);

            System.out.println(p1.getName() + " Tax: $" + p1.calculateTax());
            System.out.println(p2.getName() + " Tax: $" + p2.calculateTax());
            System.out.println(p3.getName() + " Tax: $" + p3.calculateTax());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
