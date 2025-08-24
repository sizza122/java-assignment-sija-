
class InvalidShapeDataException extends Exception {
    public InvalidShapeDataException(String message) {
        super(message);
    }
}

abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) throws InvalidShapeDataException {
        if (radius < 0) {
            throw new InvalidShapeDataException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) throws InvalidShapeDataException {
        if (length < 0 || width < 0) {
            throw new InvalidShapeDataException("Length and width must be positive");
        }
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class AbstractShapeClass {
    public static void main(String[] args) {
        try {
            Shape c = new Circle(5);
            Shape r = new Rectangle(4, 6);

            System.out.println("Circle Area: " + c.calculateArea());
            System.out.println("Rectangle Area: " + r.calculateArea());
        } catch (InvalidShapeDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
