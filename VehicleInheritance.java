
class InvalidVehicleDataException extends Exception {
    public InvalidVehicleDataException(String message) {
        super(message);
    }
}

abstract class Vehicle {
    private String brand;
    private int speed;

    public Vehicle(String brand, int speed) throws InvalidVehicleDataException {
        if (speed < 0) {
            throw new InvalidVehicleDataException("Speed cannot be negative");
        }
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() { return brand; }
    public int getSpeed() { return speed; }
}

class Car extends Vehicle {
    public Car(String brand, int speed) throws InvalidVehicleDataException {
        super(brand, speed);
    }
}

class Bike extends Vehicle {
    public Bike(String brand, int speed) throws InvalidVehicleDataException {
        super(brand, speed);
    }
}

public class VehicleInheritance {
    public static void main(String[] args) {
        try {
            Car car = new Car("Toyota", 120);
            Bike bike = new Bike("Honda", 80);

            System.out.println("Car: " + car.getBrand() + " Speed: " + car.getSpeed());
            System.out.println("Bike: " + bike.getBrand() + " Speed: " + bike.getSpeed());
        } catch (InvalidVehicleDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
