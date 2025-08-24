
abstract class Account {
    private String username;
    private String password;

    public Account(String username, String password) throws Exception {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new Exception("Username or password cannot be null/empty!");
        }
        this.username = username;
        this.password = password;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    public abstract void login(String user, String pass) throws Exception;
}

class GoogleAccount extends Account {
    public GoogleAccount(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String user, String pass) throws Exception {
        if (getUsername().equals(user) && getPassword().equals(pass)) {
            System.out.println("Google login successful!");
        } else {
            throw new Exception("Google login failed!");
        }
    }
}

class FacebookAccount extends Account {
    public FacebookAccount(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String user, String pass) throws Exception {
        if (getUsername().equals(user) && getPassword().equals(pass)) {
            System.out.println("Facebook login successful!");
        } else {
            throw new Exception("Facebook login failed!");
        }
    }
}

class TwitterAccount extends Account {
    public TwitterAccount(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String user, String pass) throws Exception {
        if (getUsername().equals(user) && getPassword().equals(pass)) {
            System.out.println("Twitter login successful!");
        } else {
            throw new Exception("Twitter login failed!");
        }
    }
}

public class AccountLoginSystem {
    public static void main(String[] args) {
        try {
            Account g = new GoogleAccount("sandesh", "1234");
            Account f = new FacebookAccount("ram", "abcd");
            Account t = new TwitterAccount("sita", "xyz");

            g.login("sandesh", "1234");
            f.login("ram", "abcd");
            t.login("sita", "xyz");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
