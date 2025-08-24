
class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

abstract class Payment {
    private double amount;

    public Payment(double amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Amount must be positive");
        }
        this.amount = amount;
    }

    public double getAmount() { return amount; }

    public abstract void processPayment() throws PaymentException;
}

class CreditCard extends Payment {
    private String cardNumber;

    public CreditCard(double amount, String cardNumber) throws PaymentException {
        super(amount);
        if (cardNumber == null || cardNumber.length() != 16) {
            throw new PaymentException("Invalid card number");
        }
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card payment of $" + getAmount());
    }
}

class UPI extends Payment {
    private String upiId;

    public UPI(double amount, String upiId) throws PaymentException {
        super(amount);
        if (upiId == null || !upiId.contains("@")) {
            throw new PaymentException("Invalid esewa ID");
        }
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing esewa payment of $" + getAmount());
    }
}

class NetBanking extends Payment {
    private String username;

    public NetBanking(double amount, String username) throws PaymentException {
        super(amount);
        if (username == null || username.trim().isEmpty()) {
            throw new PaymentException("Invalid username");
        }
        this.username = username;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing Net Banking payment of $" + getAmount());
    }
}

public class OnlinePaymentGateway {
    public static void main(String[] args) {
        try {
            Payment[] payments = {
                    new CreditCard(5000, "1234567812345678"),
                    new UPI(1500, "lol"),
                    new NetBanking(3000, "Raj")
            };

            for (Payment payment : payments) {
                payment.processPayment();
            }
        } catch (PaymentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
