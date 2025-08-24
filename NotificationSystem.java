
abstract class Notification {
    private String recipient;

    public Notification(String recipient) {
        if (recipient == null || recipient.isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be empty!");
        }
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }


    public abstract void send();
}


class EmailNotification extends Notification {
    private String emailMessage;

    public EmailNotification(String recipient, String emailMessage) {
        super(recipient);
        if (emailMessage == null || emailMessage.isEmpty()) {
            throw new IllegalArgumentException("Email message cannot be empty!");
        }
        this.emailMessage = emailMessage;
    }

    @Override
    public void send() {
        System.out.println("Sending Email to " + getRecipient() + ": " + emailMessage);
    }
}


class SMSNotification extends Notification {
    private String smsMessage;

    public SMSNotification(String recipient, String smsMessage) {
        super(recipient);
        if (smsMessage == null || smsMessage.isEmpty()) {
            throw new IllegalArgumentException("SMS message cannot be empty!");
        }
        this.smsMessage = smsMessage;
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + getRecipient() + ": " + smsMessage);
    }
}


class PushNotification extends Notification {
    private String pushMessage;

    public PushNotification(String recipient, String pushMessage) {
        super(recipient);
        if (pushMessage == null || pushMessage.isEmpty()) {
            throw new IllegalArgumentException("Push message cannot be empty!");
        }
        this.pushMessage = pushMessage;
    }

    @Override
    public void send() {
        System.out.println("Sending Push Notification to " + getRecipient() + ": " + pushMessage);
    }
}

public class NotificationSystem{
    public static void main(String[] args) {
        try {
            Notification email = new EmailNotification("razzmonster122@gmail.com", "Hello MR. Raj!");
            Notification sms = new SMSNotification("9866337220", "Your OTP is 1234");
            Notification push = new PushNotification("Raj", "You have a new alert");


            email.send();
            sms.send();
            push.send();


            Notification bad = new EmailNotification("", "This will fail");
            bad.send();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
