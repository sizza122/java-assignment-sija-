
abstract class User {
    private String username;
    private String password;

    public User(String username, String password) throws Exception {
        if (username == null || password == null) {
            throw new Exception("Username and password cannot be null!");
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public abstract void login(String enteredPassword) throws Exception;
}

class Admin extends User {
    public Admin(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String enteredPassword) throws Exception {
        if (checkPassword(enteredPassword)) {
            System.out.println("Admin " + getUsername() + " logged in successfully!");
        } else {
            throw new Exception("Invalid credentials for Admin!");
        }
    }
}

class Editor extends User {
    public Editor(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String enteredPassword) throws Exception {
        if (checkPassword(enteredPassword)) {
            System.out.println("Editor " + getUsername() + " logged in successfully!");
        } else {
            throw new Exception("Invalid credentials for Editor!");
        }
    }
}

class Viewer extends User {
    public Viewer(String username, String password) throws Exception {
        super(username, password);
    }

    @Override
    public void login(String enteredPassword) throws Exception {
        if (checkPassword(enteredPassword)) {
            System.out.println("Viewer " + getUsername() + " logged in successfully!");
        } else {
            throw new Exception("Invalid credentials for Viewer!");
        }
    }
}

public class UserLoginSystem {
    public static void main(String[] args) {
        try {
            User admin = new Admin("adminUser", "1234");
            User editor = new Editor("editUser", "abcd");
            User viewer = new Viewer("viewUser", "pass");

            admin.login("1234");
            editor.login("wrong");
            viewer.login("pass");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
