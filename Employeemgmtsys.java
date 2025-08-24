
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) throws InvalidSalaryException {
        if (baseSalary < 0) {
            throw new InvalidSalaryException("Salary can't be negative");
        }
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public abstract double calculateSalary();
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) throws InvalidSalaryException {
        super(name, baseSalary);
        if (bonus < 0) {
            throw new InvalidSalaryException("Bonus can't be negative");
        }
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class Developer extends Employee {
    private double overtimePay;

    public Developer(String name, double baseSalary, double overtimePay) throws InvalidSalaryException {
        super(name, baseSalary);
        if (overtimePay < 0) {
            throw new InvalidSalaryException("Overtime pay can't be negative");
        }
        this.overtimePay = overtimePay;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + overtimePay;
    }
}

public class Employeemgmtsys {
    public static void main(String[] args) {
        try {
            Employee m = new Manager("sija", 50000, 10000);
            Employee d = new Developer("magar", 40000, 5000);

            System.out.println(m.getName() + " Salary: " + m.calculateSalary());
            System.out.println(d.getName() + " Salary: " + d.calculateSalary());
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

