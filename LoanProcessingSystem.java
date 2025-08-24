
abstract class Loan {
    private double amount;

    public Loan(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than 0!");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }


    public abstract double calculateInterest();
}

class HomeLoan extends Loan {
    public HomeLoan(double amount) {
        super(amount);
    }

    @Override
    public double calculateInterest() {
        return getAmount() * 0.08;  // 8% interest
    }
}


class CarLoan extends Loan {
    public CarLoan(double amount) {
        super(amount);
    }

    @Override
    public double calculateInterest() {
        return getAmount() * 0.10;  // 10% interest
    }
}


class EducationLoan extends Loan {
    public EducationLoan(double amount) {
        super(amount);
    }

    @Override
    public double calculateInterest() {
        return getAmount() * 0.05;  // 5% interest
    }
}


public class LoanProcessingSystem{
    public static void main(String[] args) {
        try {
            Loan home = new HomeLoan(500000);
            Loan car = new CarLoan(300000);
            Loan edu = new EducationLoan(200000);


            System.out.println("Home Loan Interest: " + home.calculateInterest());
            System.out.println("Car Loan Interest: " + car.calculateInterest());
            System.out.println("Education Loan Interest: " + edu.calculateInterest());


            Loan invalid = new CarLoan(-10000);
            System.out.println("Invalid Loan Interest: " + invalid.calculateInterest());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
