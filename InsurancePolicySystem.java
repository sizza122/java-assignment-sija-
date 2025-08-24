
abstract class InsurancePolicy {
    private int age;
    private double coverage;

    public InsurancePolicy(int age, double coverage) throws Exception {
        if (age <= 0 || coverage <= 0) {
            throw new Exception("Invalid age or coverage amount!");
        }
        this.age = age;
        this.coverage = coverage;
    }

    public int getAge() {
        return age;
    }

    public double getCoverage() {
        return coverage;
    }

    public abstract double calculatePremium();
}

class HealthInsurance extends InsurancePolicy {
    public HealthInsurance(int age, double coverage) throws Exception {
        super(age, coverage);
    }

    @Override
    public double calculatePremium() {
        return getCoverage() * 0.02 + getAge() * 5;
    }
}

class LifeInsurance extends InsurancePolicy {
    public LifeInsurance(int age, double coverage) throws Exception {
        super(age, coverage);
    }

    @Override
    public double calculatePremium() {
        return getCoverage() * 0.03 + getAge() * 10;
    }
}

class TravelInsurance extends InsurancePolicy {
    public TravelInsurance(int age, double coverage) throws Exception {
        super(age, coverage);
    }

    @Override
    public double calculatePremium() {
        return getCoverage() * 0.01 + getAge() * 2;
    }
}

public class InsurancePolicySystem {
    public static void main(String[] args) {
        try {
            InsurancePolicy p1 = new HealthInsurance(25, 200000);
            InsurancePolicy p2 = new LifeInsurance(30, 500000);


            System.out.println("Health Premium: " + p1.calculatePremium());
            System.out.println("Life Premium: " + p2.calculatePremium());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
