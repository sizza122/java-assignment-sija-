
class InvalidFareException extends Exception {
    public InvalidFareException(String message) {
        super(message);
    }
}

class Transport {
    private double distance;

    public Transport(double distance) throws InvalidFareException {
        if (distance <= 0) {
            throw new InvalidFareException("Distance must be greater than 0!");
        }
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public double calculateFare() {
        return 0;
    }
}

class Bus extends Transport {
    public Bus(double distance) throws InvalidFareException {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * 10;
    }
}

class Train extends Transport {
    public Train(double distance) throws InvalidFareException {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() *5;
    }
}

class Taxi extends Transport {
    public Taxi(double distance) throws InvalidFareException {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * 15;
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        try {
            Transport t1 = new Bus(15);
            Transport t2 = new Train(20);
            Transport t3 = new Taxi(5);

            System.out.println("Bus Fare: " + t1.calculateFare());
            System.out.println("Train Fare: " + t2.calculateFare());
            System.out.println("Taxi Fare: " + t3.calculateFare());
        } catch (InvalidFareException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
