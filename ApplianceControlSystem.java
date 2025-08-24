

class InvalidApplianceStateException extends Exception {
    public InvalidApplianceStateException(String message) {
        super(message);
    }
}

abstract class Appliance {
    private String name;

    public Appliance(String name) throws InvalidApplianceStateException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidApplianceStateException("Appliance name cannot be empty");
        }
        this.name = name;
    }

    public String getName() { return name; }

    public abstract void turnOn();
    public abstract void turnOff();
}

class Fan extends Appliance {
    public Fan(String name) throws InvalidApplianceStateException {
        super(name);
    }

    @Override
    public void turnOn() { System.out.println(getName() + " Fan is now ON"); }
    @Override
    public void turnOff() { System.out.println(getName() + " Fan is now OFF"); }
}

class Light extends Appliance {
    public Light(String name) throws InvalidApplianceStateException {
        super(name);
    }

    @Override
    public void turnOn() { System.out.println(getName() + " Light is now ON"); }
    @Override
    public void turnOff() { System.out.println(getName() + " Light is now OFF"); }
}

class AC extends Appliance {
    public AC(String name) throws InvalidApplianceStateException {
        super(name);
    }

    @Override
    public void turnOn() { System.out.println(getName() + " AC is now ON"); }
    @Override
    public void turnOff() { System.out.println(getName() + " AC is now OFF"); }
}

public class ApplianceControlSystem {
    public static void main(String[] args) {
        try {
            Appliance[] appliances = {
                    new Fan("Living Room"),
                    new Light("Bedroom"),
                    new AC("Office")
            };

            for (Appliance appliance : appliances) {
                appliance.turnOn();
                appliance.turnOff();
            }
        } catch (InvalidApplianceStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
