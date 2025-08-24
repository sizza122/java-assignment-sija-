
abstract class Character {
    private String name;
    private int health;

    public Character(String name, int health) throws Exception {
        if (health <= 0) {
            throw new Exception("Health must be positive!");
        }
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }

    public abstract void attack();
}

class Warrior extends Character {
    public Warrior(String name, int health) throws Exception {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " swings a sword!");
    }
}

class Mage extends Character {
    public Mage(String name, int health) throws Exception {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " casts a fireball!");
    }
}

class Archer extends Character {
    public Archer(String name, int health) throws Exception {
        super(name, health);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " shoots an arrow!");
    }
}

public class GameCharacterSystmr {
    public static void main(String[] args) {
        try {
            Character c1 = new Warrior("nibesh", 100);
            Character c2 = new Mage("nirajan", 80);
            Character c3 = new Archer("anish", 90);
            c1.attack();
            c2.attack();
            c3.attack();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

