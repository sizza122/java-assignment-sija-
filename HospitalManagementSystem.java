

class InvalidPersonDataException extends Exception {
    public InvalidPersonDataException(String message) {
        super(message);
    }
}

abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidPersonDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPersonDataException("Name cannot be empty");
        }
        if (age <= 0) {
            throw new InvalidPersonDataException("Age must be positive");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization) throws InvalidPersonDataException {
        super(name, age);
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new InvalidPersonDataException("Specialization cannot be empty");
        }
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }
}

class Patient extends Person {
    private String disease;

    public Patient(String name, int age, String disease) throws InvalidPersonDataException {
        super(name, age);
        if (disease == null || disease.trim().isEmpty()) {
            throw new InvalidPersonDataException("Disease cannot be empty");
        }
        this.disease = disease;
    }

    public String getDisease() { return disease; }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        try {
            Doctor doc = new Doctor("Dr.sija", 21, "Cardiology");
            Patient pat = new Patient("shreejan", 21, "Flu");

            System.out.println("Doctor: " + doc.getName() + ", Specialization: " + doc.getSpecialization());
            System.out.println("Patient: " + pat.getName() + ", Disease: " + pat.getDisease());
        } catch (InvalidPersonDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

