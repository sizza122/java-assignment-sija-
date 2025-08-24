
class InvalidBonusSalaryException extends Exception {
    public InvalidBonusSalaryException(String message) {
        super(message);
    }
}

abstract class BonusEmployee {
    private String name;
    private double salary;


    public BonusEmployee(String name, double salary) throws InvalidBonusSalaryException {
        if (salary <= 0) {
            throw new InvalidBonusSalaryException("Salary must be greater than 0 for employee: " + name);
        }
        this.name = name;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }


    public abstract double calculateBonus();
}


class BonusPermanentEmployee extends BonusEmployee {
    public BonusPermanentEmployee(String name, double salary) throws InvalidBonusSalaryException {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.30; // 30% bonus
    }
}


class BonusContractEmployee extends BonusEmployee {
    public BonusContractEmployee(String name, double salary) throws InvalidBonusSalaryException {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.10; // 10% bonus
    }
}


public class EmployeeBonusSystem {
    public static void main(String[] args) {
        try {
            BonusEmployee emp1 = new BonusPermanentEmployee("messi", 5000);
            BonusEmployee emp2 = new BonusContractEmployee("Ronaldo", 4000);
            BonusEmployee emp3 = new BonusPermanentEmployee("Neymar", 6000);

            System.out.println(emp1.getName() + " Bonus: " + emp1.calculateBonus());
            System.out.println(emp2.getName() + " Bonus: " + emp2.calculateBonus());
            System.out.println(emp3.getName() + " Bonus: " + emp3.calculateBonus());

        } catch (InvalidBonusSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
