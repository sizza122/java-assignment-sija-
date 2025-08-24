
class InvalidAnimalDataException extends Exception {
    public InvalidAnimalDataException(String message) {
        super(message);
    }
}

abstract class Animal {
    private String name;

    public Animal(String name) throws InvalidAnimalDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidAnimalDataException("Animal name cannot be empty");
        }
        this.name = name;
    }

    public String getName() { return name; }

    public abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name) throws InvalidAnimalDataException {
        super(name);
    }
    @Override
    public void makeSound() { System.out.println(getName() + " says: Woof! Woof!"); }
}

class Cat extends Animal {
    public Cat(String name) throws InvalidAnimalDataException {
        super(name);
    }
    @Override
    public void makeSound() { System.out.println(getName() + " says: Meow! Meow!"); }
}

class Cow extends Animal {
    public Cow(String name) throws InvalidAnimalDataException {
        super(name);
    }
    @Override
    public void makeSound() { System.out.println(getName() + " says: Moo! Moo!"); }
}

public class Animalsmltr {
    public static void playAnimalSound(Animal animal) {
        animal.makeSound();
    }

    public static void main(String[] args) {
        try {
            Animal dog = new Dog("Rex");
            Animal cat = new Cat("Kitty");
            Animal cow = new Cow("Bessie");

            playAnimalSound(dog);
            playAnimalSound(cat);
            playAnimalSound(cow);
        } catch (InvalidAnimalDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
