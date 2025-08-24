

class Calculator {
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }

    public int subtract(int a, int b) { return a - b; }
    public double subtract(double a, double b) { return a - b; }

    public int multiply(int a, int b) { return a * b; }
    public double multiply(double a, double b) { return a * b; }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class CalculatorMethodOverloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            System.out.println("Add: " + calc.add(5, 3));
            System.out.println("Divide: " + calc.divide(10, 2));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

